package org.hal.phonebook.view.pages;

import java.util.InputMismatchException;

import org.hal.phonebook.controller.MyException;
import org.hal.phonebook.view.InOut;

public class Menu extends InOut {
	static int n = 0;
	public int menuSelect() throws MyException, InputMismatchException {
		// TODO Auto-generated method stub
		
		menuLand(n);
		for(int j = 1; j<4; j++) {
			for(int i = j; i < menuArr.length; i += 3) {
				System.out.printf("   %d. %s\t\t",i, menuArr[i]);
			} System.out.println();
		}
		io.input("");
		return  nextInt();
	}

}
