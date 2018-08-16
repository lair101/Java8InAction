package com.guo.j8.OOD.callCenter;

public class Respondent extends Employee {

	Respondent(String name, String ID) {
		this.name = name;
		this.ID = ID;
		this.level = 1;
		this.isOccupied = false;
	}

	@Override
	public void escalateCall(CustomerCall call) {
		super.escalateCall(call);
		call.currentServedLevel = call.currentServedLevel + 1;
		CallCenter.getInstance().putCallBackToQueue(call);
	}
}
