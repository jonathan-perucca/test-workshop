package com.example.unitcase.practice;

import com.example.unitcase.pratice.Broker;
import com.example.unitcase.pratice.MailSender;
import com.example.unitcase.pratice.UserCreationService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static com.example.unitcase.pratice.Role.ADMIN;
import static com.example.unitcase.pratice.Role.USER;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyZeroInteractions;

@RunWith(MockitoJUnitRunner.class)
public class UserCreationServiceTest {

    @InjectMocks
    UserCreationService userCreationService;

    @Mock
    Broker mockBroker;

    @Mock
    MailSender mockMailSender;

    @Test
    public void should_subscribe_user_as_user_role() {
        userCreationService.subscribeUser("login", USER);

        verify(mockBroker).sendMessage(anyString(), anyString());
        verifyZeroInteractions(mockMailSender);
    }

    @Test
    public void should_subscribe_user_as_admin_role() {
        userCreationService.subscribeUser("admin", ADMIN);

        verify(mockBroker).sendMessage(anyString(), anyString());
        verify(mockMailSender).sendMail(anyString());
    }
}