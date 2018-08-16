package com.guo.j8.designPattern.ProducerAndConsumer;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Consumer {

	private String name;
	private ItemQueue queue;

	public Consumer(String name, ItemQueue queue) {
		this.name = name;
		this.queue = queue;
	}

	public void consume() {
		log.info("comsumer : " + name + "get items " + queue.get().name);
	}
}
