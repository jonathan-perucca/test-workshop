package com.example.unitcase.bank;

public class BankAccountService {

    private final AuthorizationService authorizationService;
    private final AccountRepository accountRepository;

    public BankAccountService(AuthorizationService authorizationService,
                              AccountRepository accountRepository) {
        this.authorizationService = authorizationService;
        this.accountRepository = accountRepository;
    }

    public void updateMoney(Integer accountId, int amount) {
        Account account = accountRepository.findById(accountId);
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
