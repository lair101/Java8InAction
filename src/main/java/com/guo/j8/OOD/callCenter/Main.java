package com.guo.j8.OOD.callCenter;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main() {
		CallCenter callCenter = CallCenter.getInstance();

		List<Employee> respondents = new ArrayList<>();
		respondents.add(new Respondent("R1", "1"));
		respondents.add(new Respondent("R2", "2"));
		respondents.add(new Respondent("R3", "3"));
		List<Employee> managers = new ArrayList<>();
		managers.add(new Manager("M1", "4"));
		managers.add(new Manager("M2", "5"));
		managers.add(new Manager("M3", "6"));
		List<Employee> directors = new ArrayList<>();
		directors.add(new Director("D1", "7"));
		callCenter.employeeList.add(0, respondents);
		callCenter.employeeList.add(1, managers);
		callCenter.employeeList.add(2, directors);

		CustomerCall c1 = new CustomerCall();
		callCenter.putCallBackToQueue(c1);

	}
}
