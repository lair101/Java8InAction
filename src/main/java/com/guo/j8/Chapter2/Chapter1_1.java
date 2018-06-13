package com.guo.j8.Chapter2;

import lombok.Data;
import org.junit.jupiter.api.Test;

import java.util.*;

public class Chapter1_1{

    List<Apple> inventory = new ArrayList<Apple>();



    /***
     * old way to sort a list is to implement a Comparator method for sort()
     * This need more code and Object casting
     */
    public void oldSort(){
        Apple a = new Apple();
        a.setWeight(1);
        Apple b = new Apple();
        b.setWeight(2);
        inventory.add(a);
        inventory.add(b);
        Collections.sort(inventory, new Comparator<Apple>() {
            @Override
            public int compare(Apple o1, Apple o2) {
                return o1.getWeight()-o2.getWeight();
            }
        });
    }


    /**
     * First Java 8 way to write sort
     * use arraylist sort with lambda expression to implement comparator
     */
    public void newSort(){
        Apple a = new Apple();
        a.setWeight(1);
        Apple b = new Apple();
        b.setWeight(2);
        inventory.add(a);
        inventory.add(b);
        inventory.sort((Apple o1, Apple o2) -> {return o1.getWeight()- o2.getWeight();});
    }


    @Test
    public void test1(){

        long lStartTime = System.nanoTime();

        oldSort();

        long lEndTime = System.nanoTime();

        System.out.println("Old sort time consume :" + (lEndTime - lStartTime));

        lStartTime = System.nanoTime();

        newSort();

        lEndTime = System.nanoTime();


        System.out.println("New sort time consume :" + (lEndTime - lStartTime));

    }

}





@Data
class Apple{
    int weight;
}
