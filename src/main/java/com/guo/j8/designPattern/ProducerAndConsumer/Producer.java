package com.guo.j8.designPattern.ProducerAndConsumer;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.BlockingQueue;

@Slf4j
public class Producer {

	private String name;
	private ItemQueue queue;

	public Producer(String name, ItemQueue queue) {
		this.name = name;
		this.queue = queue;
	}

	public void produce(Item i) {
		log.info("producer" + name + "produced item" + i.name);
		try {
			queue.put(i);
		} catch (InterruptedException e) {
			log.error("error putting item into queue");
		}
	}
}
