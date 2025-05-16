package main.java.lab8;

@FunctionalInterface
public interface FunInt3<T,R> {
    public R transformTo(T t)  throws Exception;
}
