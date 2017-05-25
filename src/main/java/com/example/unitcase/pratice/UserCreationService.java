package com.example.unitcase.pratice;

public class UserCreationService {

    private final Broker broker;
    private final MailSender mailSender;

    public UserCreationService(Broker broker,
                               MailSender mailSender) {
        this.broker = broker;
        this.mailSender = mailSender;
    }

    public void subscribeUser(String login, Role role) {
        broker.sendMessage("subscription", login);

        if (role == Role.ADMIN) {
            mailSender.sendMail(login);
        }
    }
}