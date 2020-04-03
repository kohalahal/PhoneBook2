package org.hal.phonebook.view.pages;

import org.hal.phonebook.controller.MyException;
import org.hal.phonebook.view.InOut;

public class Info extends InOut {

	@Override
	public void display() {
		// TODO Auto-generated method stub

	}
	
	public void info(int a, int b) throws MyException {
		System.out.println("       。　     ☆      。*　☆。　　     ☆　       。");
		System.out.println("         저장 가능한 전화 번호 개수 : "+a+"개");
		System.out.println("       ★。　     ＼　     *｜     　　／。     　★");
		System.out.println("         현재 저장된 전화 번호 개수 : "+b+"개");
		System.out.println("        　       *     　  。。。          *      ");
		System.out.println("         저장 가능한 전화 번호 개수 : "+(a-b)+"개");
		System.out.println("        ★。*      ／      * ｜      　*＼。   ★ ");
		System.out.printf("         사용중인 용량 : %.2f%%\n",(float)b/(float)a*100);
		System.out.println("       。　     ☆。 　     　。　     　☆           。");
		System.out.println();




		input("아무 키나 ");
		nextLine();		
	}
}
