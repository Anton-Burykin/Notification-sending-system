package com.example.sender.messengers.telegram.service;


import com.example.sender.messengers.telegram.config.BotConfig;
import com.example.sender.senderServices.messageBuilder.MessageBuilder;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.List;

@Component
@AllArgsConstructor
public class Bot extends TelegramLongPollingBot {

    private final BotConfig config;

    @Override
    public String getBotUsername() {
        return config.getBotName();
    }

    @Override
    public String getBotToken() {
        return config.getToken();
    }

    @Override
    public void onUpdateReceived(Update update) {

    }

        public List<MessageBuilder.Message> sendMessage(List<MessageBuilder.Message> mList) {

            for (MessageBuilder.Message m : mList) {
                SendMessage message = new SendMessage();
                message.setChatId(m.getMessageInfoDto().getPerson().getContactInfoDto().getTelegramName());
                message.setText(m.getMessageInfoDto().getPattern().getTemplate());
                try {
                    execute(message);
                    m.setTelegram(true);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            }
            return mList;
        }

    }

