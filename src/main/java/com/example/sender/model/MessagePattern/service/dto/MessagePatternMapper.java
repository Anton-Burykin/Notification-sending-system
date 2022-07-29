package com.example.sender.model.MessagePattern.service.dto;

import com.example.sender.model.MessagePattern.MessagePattern;

public class MessagePatternMapper {
    public static MessagePatternDto toDto(MessagePattern messagePattern) {

        MessagePatternDto messagePatternDto = new MessagePatternDto();
        messagePatternDto.setTemplate(messagePattern.getTemplate());
        messagePatternDto.setId(messagePattern.getId());
        return messagePatternDto;
    }

    public static MessagePattern fromDto(MessagePatternDto messagePatternDto) {

        MessagePattern messagePattern = new MessagePattern();
        messagePattern.setTemplate(messagePatternDto.getTemplate());
        messagePattern.setId(messagePatternDto.getId());
        return messagePattern;
    }
}
