package main.java.proiect.services;

import  main.java.proiect.config.ConnectionProvider;
import main.java.proiect.components.GraphicsCard;
import main.java.proiect.exceptions.GraphicsCardNotFound;
import main.java.proiect.repository.GraphicsCardRepository;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Optional;
import java.util.List;

public class GraphicsCardService {
    private final GraphicsCardRepository graphicsCardRepository = GraphicsCardRepository.getInstance();

    public GraphicsCardService() {}

    public void insertData(GraphicsCard gpu) {
        try (Connection connection = ConnectionProvider.getConnection()) {
            graphicsCardRepository.insertData(connection, gpu);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<GraphicsCard> getGraphicsCardByName(String name) {
        if (name == null || name.isBlank()) {
            name = "";
        }
        List<GraphicsCard> gpus = graphicsCardRepository.getGraphicsCardByName(ConnectionProvider.getConnection(), name);
        if (gpus.isEmpty()) {
            throw new GraphicsCardNotFound();
        }
        else {
            return gpus;
        }
    }

    public void updateGraphicsCard(long id, GraphicsCard gpu) {
        try (Connection connection = ConnectionProvider.getConnection()) {
            graphicsCardRepository.updateGraphicsCard(connection, id, gpu);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteGraphicsCard(long id) {
        try (Connection connection = ConnectionProvider.getConnection()) {
            graphicsCardRepository.deleteGraphicsCard(connection, id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
