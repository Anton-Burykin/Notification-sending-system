package com.example.sender.model.MessageInfo.service;

import com.example.sender.model.MessageInfo.service.dto.MessageInfoDto;
import com.example.sender.model.MessageInfo.service.dto.MessageInfoMapper;
import com.example.sender.model.MessagePattern.service.MessagePatternService;
import com.example.sender.model.Person.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Service
public class MessageInfoService {
    @Autowired
    MessageInfoRepository messageInfoRepository;
    @Autowired
    PersonService personService;
    @Autowired
    MessagePatternService messagePatternService;

    public MessageInfoDto add(MessageInfoDto m) {
        m.setPerson(personService.getById(m.getPerson().getId()));
        m.setPattern(messagePatternService.getById(m.getPattern().getId()));
        return MessageInfoMapper.toDto(messageInfoRepository.save(MessageInfoMapper.fromDto(m)));
    }

    public MessageInfoDto update(MessageInfoDto m, Long id) {
        MessageInfoDto mI = MessageInfoMapper.toDto(messageInfoRepository.findById(id).orElse(null));
        if (mI.equals(null)) {
            return null;
        }
        mI.setPerson(m.getPerson());
        mI.setDate(m.getDate());
        mI.setPattern(m.getPattern());
        mI.setZoneId(m.getZoneId());
        mI.setStatus(m.isStatus());

        return add(mI);
    }

    public void delete(Long id) {
        messageInfoRepository.deleteById(id);
    }

    public MessageInfoDto getById(Long id) {
        return MessageInfoMapper.toDto(messageInfoRepository.findById(id).orElse(null));
    }

    public List<MessageInfoDto> getAll() {
        return messageInfoRepository.findAll().stream().map(MessageInfoMapper::toDto).collect(Collectors.toList());
    }

    public List<MessageInfoDto> getMessageInfoByDateBeforeAndStatusFalse(Long date) {
        return messageInfoRepository.getMessageInfoByDateBeforeAndStatusFalse(date)
                .stream().map(MessageInfoMapper::toDto).collect(Collectors.toList());
    }
}
