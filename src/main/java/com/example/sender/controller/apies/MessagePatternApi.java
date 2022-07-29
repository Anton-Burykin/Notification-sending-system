package com.example.sender.controller.apies;

import com.example.sender.util.SimpleResponse;
import com.example.sender.model.MessagePattern.service.MessagePatternService;
import com.example.sender.model.MessagePattern.service.dto.MessagePatternDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/messagePattern")
public class MessagePatternApi {
    @Autowired
    MessagePatternService messagePatternService;

    @PostMapping("/add")
    public SimpleResponse<?> add(@RequestBody @NonNull MessagePatternDto m) {
        return new SimpleResponse<>(messagePatternService.add(m));
    }

    @PutMapping("/{id}/update")
    public SimpleResponse<?> update(@RequestBody @NonNull MessagePatternDto m, @PathVariable Long id) {
        MessagePatternDto mP = messagePatternService.update(m, id);
        if(mP.equals(null)){return new SimpleResponse<>(HttpStatus.NOT_FOUND);}
        return new SimpleResponse<>(mP);
    }

    @DeleteMapping("/{id}/delete")
    public SimpleResponse<?> delete(@PathVariable Long id) {
        messagePatternService.delete(id);
        return new SimpleResponse<>(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public SimpleResponse<?> getById(@PathVariable Long id) {
        MessagePatternDto mDto = messagePatternService.getById(id);
        if (mDto.equals(null)) {
            return new SimpleResponse<>(HttpStatus.NOT_FOUND);
        }
        return new SimpleResponse<>(mDto);
    }

    @GetMapping("/all")
    public SimpleResponse<?> findAll() {
        return new SimpleResponse<>(messagePatternService.getAll());
    }
}
