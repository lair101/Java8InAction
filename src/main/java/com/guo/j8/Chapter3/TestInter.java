package com.guo.j8.Chapter3;

@FunctionalInterface
public interface TestInter<T> {
    void t(T t);
}

@FunctionalInterface
interface TestInter2<T,R>{
    R t(T  t);
}
