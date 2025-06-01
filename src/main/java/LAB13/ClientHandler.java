package main.java.LAB13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.HashSet;
import java.util.Set;
/*
public class ClientHandler implements Runnable {
    private Socket socket;

    private BufferedReader in;

    private PrintWriter out;

    private String clientName;

    private final Set<ClientHandler>  clientsHadlers;

    ClientHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run(){
        try{
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);

            out.println("Enter your name:");
             clientName = in.readLine();

             System.out.println(clientName + " connected");


            clientsHadlers.forEach

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void forEach(Object o) {
    }

}*/
