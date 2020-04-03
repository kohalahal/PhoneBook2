package org.hal.phonebook.view.pages;

import org.hal.phonebook.controller.MyException;
import org.hal.phonebook.view.InOut;

public class Insert extends InOut {
	
	static int n = 2;


	public String inName() throws MyException {
		input(name);
		return nextLine();
	}
		
	public String inPhone() throws MyException {
		input(phone);
		return nextLine();
		
	}
	
	public String inPhoneSimple() throws MyException {
		inputSimple(phone);
		return nextLine();
		
	}
	
	
}
