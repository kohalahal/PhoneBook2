package org.hal.phonebook.view.pages;

import org.hal.phonebook.controller.MyException;
import org.hal.phonebook.view.InOut;

public class Update extends InOut {

	@Override
	public void display() {
		// TODO Auto-generated method stub
		
	}
	
	@SuppressWarnings("null")
	public int upDSelect() throws MyException {
		smallmenuLand(upDChoice);
		System.out.println();
		selectMenu(upDArr);
		input("");
		int i = nextInt();
		if(i < upDArr.length) {
			smallmenuLand(upDArr[i]+" 수정하기");
			System.out.println();
			return i;
		}
		return (Integer) null;
	}
	
	
	
	
	
}
