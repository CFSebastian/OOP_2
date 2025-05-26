package main.java.proiect.services;

import main.java.proiect.repository.RamRepository;
import config.ConnectionProvider;
import main.java.proiect.components.RAM;
import main.java.proiect.exceptions.RamNotFound;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Optional;

public class RamService {
    private final RamRepository ramRepository = RamRepository.getInstance();

    public RamService(RamRepository ramRepository) {}

    public void insertData(RAM ram) {
        try (Connection connection = ConnectionProvider.getConnection()) {
            ramRepository.insertData(connection, ram);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public RAM getGraphicsCardById(long id) {
        Optional<RAM> ram = ramRepository.getRamById(ConnectionProvider.getConnection(), id);
        return ram.orElseThrow(RamNotFound::new);
    }

    public void updateGraphicsCard(long id, RAM ram) {
        try (Connection connection = ConnectionProvider.getConnection()) {
            ramRepository.updateRam(connection, id, ram);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteGraphicsCard(long id) {
        try (Connection connection = ConnectionProvider.getConnection()) {
            ramRepository.deleteRam(connection, id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
