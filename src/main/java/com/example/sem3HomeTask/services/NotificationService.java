package com.example.sem3HomeTask.services;

import com.example.sem3HomeTask.domain.User;
import org.springframework.stereotype.Service;

/**
 * Сервис предоставляет методы для отправки уведомлений
 */
@Service
public class NotificationService {

    /**
     * Уведомляет о создании пользователя
     * @param user экземпляр пользователя, которого мы  уведомляем
     */
    public void notifyUser(User user) {
        System.out.println("A new user has been created: " + user.getName());
    }

    /**
     * Отправляет произвольное текстовое сообщение в стандартный вывод.
     * @param s Текстовое сообщение для отправки.
     */
    public void sendNotification(String s) {
        System.out.println(s);
    }
}