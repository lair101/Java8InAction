package com.guo.j8.designPattern.ProducerAndConsumer;

import lombok.Data;

@Data
public class Item {

	String name;
	String ID;

	public Item(String name, String ID) {
		this.name = name;
		this.ID = ID;
	}
}
