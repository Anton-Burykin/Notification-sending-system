package com.example.sender.senderServices.handler;

import com.example.sender.util.DateParser;
import com.example.sender.model.MessageInfo.service.MessageInfoService;
import com.example.sender.model.MessageInfo.service.dto.MessageInfoDto;
import com.example.sender.senderServices.messageBuilder.MessageBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.ZoneId;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@EnableScheduling
public class Handler {
    private final Long DELAY = 600000L;
    @Autowired
    MessageInfoService mIS;
    @Autowired
    MessageBuilder mb;
    Set<MessageInfoDto> mHS = new HashSet<>();

    @Scheduled(fixedRate = 60000)
    private void handler() {
        mHS.addAll(mIS.getMessageInfoByDateBeforeAndStatusFalse(takeTimeAfter()));
    }

    private Long takeTimeAfter() {
        return System.currentTimeMillis() + DELAY;
    }

    @Scheduled(fixedRate = 1000)
    public void toMessageBuilder() {
        if (!mHS.isEmpty()) {
            sentMessage(mb.createListMessageInfoDto(mHS.stream()
                    .filter(i -> DateParser.fromLocalDateTime(i.getDate(), ZoneId.of(i.getZoneId()))
                            - System.currentTimeMillis() <= 1500)
                    .collect(Collectors.toSet())));
        }

    }

    public void sentMessage(List<MessageInfoDto> sM) {
        sM.stream()
                .peek(mHS::remove)
                .forEach(i -> mIS.update(i, i.getId()));
    }
}

