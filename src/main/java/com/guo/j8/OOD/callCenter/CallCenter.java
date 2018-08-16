package com.guo.j8.OOD.callCenter;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.*;

public class CallCenter {

	private static CallCenter instance;

	final ExecutorService producers = Executors.newFixedThreadPool(100);
	final ExecutorService consumers = Executors.newFixedThreadPool(100);

	List<List<Employee>> employeeList = new ArrayList<>();

	private BlockingQueue<CustomerCall> servicesLine = new LinkedBlockingQueue<>();

	private CallCenter() {

	}

	public static CallCenter getInstance() {
		if (instance == null) {
			return new CallCenter();
		}
		return instance;
	}

	public BlockingQueue<CustomerCall> getServicesLine() {
		return servicesLine;
	}

	public void processCalls() {
		consumers.submit(() -> {
			CustomerCall call = servicesLine.poll();
			dispatchCall(call);
		});
	}

	public void dispatchCall(CustomerCall call) {

		Optional<Employee> caller = getAvailableCaller();
		if (!caller.isPresent()) {
			System.out.println("Sorry all of our agents are currently busy. Please remain on the line to keep your priority");
			putCallBackToQueue(call);
			return;
		}
		caller.get().processCall(call);
	}

	public void putCallBackToQueue(CustomerCall call) {
		servicesLine.offer(call);
	}

	private Optional<Employee> getAvailableCaller() {
		for (Employee respondent : employeeList.get(0)) {
			if (!respondent.isOccupied)
				return Optional.of(respondent);
		}

		for (Employee manager : employeeList.get(1)) {
			if (!manager.isOccupied)
				return Optional.of(manager);
		}

		for (Employee director : employeeList.get(2)) {
			if (!director.isOccupied)
				return Optional.of(director);
		}

		return Optional.empty();
	}

}
