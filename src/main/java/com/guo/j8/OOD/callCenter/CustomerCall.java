package com.guo.j8.OOD.callCenter;

public class CustomerCall {

	String callID;
	int currentServedLevel = 0;

	public CustomerCall() {
		this.callID = generateID();
		this.currentServedLevel = 0;
	}

	private String generateID() {
		return "some random unique ID";
	}
}
