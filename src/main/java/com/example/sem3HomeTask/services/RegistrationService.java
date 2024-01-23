package com.example.sem3HomeTask.services;

import com.example.sem3HomeTask.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Сервис, отвечающий за регистрацию пользователей
 * При использовании работы других сервисов-создание, добавление в список,отправка уведомлений.
 */
@Service
public class RegistrationService {

    private final UserService userService;
    private final NotificationService notificationService;
    private final DataProcessingService dataProcessingService;

    /**
     * Создает экземпляр сервиса регистрации
     * @param userService -Сервис создания  пользователей
     * @param notificationService -Сервис уведомлений
     * @param dataProcessingService -Сервис для работы с данными
     */
    @Autowired
    public RegistrationService(UserService userService, NotificationService notificationService, DataProcessingService dataProcessingService) {
        this.userService = userService;
        this.notificationService = notificationService;
        this.dataProcessingService = dataProcessingService;
    }

    /**
     * @processRegistration -метод создания нового пользователя
     * @dataProcessingService.addUserToList -добавляем пользователя в хранилище
     * оповещает пользователя
     * @notificationService - сервис уведомлений
     */
    public User processRegistration(String name, int age, String email) {
        User newUser = userService.createUser(name, age, email);
        dataProcessingService.addUserToList(newUser);
        notificationService.notifyUser(newUser);
        return newUser;
    }

    public DataProcessingService getDataProcessingService() {
        return dataProcessingService;
    }

    /**
     * Вывод всех пользователей, зарегистрированных в системе
     */
    public List<User> getAllUsers() {
        return dataProcessingService.getRepository().getUsers();
    }
}
