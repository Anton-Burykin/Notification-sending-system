package com.example.sender.model.MessageInfo.service.dto;

import com.example.sender.model.MessagePattern.MessagePattern;
import com.example.sender.model.MessagePattern.service.dto.MessagePatternMapper;
import com.example.sender.model.Person.service.dto.PersonMapper;
import com.example.sender.util.DateParser;
import com.example.sender.model.MessageInfo.MessageInfo;

import java.time.ZoneId;

public class MessageInfoMapper {
    public static MessageInfoDto toDto(MessageInfo messageInfo) {
        MessageInfoDto messageInfoDto = new MessageInfoDto();
        messageInfoDto.setDate(DateParser.toLocalDateTime(messageInfo.getDate(),
                ZoneId.of(messageInfo.getZoneId())));
        messageInfoDto.setId(messageInfo.getId());
        messageInfoDto.setPattern(MessagePatternMapper.toDto(messageInfo.getPattern()));
        messageInfoDto.setPerson(PersonMapper.toDto(messageInfo.getPerson()));
        messageInfoDto.setStatus(messageInfo.isStatus());
        messageInfoDto.setZoneId(messageInfo.getZoneId());
        return messageInfoDto;
    }
        public static MessageInfo fromDto(MessageInfoDto messageInfoDto){
        MessageInfo messageInfo = new MessageInfo();
        messageInfo.setDate(DateParser.fromLocalDateTime(messageInfoDto.getDate(),
                ZoneId.of(messageInfoDto.getZoneId())));
        messageInfo.setId(messageInfoDto.getId());
        messageInfo.setPattern(MessagePatternMapper.fromDto(messageInfoDto.getPattern()));
        messageInfo.setPerson(PersonMapper.fromDto(messageInfoDto.getPerson()));
        messageInfo.setStatus(messageInfoDto.isStatus());
        messageInfo.setZoneId(messageInfoDto.getZoneId());
        return messageInfo;
    }

}
