package main.java.proiect.repository;



import main.java.proiect.components.Processor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class ProcessorRepository {

    private static ProcessorRepository instance;

    private ProcessorRepository() {}

    public static ProcessorRepository getInstance() {
        if (instance == null) {
            instance = new ProcessorRepository();
        }
        return instance;
    }

    public void insertData(Connection connection, Processor processor) {
        String sql = """
                INSERT INTO processors (id,name,price,power,coreNumber,frequency,socket) 
                VALUES (?,?,?,?,?,?,?)
                """;
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setLong(1, processor.getId());
            ps.setString(2, processor.getName());
            ps.setDouble(3, processor.getPrice());
            ps.setInt(4, processor.getPower());
            ps.setInt(5, processor.getCoreNumber());
            ps.setFloat(6, processor.getFrequency());
            ps.setString(7, processor.getSocket());

            int insertedRows = ps.executeUpdate();
            System.out.println("Inserted " + insertedRows + " rows");

        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }

    /*public Optional<Processor> getProcessorById(Connection connection, long id) {
        String sql = """
                SELECT *
                FROM processors cpu
                WHERE cpu.id=?
                """;
        try (PreparedStatement ps = connection.prepareStatement(sql))
        {
            ps.setLong(1,id);

            try (ResultSet result = ps.executeQuery()) {
                /*if (result.next()) {
                    return Optional.of(new Processor(
                            id,
                            result.getString("name"),
                            result.getDouble("price"),
                            result.getInt("coreNumber"),
                            result.getFloat("frequency"),
                            result.getInt("power"),
                            result.getString("socket")
                    ));
                    if (result.next()) {
                        String name = result.getString("name");
                        double price = result.getDouble("address");
                        int coreNumber = result.getInt("active_status");
                        float frequency = result.getFloat("frequency");
                        int power = result.getInt("power");
                        String socket = result.getString("socket");
                        return Optional.of(new Processor(id, name, price, coreNumber, frequency, power, socket));
                    }

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            return Optional.empty();
        }

    }*/
}
