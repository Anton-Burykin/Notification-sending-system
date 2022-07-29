package com.example.sender.controller.apies;

import com.example.sender.util.SimpleResponse;
import com.example.sender.model.MessageInfo.service.MessageInfoService;
import com.example.sender.model.MessageInfo.service.dto.MessageInfoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/messageInfo")
public class MessageInfoApi {
    @Autowired
    MessageInfoService messageInfoService;

    @PostMapping("/add")
    public SimpleResponse<?> add(@RequestBody @NonNull MessageInfoDto m) {
        return new SimpleResponse<>(messageInfoService.add(m));
    }

    @PutMapping("/{id}/update")
    public SimpleResponse<?> update(@RequestBody @NonNull MessageInfoDto m, @PathVariable Long id) {
        MessageInfoDto mI = messageInfoService.update(m,id);
        if(mI.equals(null)){return new SimpleResponse<>(HttpStatus.NOT_FOUND);}
        return new SimpleResponse<>(mI);
    }

    @DeleteMapping("/{id}/delete")
    public SimpleResponse<?> delete(@PathVariable Long id) {
        messageInfoService.delete(id);
        return new SimpleResponse<>(HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public SimpleResponse<?> getById(@PathVariable Long id) {
        MessageInfoDto mIDto = messageInfoService.getById(id);
        if (mIDto.equals(null)) {
            return new SimpleResponse<>(HttpStatus.NOT_FOUND);
        }
        return new SimpleResponse<>(mIDto);
    }
    @GetMapping("/all")
    public SimpleResponse<?> findAll() {
        return new SimpleResponse<>(messageInfoService.getAll());
    }
}
