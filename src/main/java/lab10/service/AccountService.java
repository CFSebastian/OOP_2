package main.java.lab10.service;

import main.java.lab10.config.ConnectionProvider;
import exceptions.AccountNotFoundException;
import models.BankAccount;
import main.java.lab10.repository.AccountRepository;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Optional;

public class AccountService {
    private final AccountRepository accountRepository = AccountRepository.getInstance();

    public AccountService() {}

    public void insertData(BankAccount account) {
        try (Connection connection = ConnectionProvider.getConnection()) {
            accountRepository.insertData(connection, account);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public BankAccount getAccountById(long id) {
        Optional<BankAccount> client = accountRepository.getAccountById(ConnectionProvider.getConnection(), id);
        return client.orElseThrow(AccountNotFoundException::new);
    }

    public void updateAccount(long id, BankAccount client) {
        try (Connection connection = ConnectionProvider.getConnection()) {
            accountRepository.updateAccount(connection, id, client);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteAccount(long id) {
        try (Connection connection = ConnectionProvider.getConnection()) {
            accountRepository.deleteAccount(connection, id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void cleanUp() {
        try (Connection connection = ConnectionProvider.getConnection()) {
            accountRepository.cleanUp(connection);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
