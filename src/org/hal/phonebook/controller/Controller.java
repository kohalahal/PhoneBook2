package org.hal.phonebook.controller;

import java.util.InputMismatchException;

import org.hal.phonebook.view.View;

public class Controller {

	final static int MAX = 100;
	static Service service = new Service(MAX, 1);//테스트용:예제연락처생성. 안하려면 1지우기.
	
	public static void main(String[] args) throws MyException, InputMismatchException {
		
		
		
		View.front.display();
		
		
	
		while(true) {
			try {

				switch(service.start()) {
					case 1:
						service.insertP();break;
					case 2:
						service.Print();break;
					case 3:
						service.updateP();break;
					case 4:
						service.deleteP();break;
					case 5:
						service.info();break;
					case 6:
						service.exit();break;
					case -1:
						break;
				}
			}	catch (MyException e) {

				continue;
			} catch (InputMismatchException e) {
				View.io.cutPage();
				View.io.inputError();
				continue;
			} catch (NullPointerException e) {
				View.io.cutPage();
				View.io.inputError();
				continue;
			} catch (ArrayIndexOutOfBoundsException e) {
				View.io.cutPage();
				View.io.inputError();
				continue;
			}
			
			
			
		} 
			
		 
	}
	
}
