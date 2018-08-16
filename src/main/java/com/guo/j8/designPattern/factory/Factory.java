package com.guo.j8.designPattern.factory;

import java.util.Optional;

public class Factory {

	public Production getProduct(String prodID) {
		if (prodID.equals(1)) {
			return makeProduction1();
		} else if (prodID.equals(2)) {
			return makeProdcution2();
		}
		return null;
	}

	private Production makeProdcution2() {
		return new Production2();
	}

	private Production makeProduction1() {
		return new Production1();
	}

	// Java 8

	public Optional<Production> getProduct2(String prodID) {
		if (prodID.equals(1)) {
			return Optional.of(new Production1());
		} else if (prodID.equals(2)) {
			return Optional.of(new Production2());
		}

		return Optional.empty();
	}

}
