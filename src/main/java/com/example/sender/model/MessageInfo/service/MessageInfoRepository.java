package com.example.sender.model.MessageInfo.service;

import com.example.sender.model.MessageInfo.MessageInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageInfoRepository extends JpaRepository<MessageInfo,Long> {

    List<MessageInfo> getMessageInfoByDateBeforeAndStatusFalse(Long date);
}

