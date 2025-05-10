package models;

public class BankAccount {
    private long id;
    private String name;
    private boolean activeStatus;
    private double balance;
    private long clientId;

    public BankAccount(long id, String name, double balance, boolean activeStatus, long clientId) {
        this.id = id;
        this.name = name;
        this.balance = balance;
        this.activeStatus = activeStatus;
        this.clientId = clientId;
    }

    public BankAccount(String name, boolean activeStatus, long clientId, double balance) {
        this.name = name;
        this.activeStatus = activeStatus;
        this.clientId = clientId;
        this.balance = balance;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public boolean isActiveStatus() {
        return activeStatus;
    }

    public double getBalance() {
        return balance;
    }

    public long getClientId() {
        return clientId;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setActiveStatus(boolean activeStatus) {
        this.activeStatus = activeStatus;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setClientId(long clientId) {
        this.clientId = clientId;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", activeStatus='" + activeStatus + '\'' +
                ", balance=" + balance + '\'' +
                ", clientId" + clientId +
                '}';
    }
}
