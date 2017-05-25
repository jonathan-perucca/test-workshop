package com.example.unitcase.bank;

public class BankAccountService {

    private AuthorizationService authorizationService;

    public BankAccountService(AuthorizationService authorizationService) {
        this.authorizationService = authorizationService;
    }

    public void updateMoney(Account account, int amount) {
        if (account == null)
            throw new IllegalArgumentException();

        if (!authorizationService.isAuthorized(account))
            throw new NotAuthorizedException();

        int newBalance = account.getBalance() + amount;

        if (newBalance < 0)
            throw new CreditNotAuthorizedException();

        account.setBalance(newBalance);
    }

    public void doSomething() {
        Account account = new Account();
        account.setBalance(99);

        authorizationService.doSomething(account);
    }
}
