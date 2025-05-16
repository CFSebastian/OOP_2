package main.java.lab8;

@FunctionalInterface
public interface IsTrue<T,R> {
    public boolean bob(T t) throws Exception;
}
