package src.daos;

import src.records.Administrator;
import java.util.List;
import java.util.UUID;

public interface AdministratorDAO {
    Administrator getAdministratorById(UUID id);
    Administrator getAdministratorByEGN(String egn);
    List<Administrator> getAllAdministrators();
    void addAdministrator(Administrator administrator);
}

