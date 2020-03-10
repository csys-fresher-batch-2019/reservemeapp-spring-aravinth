package com.chainsys.reservemeapp.logger;

public class logger {
	public static logger getInstance() {
		logger out = new logger();
		return out;
	}

	public void getInput(Object message) {
		System.out.println(message);
	}

	public void debug(Object message) {
		System.out.println(message);
	}

	public void info(Object message) {
		System.out.println(message);
	}

	public void error(Object message) {
		System.out.println(message);
	}

}
