package com.guo.j8.designPattern.singleton;

public class Singleton {

	// 1. private the constructor

	private Singleton() {
	}

	// 2. make a class static instance variable
	private static volatile Singleton instance;

	// expose instance with a public static method

	public static Singleton getInstance() {
		if (instance == null)
			synchronized (Singleton.class) {
				if (instance == null) {
					instance = new Singleton();
				}
			}
		return instance;
	}
}
