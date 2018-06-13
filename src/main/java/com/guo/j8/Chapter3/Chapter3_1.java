package com.guo.j8.Chapter3;

import org.springframework.cglib.core.internal.Function;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class Chapter3_1 {

    /**
     * catch exception in lambda expression
     * 1. In the interface declaration throws exception, when use inteface it will throw the exception
     * 2. In the implementation of interface, catch the exception
     *
     */

    @FunctionalInterface
    public interface  BufferedReaderProcessor {
        String process(BufferedReader b) throws IOException;
    }


    public void test(){

        BufferedReaderProcessor p = (BufferedReader br) -> br.readLine();

        Function<BufferedReader, String> f = (BufferedReader b) -> {
            try {
                return b.readLine();
            }
            catch(IOException e) {
                throw new RuntimeException(e); }
        };
    }


    /**
     * There are two contructors. One is with the value, one is not.
     * Contruct a object Apple without values.
     * use Supplier class
     */

    public Apple getAppleWithOutParam(){
        Supplier<Apple> a1 = () -> new Apple();
        return a1.get();
    }

    /**
     * Contruct objects with params
     */
    public void getAppleWithParam(String name, int price, int weight){

        //Because Function class only take T as input. R as output.
        //We need to implement methods as inputs. Put all the input as List
        List<String> list = Arrays.asList(name,Integer.toString(price),Integer.toString(weight));
        //implement function class as list, input function is constructor method.
        Function<List<String>, Apple> a2 = (l) -> new Apple(l.get(0),Integer.valueOf(l.get(1)),Integer.valueOf(l.get(2)));
        //initialize the object
        a2.apply(list);

    }
}
