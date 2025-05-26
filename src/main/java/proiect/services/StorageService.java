package main.java.proiect.services;

import config.ConnectionProvider;
import main.java.proiect.components.Storage;
import main.java.proiect.exceptions.StorageNotFound;
import main.java.proiect.repository.StorageRepository;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Optional;

public class StorageService {

    private final StorageRepository storageRepository = StorageRepository.getInstance();

    public StorageService() {}


    public void insertData(Storage storage) {
        try (Connection connection = config.ConnectionProvider.getConnection()) {
            storageRepository.insertData(connection, storage);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Storage getGraphicsCardById(long id) {
        Optional<Storage> storage = storageRepository.getStorageById(config.ConnectionProvider.getConnection(), id);
        return storage.orElseThrow(StorageNotFound::new);
    }

    public void updateGraphicsCard(long id, Storage storage) {
        try (Connection connection = config.ConnectionProvider.getConnection()) {
            storageRepository.updateStorage(connection, id, storage);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteGraphicsCard(long id) {
        try (Connection connection = config.ConnectionProvider.getConnection()) {
            storageRepository.deleteStorage(connection, id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
