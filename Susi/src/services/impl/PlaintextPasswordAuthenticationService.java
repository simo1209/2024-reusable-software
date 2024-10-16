package src.services.impl;

import src.daos.AccountDAO;
import src.records.Account;
import src.services.AuthenticationService;

import java.util.Optional;

public class PlaintextPasswordAuthenticationService implements AuthenticationService {
    private final AccountDAO accountDAO;

    public PlaintextPasswordAuthenticationService(AccountDAO accountDAO) {
        this.accountDAO = accountDAO;
    }

    @Override
    public Optional<Account> authenticate(String email, String password) {
        Optional<Account> accountOpt = accountDAO.findByEmail(email);

        if (accountOpt.isPresent()) {
            Account account = accountOpt.get();
            // Compare the plain text password directly (not recommended for production use)
            if (account.password().equals(password)) {
                return Optional.of(account);
            } else {
                System.out.println("Invalid password.");
            }
        } else {
            System.out.println("Account not found.");
        }
        return Optional.empty();
    }
}

