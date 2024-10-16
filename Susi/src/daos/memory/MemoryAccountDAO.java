package src.daos.memory;

import src.daos.AccountDAO;
import src.records.Account;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

public class MemoryAccountDAO implements AccountDAO {
    private final Map<String, Account> accountsByEmail = new HashMap<>();
    private final Map<UUID, Account> accountsById = new HashMap<>();

    @Override
    public Optional<Account> findByEmail(String email) {
        return Optional.ofNullable(accountsByEmail.get(email));
    }

    @Override
    public void saveAccount(Account account) {
        accountsByEmail.put(account.email(), account);
        accountsById.put(account.id(), account);
    }

    @Override
    public void updatePassword(UUID accountId, String password) {
        Account account = accountsById.get(accountId);
        if (account != null) {
            Account updatedAccount = new Account(account.id(), account.email(), password, account.role(), account.idToRoleRecord());
            saveAccount(updatedAccount);
        }
    }
}

