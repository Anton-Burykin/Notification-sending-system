package com.example.sender.model.MessagePattern.service;

import com.example.sender.model.MessagePattern.MessagePattern;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessagePatternRepository extends JpaRepository<MessagePattern,Long> {
}
