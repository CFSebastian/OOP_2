package main.java.lab10;

import main.java.lab10.config.ConnectionProvider;
import models.Client;
import main.java.lab10.service.AccountService;
import main.java.lab10.service.BankService;

import java.sql.Connection;
import java.sql.SQLException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    private static void cleanUp() {
        AccountService accountService = new AccountService();
        BankService bankService = new BankService();
        accountService.cleanUp();
        bankService.cleanUp();
    }
    public static void main(String[] args) {
        //cleanUp();
        BankService bankService = new BankService();
        Client client = new Client( "Gigi kent", "Str. Cutare, nr. 10", true);
        bankService.insertData(client);
        System.out.println(bankService.getClientById(1L));
        System.out.println(bankService.getClientById(2L));

    }
}