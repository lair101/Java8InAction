package com.guo.j8.designPattern.ProducerAndConsumer;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ItemQueue {

	private static final int QUEUE_SIZE = 5;

	private BlockingQueue<Item> queue = new LinkedBlockingQueue<>(QUEUE_SIZE);

	public Item get() {
		return queue.poll();
	}

	public void put(Item e) throws InterruptedException {
		queue.put(e);
	}
}
