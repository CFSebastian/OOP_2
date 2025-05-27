package main.java.proiect.services;

import config.ConnectionProvider;
import main.java.proiect.components.Processor;
import main.java.proiect.exceptions.ProcessorNotFound;
import main.java.proiect.repository.ProcessorRepository;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Optional;

public class ProcessorService {
    private final ProcessorRepository processorRepository = ProcessorRepository.getInstance();

    public ProcessorService() {}

    public void insertData(Processor cpu) {
        try (Connection connection = ConnectionProvider.getConnection()) {
            processorRepository.insertData(connection, cpu);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Processor getProcessorByName(String name) {
        Optional<Processor> cpu = processorRepository.getProcessorByName(ConnectionProvider.getConnection(), name);
        return cpu.orElseThrow(ProcessorNotFound::new);
    }

    public void updateProcessor(long id, Processor cpu) {
        try (Connection connection = ConnectionProvider.getConnection()) {
            processorRepository.updateProcessor(connection, id, cpu);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteProcessor(long id) {
        try (Connection connection = ConnectionProvider.getConnection()) {
            processorRepository.deleteProcessor(connection, id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
