package repository;

import models.Client;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class BankRepository {

    private static BankRepository instance;

    private BankRepository() {}

    public static BankRepository getInstance() {
        if (instance == null) {
            instance = new BankRepository();
        }
        return instance;
    }

    public void insertData(Connection connection, Client client) {

        String sql = """
                    INSERT INTO bank_clients ( name, address, active_status)
                    VALUES (?, ?, ?)
                    """;

        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            //ps.setLong(1, client.getId());
            ps.setString(1, client.getName());
            ps.setString(2, client.getAddress());
            ps.setBoolean(3, client.isActiveStatus());

            int insertedRows =  ps.executeUpdate();
            System.out.println("Inserted " + insertedRows + " rows");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Optional<Client> getClientById(Connection connection, long id) {
        String sql = """
                SELECT * 
                FROM bank_clients 
                WHERE id = ?
                """;

        try (PreparedStatement ps = connection.prepareStatement(sql))
        {
            ps.setLong(1, id);
            try (ResultSet result = ps.executeQuery())
            {
                if (result.next()) {
                    return Optional.of(new Client(
                            id,
                            result.getString("name"),
                            result.getString("address"),
                            result.getBoolean("active_status")
                    ));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return Optional.empty();
    }

    public void updateClient(Connection connection, long id, Client client) {
        String sql = """
                UPDATE bank_clients
                SET name = ?, address = ?, active_status = ? 
                WHERE id = ?
                """;
        try(PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setString(1, client.getName());
            ps.setString(2, client.getAddress());
            ps.setBoolean(3, client.isActiveStatus());
            ps.setLong(4, id);

            ps.executeUpdate();
            System.out.println("Updated row with id:" + id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteClient(Connection connection, long id) {
        String sql = """
                DELETE FROM bank_clients
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
                DELETE FROM bank_clients
                """;
        try (PreparedStatement ps = connection.prepareCall(sql)){
            int deletedRows =  ps.executeUpdate();
            System.out.println("Deleted " + deletedRows + " rows");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
