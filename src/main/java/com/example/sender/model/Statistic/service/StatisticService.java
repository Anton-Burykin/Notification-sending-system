package com.example.sender.model.Statistic.service;

import com.example.sender.model.Person.service.dto.PersonMapper;
import com.example.sender.model.Statistic.service.dto.StatisticDto;
import com.example.sender.model.Statistic.service.dto.StatisticMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class StatisticService {

    @Autowired
    StatisticRepository statisticRepo;

    public List<StatisticDto> getAll() {
        return statisticRepo.findAll()
                .stream()
                .map(StatisticMapper::mapToStatisticDto)
                .sorted(Comparator.comparing(StatisticDto::getDate))
                .collect(Collectors.toList());
    }

    public StatisticDto getById(Long id) {
        return StatisticMapper.mapToStatisticDto(Objects.requireNonNull(statisticRepo.findById(id).orElse(null)));
    }

    public StatisticDto add(StatisticDto s) {
        return StatisticMapper.mapToStatisticDto(statisticRepo.save(StatisticMapper.mapToStatisticFromDto(s)));
    }

    public void delete(Long id) {
        statisticRepo.deleteById(id);
    }

    public StatisticDto update(StatisticDto s, Long id) {
        StatisticDto sD = StatisticMapper.mapToStatisticDto(Objects.requireNonNull(statisticRepo.findById(id)
                .orElse(null)));
        sD.setPersonDto(s.getPersonDto());
        sD.setMessage(s.getMessage());
        sD.setEmail(s.isEmail());
        sD.setTelegram(s.isTelegram());
        sD.setNumber(s.getNumber());
        sD.setDate(s.getDate());
        return add(sD);
    }

    public List<StatisticDto> getByEmail() {
        return statisticRepo.findAll()
                .stream()
                .map(StatisticMapper::mapToStatisticDto)
                .filter(StatisticDto::isEmail)
                .sorted(Comparator.comparing(StatisticDto::getDate))
                .collect(Collectors.toList());
    }

    public List<StatisticDto> getByTelegram() {
        return statisticRepo.findAll()
                .stream()
                .map(StatisticMapper::mapToStatisticDto)
                .filter(StatisticDto::isTelegram)
                .sorted(Comparator.comparing(StatisticDto::getDate))
                .collect(Collectors.toList());
    }

    public List<StatisticDto> getByPersonId(Long id) {
        return statisticRepo.findAll()
                .stream()
                .map(StatisticMapper::mapToStatisticDto)
                .filter(StatisticDto -> Objects.requireNonNull(PersonMapper.fromDto(StatisticDto.getPersonDto())).getId().equals(id))
                .sorted(Comparator.comparing(StatisticDto::getDate))
                .collect(Collectors.toList());
    }

    //Из MessageBuilder
    public List<StatisticDto> addAll(List<StatisticDto> sDto) {
        return sDto.stream()
                .map(this::add)
                .collect(Collectors.toList());
    }

}
