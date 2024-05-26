package com.example.effectivejava.chapter2.item3;

public class Elvis {
	public static final Elvis INSTANCE = new Elvis();

	private Elvis() {

	}

	public static Elvis getInstance() {
		return INSTANCE;
	}

	public void leaveTheBuilding() {

	}
}
