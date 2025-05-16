package main.java.lab8;

@FunctionalInterface
public interface Transform<T,R> {
    public R transformTo(T t)  throws Exception;
}

