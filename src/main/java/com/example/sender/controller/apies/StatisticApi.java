package com.example.sender.controller.apies;

import com.example.sender.util.SimpleResponse;
import com.example.sender.model.Statistic.service.StatisticService;
import com.example.sender.model.Statistic.service.dto.StatisticDto;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/statistic")
public class StatisticApi {
    @Autowired
    StatisticService service;

    @GetMapping("/{id}")
    public SimpleResponse<?> getById(@PathVariable("id") Long id){
        StatisticDto sDto = service.getById(id);
        if(sDto.equals(null)){
            return new SimpleResponse<>(HttpStatus.NOT_FOUND);
        }
        return new SimpleResponse<>(sDto);
    }
    @GetMapping("/all")
    public SimpleResponse<?> findAll() {
        return new SimpleResponse<>(service.getAll());
    }

    @PostMapping("/add")
    public SimpleResponse<?> add(@RequestBody @NonNull StatisticDto body){
        return new SimpleResponse<>(service.add(body));
    }

    @PutMapping("/{id}/delete")
    public SimpleResponse<?> delete(@PathVariable Long id){
        service.delete(id);
        return new SimpleResponse<>(HttpStatus.OK);
    }

    @PutMapping("/{id}/update")
    public SimpleResponse<?> update(@RequestBody @NonNull StatisticDto body, @PathVariable Long id){
        StatisticDto sDto = service.update(body, id);
        if(sDto.equals(null)){
            return new SimpleResponse<>(HttpStatus.NOT_FOUND);
        }
        return new SimpleResponse<>(HttpStatus.OK);
    }

    @GetMapping("/allByEmail")
    public SimpleResponse<?> findByEmail(){
        List<StatisticDto> sDto = service.getByEmail();
        if(sDto.equals(null)){
            return new SimpleResponse<>(HttpStatus.NOT_FOUND);
        }
        return new  SimpleResponse<>(sDto);
    }

    @GetMapping("/allByTelegram")
    public SimpleResponse<?> findByTelegram(){
        List<StatisticDto> sDto = service.getByTelegram();
        if(sDto.equals(null)){
            return new SimpleResponse<>(HttpStatus.NOT_FOUND);
        }
        return new  SimpleResponse<>(sDto);
    }

    @GetMapping("/person/{id}")
    public SimpleResponse<?> findByPersonName(@PathVariable Long id){
        List<StatisticDto> sDto = service.getByPersonId(id);
        if(sDto.equals(null)){
            return new SimpleResponse<>((HttpStatus.NOT_FOUND));
        }
        return new SimpleResponse<>(sDto);
    }

    @PostMapping("/addAll")
    public SimpleResponse<?> addAll(@RequestBody @NonNull List<StatisticDto> body){
        return new SimpleResponse<>(service.addAll(body));
    }

}
