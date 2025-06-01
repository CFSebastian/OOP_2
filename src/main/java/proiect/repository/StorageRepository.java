package main.java.proiect.repository;


import main.java.proiect.components.Storage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class StorageRepository {
    private static StorageRepository instance;

    private StorageRepository() {}

    public static StorageRepository getInstance() {
        if (instance == null) {
            instance = new StorageRepository();
        }
        return instance;
    }

    public void insertData(Connection connection, Storage storage) {
        String sql = """
                INSERT INTO storages (name,price,power,storage) 
                VALUES (?,?,?,?)
                """;
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, storage.getName());
            ps.setDouble(2, storage.getPrice());
            ps.setInt(3, storage.getPower());
            ps.setInt(4, storage.getMemory());

            int insertedRows = ps.executeUpdate();
            System.out.println("Inserted " + insertedRows + " rows");

        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }

    public List<Storage> getStorageByName(Connection connection, String partialName) {
        String sql = """
                SELECT *
                FROM storages
                WHERE name like ?
                """;

        List<Storage> storageList = new ArrayList<>();
        try (PreparedStatement ps = connection.prepareStatement(sql))
        {
            ps.setString(1,"%"+partialName+"%");

            try (ResultSet result = ps.executeQuery()) {
                if (result.next()) {
                    long id = result.getLong("id");
                    String name =  result.getString("name");
                    int price = result.getInt("price");
                    int power = result.getInt("power");
                    int memory = result.getInt("storage");
                    storageList.add(new Storage(id, name, price, power, memory));
                }

            }
        }   catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return storageList;

    }
    public void updateStorage(Connection connection, long id, Storage storage) {
        String sql = """
                UPDATE storages
                SET name = ?, price = ?, power = ?, storage = ?
                WHERE id = ?
                """;
        try(PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setString(1, storage.getName());
            ps.setDouble(2, storage.getPrice());
            ps.setInt(3, storage.getPower());
            ps.setInt(4, storage.getMemory());
            ps.setLong(5, id);

            ps.executeUpdate();
            System.out.println("Updated row with id:" + id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteStorage(Connection connection, long id) {
        String sql = """
                DELETE FROM storages
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
}
