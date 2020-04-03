package org.hal.phonebook.controller;

public class MyException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public MyException(String s) {
		super(s);
	}
	MyException(int n) {
		super(Integer.toString(n));
	}
	
	
}
