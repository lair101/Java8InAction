package com.guo.j8.OOD.callCenter;

public class Manager extends Employee {

	public Manager(String name, String ID) {
		this.name = name;
		this.ID = ID;
		this.level = 2;
	}

	@Override
	public void escalateCall(CustomerCall call) {
		super.escalateCall(call);
		call.currentServedLevel = call.currentServedLevel + 1;
		CallCenter.getInstance().putCallBackToQueue(call);
	}
}
