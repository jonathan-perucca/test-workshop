package com.example.unitcase.bank;

public interface AuthorizationService {

    boolean isAuthorized(Account account);

    Object doSomething(Account account);
}
