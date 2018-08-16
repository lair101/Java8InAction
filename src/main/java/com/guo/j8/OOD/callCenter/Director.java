package com.guo.j8.OOD.callCenter;

public class Director extends Employee {

	public Director(String name, String ID) {
		this.name = name;
		this.ID = ID;
		this.level = 3;
	}

	@Override
	public void escalateCall(CustomerCall call) {
		super.escalateCall(call);
		CallCenter.getInstance().putCallBackToQueue(call);
	}
}
