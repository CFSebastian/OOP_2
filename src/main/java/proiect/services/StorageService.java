package main.java.proiect.services;

import main.java.proiect.config.ConnectionProvider;
import main.java.proiect.components.Storage;
import main.java.proiect.exceptions.StorageNotFound;
import main.java.proiect.repository.StorageRepository;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class StorageService {

    private final StorageRepository storageRepository = StorageRepository.getInstance();

    public StorageService() {}


    public void insertData(Storage storage) {

        try (Connection connection = ConnectionProvider.getConnection()) {
            storageRepository.insertData(connection, storage);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Storage> getStorageByName(String name) {
        if (name == null || name.isBlank()) {
            name = "";
        }
        List<Storage>  storageList = storageRepository.getStorageByName(ConnectionProvider.getConnection(), name);
        if(storageList.isEmpty()) {
            throw new StorageNotFound();
        } else {
            return storageList;
        }
        //return storageList;
    }

    public void updateStorage(long id, Storage storage) {
        try (Connection connection = ConnectionProvider.getConnection()) {
            storageRepository.updateStorage(connection, id, storage);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteStorage(long id) {
        try (Connection connection = ConnectionProvider.getConnection()) {
            storageRepository.deleteStorage(connection, id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
