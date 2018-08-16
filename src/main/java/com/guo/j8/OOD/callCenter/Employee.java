package com.guo.j8.OOD.callCenter;

public class Employee {

	String name;
	String ID;
	int level;
	Boolean isOccupied;

	public void processCall(CustomerCall call) {
		// received call
		isOccupied = Boolean.FALSE;
		// processing call
		// if cant handle
		call.currentServedLevel = this.level;
		escalateCall(call);
		isOccupied = Boolean.TRUE;
		return;
	}

	public void escalateCall(CustomerCall call) {
	}
}