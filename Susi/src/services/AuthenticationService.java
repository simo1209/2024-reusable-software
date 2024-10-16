package src.services;

import src.records.Account;
import java.util.Optional;

public interface AuthenticationService {
    Optional<Account> authenticate(String email, String password);
}

