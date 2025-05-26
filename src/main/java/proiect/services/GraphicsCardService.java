package main.java.proiect.services;

import config.ConnectionProvider;
import main.java.proiect.components.GraphicsCard;
import main.java.proiect.exceptions.GraphicsCardNotFound;
import main.java.proiect.repository.GraphicsCardRepository;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Optional;

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

    public GraphicsCard getGraphicsCardById(long id) {
        Optional<GraphicsCard> gpu = graphicsCardRepository.getGraphicsCardById(ConnectionProvider.getConnection(), id);
        return gpu.orElseThrow(GraphicsCardNotFound::new);
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
