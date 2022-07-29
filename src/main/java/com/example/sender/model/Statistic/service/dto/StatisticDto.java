package com.example.sender.model.Statistic.service.dto;

import com.example.sender.model.Person.service.dto.PersonDto;
import lombok.Data;
import java.time.LocalDateTime;

@Data
public class StatisticDto {
    private Long id;
    private PersonDto personDto;
    private String message;
    private boolean email;
    private boolean telegram;
    private Long number;
    private LocalDateTime date;
}
