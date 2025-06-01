package main.java.proiect.services;

import main.java.proiect.repository.RamRepository;
import  main.java.proiect.config.ConnectionProvider;
import main.java.proiect.components.RAM;
import main.java.proiect.exceptions.RamNotFound;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class RamService {
    private final RamRepository ramRepository = RamRepository.getInstance();

    public RamService() {}

    public void insertData(RAM ram) {
        try (Connection connection = ConnectionProvider.getConnection()) {
            ramRepository.insertData(connection, ram);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<RAM> getRamByName(String name) {
        if (name == null || name.isBlank()) {
            name = "";
        }
        List<RAM> rams = ramRepository.getRamByName(ConnectionProvider.getConnection(), name);
        if(rams.isEmpty()) {
            throw new RamNotFound();
        } else {
            return rams;
        }
    }

    public void updateRam(long id, RAM ram) {
        try (Connection connection = ConnectionProvider.getConnection()) {
            ramRepository.updateRam(connection, id, ram);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteRam(long id) {
        try (Connection connection = ConnectionProvider.getConnection()) {
            ramRepository.deleteRam(connection, id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
