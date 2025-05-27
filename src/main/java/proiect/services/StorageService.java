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

    public Storage getStorageByName(String name) {
        Optional<Storage> storage = storageRepository.getStorageByName(config.ConnectionProvider.getConnection(), name);
        return storage.orElseThrow(StorageNotFound::new);
    }

    public void updateStorage(long id, Storage storage) {
        try (Connection connection = config.ConnectionProvider.getConnection()) {
            storageRepository.updateStorage(connection, id, storage);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteStorage(long id) {
        try (Connection connection = config.ConnectionProvider.getConnection()) {
            storageRepository.deleteStorage(connection, id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
