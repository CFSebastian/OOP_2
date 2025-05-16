package main.java.lab8;

@FunctionalInterface
public interface FunInt2<T> {
    void transformTo(T t)  throws Exception;
}
