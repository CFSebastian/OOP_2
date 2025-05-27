package main.java.proiect.repository;



import main.java.proiect.components.RAM;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class RamRepository {
    private static RamRepository instance;

    private RamRepository() {}

    public static RamRepository getInstance() {
        if (instance == null) {
            instance = new RamRepository();
        }
        return instance;
    }

    //public RAM(long id,String name, double price, int power, int memory, int frequency, String technology)

    public void insertData(Connection connection, RAM ram) {
        String sql = """
                INSERT INTO rams (name,price,power,memory,frequency,technology) 
                VALUES (?,?,?,?,?,?)
                """;
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, ram.getName());
            ps.setDouble(2, ram.getPrice());
            ps.setInt(3, ram.getPower());
            ps.setInt(4, ram.getMemory());
            ps.setInt(5, ram.getFrequency());
            ps.setString(6, ram.getTechnology());

            int insertedRows = ps.executeUpdate();
            System.out.println("Inserted " + insertedRows + " rows");

        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }
    public Optional<RAM> getRamByName(Connection connection, String name) {
        String sql = """
                SELECT *
                FROM rams 
                WHERE name=?
                """;
        try (PreparedStatement ps = connection.prepareStatement(sql))
        {
            ps.setString(1,name);

            try (ResultSet result = ps.executeQuery()) {
                if (result.next()) {
                    long id = result.getLong("id");
                    double price = result.getDouble("price");
                    int power = result.getInt("power");
                    int memory = result.getInt("memory");
                    int frequency = result.getInt("frequency");
                    String technology = result.getString("technology");
                    return Optional.of(new RAM(id, name, price, power, memory, frequency, technology));
                }

            }
        }   catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return Optional.empty();

    }
    public void updateRam(Connection connection, long id, RAM ram) {
        String sql = """
                UPDATE rams
                SET name = ?, price = ?, power = ?, memory = ?, frequency = ?, technology = ?
                WHERE id = ?
                """;
        try(PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setString(1, ram.getName());
            ps.setDouble(2, ram.getPrice());
            ps.setInt(3, ram.getPower());
            ps.setInt(4, ram.getMemory());
            ps.setInt(5, ram.getFrequency());
            ps.setString(6, ram.getTechnology());
            ps.setLong(7, id);

            ps.executeUpdate();
            System.out.println("Updated row with id:" + id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteRam(Connection connection, long id) {
        String sql = """
                DELETE FROM rams
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
