package com.example.sender.controller.apies;


import com.example.sender.model.MessageInfo.service.dto.MessageInfoDto;
import com.example.sender.util.SimpleResponse;
import com.example.sender.model.Person.service.PersonService;
import com.example.sender.model.Person.service.dto.PersonDto;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/person")
public class PersonApi {

    private final PersonService personService;

    @GetMapping("/all")
    public SimpleResponse<?> findAll() {
        return new SimpleResponse<>(personService.getAll());
    }

    @GetMapping("/{id}")
    public SimpleResponse<?> getById(@PathVariable Long id) {
        PersonDto pDto = personService.getById(id);
        if (pDto.equals(null)) {
            return new SimpleResponse<>(HttpStatus.NOT_FOUND);
        }
        return new SimpleResponse<>(pDto);
    }


    @PostMapping("/create")
    public SimpleResponse<?> addPerson(@RequestBody @NonNull PersonDto body) {
        return new SimpleResponse<>(personService.add(body));
    }

    @PutMapping("/{id}/update")
    public SimpleResponse<?> updatePerson(@RequestBody @NonNull PersonDto body, @PathVariable Long id) {
        PersonDto person = personService.update(body, id);
        if (person.equals(null)) {
            return new SimpleResponse<>(HttpStatus.NOT_FOUND);
        }
        return new SimpleResponse<>(person);
    }

    @DeleteMapping("/{id}/delete")
    public SimpleResponse<?> deletePersonById(@PathVariable Long id) {
        personService.deleteById(id);
        return new SimpleResponse<>(HttpStatus.OK);
    }
}
