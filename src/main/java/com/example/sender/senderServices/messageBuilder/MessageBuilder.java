package com.example.sender.senderServices.messageBuilder;

import com.example.sender.messengers.email.ServiceEmail;
import com.example.sender.messengers.telegram.service.Bot;
import com.example.sender.model.MessageInfo.service.dto.MessageInfoDto;
import com.example.sender.model.Person.service.dto.PersonMapper;
import com.example.sender.model.Statistic.service.StatisticService;
import com.example.sender.model.Statistic.service.dto.StatisticDto;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
@Service
public class MessageBuilder {

    private static final Logger logger = LoggerFactory.getLogger(MessageBuilder.class);

    @Autowired
    private StatisticService statisticService;
    @Autowired
    private Bot telegramBot;
    @Autowired
    private ServiceEmail serviceEmail;

    @Data
    public static class Message {
        private MessageInfoDto messageInfoDto;
        private boolean email = false;
        private boolean telegram = false;
    }

    public List<MessageInfoDto> createListMessageInfoDto(Set<MessageInfoDto> mIDto) {
        List<Message> messageListCreate = mIDto.stream()
                .map(messageInfoDto -> {
                    Message mes = new Message();
                    mes.setMessageInfoDto(messageInfoDto);
                    return mes;
                })
                .collect(Collectors.toList());

        messageListCreate = telegramBot.sendMessage(messageListCreate);
        messageListCreate = serviceEmail.sendEmail(messageListCreate);

        for (MessageBuilder.Message m : messageListCreate) {
            if (m.isEmail() || m.isTelegram()) {
                m.getMessageInfoDto().setStatus(true);
            }
        }
        returnedStatistics(messageListCreate);

        return returnedListMessageInfoDto(messageListCreate);
    }

    public List<MessageInfoDto> returnedListMessageInfoDto(List<Message> mes) {


        return mes.stream()
                .map(Message::getMessageInfoDto)
                .collect(Collectors.toList());
    }

    public void returnedStatistics(List<Message> mList) {
        logger.info(String.valueOf(mList));
        List<StatisticDto> sDto = mList.stream()
                .filter(message -> message.messageInfoDto.isStatus())
                .map(message -> {
                    StatisticDto statisticDto = new StatisticDto();
                    statisticDto.setPersonDto(message.getMessageInfoDto().getPerson());
                    statisticDto.setMessage(message.getMessageInfoDto().getPattern().getTemplate());
                    statisticDto.setEmail(message.isEmail());
                    statisticDto.setTelegram(message.isTelegram());
                    statisticDto.setNumber(message.messageInfoDto.getPerson().getContactInfoDto().getNumber());
                    statisticDto.setDate(message.messageInfoDto.getDate());
                    return statisticDto;
                })
                .collect(Collectors.toList());

        statisticService.addAll(sDto);
    }

}