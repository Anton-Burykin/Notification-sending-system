package com.example.sender.model.ContactInfo.service;

import com.example.sender.model.ContactInfo.service.dto.ContactInfoDto;
import com.example.sender.model.ContactInfo.service.dto.ContactInfoMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactInfoService {

    @Autowired
    ContactInfoRepository contactInfoRepository;

    public ContactInfoDto add(ContactInfoDto body) {
        return ContactInfoMapper.toDto(contactInfoRepository.save(ContactInfoMapper.fromDto(body)));
    }

    public ContactInfoDto update(ContactInfoDto body, Long id) {

        ContactInfoDto cID = ContactInfoMapper.toDto(contactInfoRepository.findById(id).orElse(null));
        if (cID.equals(null)) {return null;}
        cID.setNumber(body.getNumber());
        cID.setEmail(body.getEmail());
        cID.setTelegramName(body.getTelegramName());
        return add(cID);
    }

    public void delete(Long id) {
        contactInfoRepository.deleteById(id);
    }


    public ContactInfoDto getById(Long id) {
        return ContactInfoMapper.toDto(contactInfoRepository.findById(id).orElse(null));
    }
}
