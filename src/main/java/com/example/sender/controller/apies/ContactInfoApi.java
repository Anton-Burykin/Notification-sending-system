package com.example.sender.controller.apies;


import com.example.sender.util.SimpleResponse;
import com.example.sender.model.ContactInfo.service.ContactInfoService;
import com.example.sender.model.ContactInfo.service.dto.ContactInfoDto;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/contacts")
public class ContactInfoApi {

    @Autowired
    ContactInfoService contactInfoService;

    @PostMapping("/create")
    public SimpleResponse<?> addContactInfo(@RequestBody @NonNull ContactInfoDto body) {
        return new SimpleResponse<>(contactInfoService.add(body));
    }

    @PutMapping("/{id}/update")
    public SimpleResponse<?> updateContactInfo(@RequestBody @NonNull ContactInfoDto body, @PathVariable Long id){
       ContactInfoDto cID = contactInfoService.update(body, id);
        return new SimpleResponse<>(cID);
    }

    @DeleteMapping("/{id}/delete")
    public SimpleResponse<?> deleteContactInfo(@PathVariable Long id){
        contactInfoService.delete(id);
        return new SimpleResponse<>(HttpStatus.OK);
    }


}
