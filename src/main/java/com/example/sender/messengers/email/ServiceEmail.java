package com.example.sender.messengers.email;

import com.example.sender.senderServices.messageBuilder.MessageBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ServiceEmail {

    @Autowired
    public JavaMailSender emailSender;

    public List<MessageBuilder.Message> sendEmail(List<MessageBuilder.Message> m) {
        for(MessageBuilder.Message message : m){
            SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
            simpleMailMessage.setTo(message.getMessageInfoDto().getPerson().getContactInfoDto().getEmail());
            simpleMailMessage.setSubject("Message from " + message.getMessageInfoDto().getPerson().getName());
            simpleMailMessage.setText(message.getMessageInfoDto().getPattern().getTemplate());
            try{
                emailSender.send(simpleMailMessage);
                message.setEmail(true);
            }catch (MailException e){
                e.printStackTrace();
            }
        }
        return m;
    }
}
