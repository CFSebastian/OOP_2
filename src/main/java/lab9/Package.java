package main.java.lab9;

public class Package <T>{
    private T content;
    private String address;

    Package(T content, String address) {
        this.content = content;
        this.address = address;
    }

    public T unpackContents() {
        return content;
    }

    public String getAddress() {
        return address;
    }

    public void sendPackage() {
        System.out.println("Package send");
    }
}
