package com.example.sender.model.MessagePattern.service;

import com.example.sender.model.MessagePattern.service.dto.MessagePatternDto;
import com.example.sender.model.MessagePattern.service.dto.MessagePatternMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MessagePatternService {
    @Autowired
    MessagePatternRepository messagePatternRepository;

    public MessagePatternDto add(MessagePatternDto m) {
        return MessagePatternMapper.toDto(messagePatternRepository.save(MessagePatternMapper.fromDto(m)));
    }

    public MessagePatternDto update(MessagePatternDto m, Long id) {
        MessagePatternDto mP = MessagePatternMapper.toDto(messagePatternRepository.findById(id).orElse(null));
        if(mP.equals(null)) {return null;}
        mP.setTemplate(m.getTemplate());
        return add(mP);
    }

    public void delete(Long id) {
        messagePatternRepository.deleteById(id);
    }

    public MessagePatternDto getById(Long id) {
        return MessagePatternMapper.toDto(messagePatternRepository.findById(id).orElse(null));
    }

    public List<MessagePatternDto> getAll() {
        return messagePatternRepository.findAll()
                .stream().map(MessagePatternMapper::toDto).collect(Collectors.toList());
    }
}
