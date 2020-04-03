package org.hal.phonebook.view.pages;

import org.hal.phonebook.controller.MyException;
import org.hal.phonebook.view.InOut;

public class Delete extends InOut {

	public boolean delChoice() throws MyException {
		return ask("삭제"); 
	}
	
}
