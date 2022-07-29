package com.example.sender.model.Statistic.service.dto;

import com.example.sender.util.DateParser;
import com.example.sender.model.Person.service.dto.PersonMapper;
import com.example.sender.model.Statistic.Statistic;
import lombok.val;
import org.springframework.stereotype.Service;

public class StatisticMapper {
    public static StatisticDto mapToStatisticDto (Statistic statistic){
        val dto = new StatisticDto();
        dto.setId(statistic.getId());
        dto.setPersonDto(PersonMapper.toDto(statistic.getPerson()));
        dto.setMessage(statistic.getMessage());
        dto.setEmail(statistic.isEmail());
        dto.setTelegram(statistic.isTelegram());
        dto.setNumber(statistic.getNumber());
        dto.setDate(DateParser.toLocalDateTimeUTC(statistic.getDate()));
        return dto;
    }
    public static Statistic mapToStatisticFromDto(StatisticDto dto){
        val statistic = new Statistic();
        statistic.setId(dto.getId());
        statistic.setPerson(PersonMapper.fromDto(dto.getPersonDto()));
        statistic.setMessage(dto.getMessage());
        statistic.setEmail(dto.isEmail());
        statistic.setTelegram(dto.isTelegram());
        statistic.setNumber(dto.getNumber());
        statistic.setDate(DateParser.toEpochMilli(dto.getDate()));
        return statistic;
    }
}
