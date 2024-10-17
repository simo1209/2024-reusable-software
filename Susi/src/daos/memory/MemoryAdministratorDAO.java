package src.daos.memory;

import src.daos.AdministratorDAO;
import src.records.Administrator;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

public class MemoryAdministratorDAO implements AdministratorDAO {
    private final Map<UUID, Administrator> administratorById = new HashMap<>();
    private final Map<String, Administrator> administratorByEGN = new HashMap<>();

    @Override
    public Administrator getAdministratorById(UUID id) {
        return administratorById.get(id);
    }

    @Override
    public Administrator getAdministratorByEGN(String egn) {
        return administratorByEGN.get(egn);
    }

    @Override
    public List<Administrator> getAllAdministrators() {
        return List.copyOf(administratorById.values());
    }

    @Override
    public void addAdministrator(Administrator administrator) {
        administratorById.put(administrator.id(), administrator);
        administratorByEGN.put(administrator.egn(), administrator);
    }
}

