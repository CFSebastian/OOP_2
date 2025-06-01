package main.java.proiect.repository;

import main.java.proiect.components.GraphicsCard;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class GraphicsCardRepository {

    private static GraphicsCardRepository instance;

    private GraphicsCardRepository() {}

    public static GraphicsCardRepository getInstance() {
        if (instance == null) {
            instance = new GraphicsCardRepository();
        }
        return instance;
    }
    //public GraphicsCard(long id,String name, double price, int vRAM,  int power)
    public void insertData(Connection connection, GraphicsCard gpu) {
        String sql = """
                INSERT INTO graphics_cards (name,price,power,vRam) 
                VALUES (?,?,?,?)
                """;
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, gpu.getName());
            ps.setDouble(2, gpu.getPrice());
            ps.setInt(3, gpu.getPower());
            ps.setInt(4, gpu.getvRAM());

            int insertedRows = ps.executeUpdate();
            System.out.println("Inserted " + insertedRows + " rows");

        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }

    public List<GraphicsCard> getGraphicsCardByName(Connection connection, String partialName) {
        String sql = """
                SELECT *
                FROM graphics_cards
                WHERE name like ?
                """;
        List<GraphicsCard> graphicsCards = new ArrayList<>();
        try (PreparedStatement ps = connection.prepareStatement(sql))
        {
            ps.setString(1,"%"+partialName+"%");

            try (ResultSet result = ps.executeQuery()) {
                while (result.next()) {
                    long id = result.getLong("id");
                    String name =  result.getString("name");
                    int price = result.getInt("price");
                    int power = result.getInt("power");
                    int vRAM = result.getInt("vRAM");
                    graphicsCards.add(new GraphicsCard(id, name, price, vRAM, power));
                }

            }
        }   catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return graphicsCards;

    }
    public void updateGraphicsCard(Connection connection, long id, GraphicsCard gpu) {
        String sql = """
                UPDATE graphics_cards
                SET name = ?, price = ?, power = ?, vRam = ?
                WHERE id = ?
                """;
        try(PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setString(1, gpu.getName());
            ps.setDouble(2, gpu.getPrice());
            ps.setInt(3, gpu.getPower());
            ps.setInt(4, gpu.getvRAM());
            ps.setLong(5, id);

            ps.executeUpdate();
            System.out.println("Updated row with id:" + id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteGraphicsCard(Connection connection, long id) {
        String sql = """
                DELETE FROM graphics_cards
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
