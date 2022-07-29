package com.example.sender.model.ContactInfo.service.dto;


import com.example.sender.model.ContactInfo.ContactInfo;

public class ContactInfoMapper {
    public static ContactInfoDto toDto(ContactInfo contactInfo){
        ContactInfoDto cI = new ContactInfoDto();
        cI.setId(contactInfo.getId());
        cI.setEmail(contactInfo.getEmail());
        cI.setTelegramName(contactInfo.getTelegramName());
        cI.setNumber(contactInfo.getNumber());
        return cI;
    }
    public static ContactInfo fromDto(ContactInfoDto contactInfoDto){

        ContactInfo cI = new ContactInfo();
        cI.setId(contactInfoDto.getId());
        cI.setNumber(contactInfoDto.getNumber());
        cI.setEmail(contactInfoDto.getEmail());
        cI.setTelegramName(contactInfoDto.getTelegramName());
        return cI;
    }
}
