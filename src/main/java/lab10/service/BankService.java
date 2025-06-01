package main.java.lab10.service;

import main.java.lab10.config.ConnectionProvider;
import exceptions.ClientNotFoundException;
import main.java.lab10.repository.BankRepository;
import models.Client;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Optional;

public class BankService {

    private final BankRepository bankRepository = BankRepository.getInstance();

    public BankService() {}

    public void insertData(Client client) {
        try (Connection connection = ConnectionProvider.getConnection()) {
            bankRepository.insertData(connection, client);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Client getClientById(long id) {
        Optional<Client> client = bankRepository.getClientById(ConnectionProvider.getConnection(), id);
        return client.orElseThrow(ClientNotFoundException::new);
    }

    public void updateClient(long id, Client client) {
        try (Connection connection = ConnectionProvider.getConnection()) {
            bankRepository.updateClient(connection, id, client);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteClient(long id) {
        try (Connection connection = ConnectionProvider.getConnection()) {
            bankRepository.deleteClient(connection, id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void cleanUp() {
        try (Connection connection = ConnectionProvider.getConnection()) {
            bankRepository.cleanUp(connection);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
