package com.guo.j8.Chapter3;

import lombok.Data;

@Data
public class Apple {
    String name;
    int price;
    int weight;

    public Apple(String name, int price, int weight) {
        this.name = name;
        this.price = price;
        this.weight = weight;
    }


    public Apple() {
    }
}
