package org.hal.phonebook.view.pages;

import org.hal.phonebook.controller.MyException;
import org.hal.phonebook.view.InOut;

public class Search extends InOut {

	@SuppressWarnings("null")
	public int searchSelect() throws MyException {
		// TODO Auto-generated method stub
		selectMenu(srcArr);
		input("");
		int i = nextInt();
		System.out.println();
		if(i < srcArr.length) {
			smallmenuLand(srcArr[i]+" 찾기");
			return i;
		} else return (Integer) null;
	}		
	
	public String srcName() throws MyException {
		input("이름 ");
		String s = nextLine();
		return s;		
	}
	
	public String srcPhone() throws MyException {
		input("전화 번호 ");
		String s = nextLine();
		return s;	
	}


}
