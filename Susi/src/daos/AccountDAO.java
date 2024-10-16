package src.daos;

import src.records.Account;
import java.util.Optional;
import java.util.UUID;

public interface AccountDAO {
    Optional<Account> findByEmail(String email);

    void saveAccount(Account account);

    void updatePassword(UUID accountId, String password);
}

