package main.java.lab10.repository;

import models.BankAccount;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class AccountRepository {
    private static AccountRepository instance;

    private AccountRepository() {}

    public static AccountRepository getInstance() {
        if (instance == null) {
            instance = new AccountRepository();
        }
        return instance;
    }

    public void insertData(Connection connection, BankAccount account) {

        String sql = """
                    INSERT INTO bank_accounts ( name, balance, active_status, client_id)
                    VALUES ( ?, ?, ?, ?)
                    """;

        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, account.getName());
            ps.setDouble(2, account.getBalance());
            ps.setBoolean(3, account.isActiveStatus());
            ps.setLong(4, account.getClientId());

            int insertedRows =  ps.executeUpdate();
            System.out.println("Inserted " + insertedRows + " rows");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Optional<BankAccount> getAccountById(Connection connection, long id) {
        String sql = """
                SELECT * 
                FROM bank_accounts 
                WHERE id = ?
                """;

        try (PreparedStatement ps = connection.prepareStatement(sql))
        {
            ps.setLong(1, id);
            try (ResultSet result = ps.executeQuery())
            {
                if (result.next()) {
                    return Optional.of(new BankAccount(
                            id,
                            result.getString("name"),
                            result.getDouble("balance"),
                            result.getBoolean("active_status"),
                            result.getLong("client_id")
                    ));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return Optional.empty();
    }
    // (long id, String name, double balance, boolean activeStatus, long clientId)
    public void updateAccount(Connection connection, long id, BankAccount account) {
        String sql = """
                UPDATE bank_accounts
                SET name = ?, balance = ?, active_status = ?,  client_id = ? 
                WHERE id = ?
                """;
        try(PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setString(1, account.getName());
            ps.setDouble(2, account.getBalance());
            ps.setBoolean(3, account.isActiveStatus());
            ps.setLong(4, account.getClientId());
            ps.setLong(5, id);

            ps.executeUpdate();
            System.out.println("Updated row with id:" + id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteAccount(Connection connection, long id) {
        String sql = """
                DELETE FROM bank_accounts
                WHERE id = ?
                """;
        try(PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setLong(1,id);
            ps.executeUpdate();
            System.out.println("Deleted row with id:" + id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public void cleanUp(Connection connection) {
        String sql = """
                DELETE FROM bank_accounts
                """;
        try (PreparedStatement ps = connection.prepareCall(sql)){
            int deletedRows =  ps.executeUpdate();
            System.out.println("Deleted " + deletedRows + " rows");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
