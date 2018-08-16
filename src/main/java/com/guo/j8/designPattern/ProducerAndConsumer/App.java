package com.guo.j8.designPattern.ProducerAndConsumer;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

@Slf4j
public class App {

	@Test
	public void main() {

		ItemQueue queue = new ItemQueue();

		ExecutorService executorService = Executors.newFixedThreadPool(6);

		for (int i = 0; i < 3; i++) {

			Producer producer = new Producer("Producer_" + i, queue);
			executorService.submit(() -> {
				while (true) {
					Item item = new Item("No." + Thread.currentThread().getName(), String.valueOf(Thread.currentThread().getId()));
					producer.produce(item);
				}
			});
		}

		IntStream.range(0, 3).forEach(i -> {
			Consumer consumer = new Consumer("Consumer_" + i, queue);
			executorService.submit(() -> {
				while (true) {
					consumer.consume();
				}
			}
					);
		});

		executorService.shutdown();
		try {
			executorService.awaitTermination(10, TimeUnit.SECONDS);
			executorService.shutdownNow();
		} catch (InterruptedException e) {
			log.error("Error waiting for ExecutorService shutdown");
		}

	}

}
