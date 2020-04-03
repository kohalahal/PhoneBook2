package org.hal.phonebook.view;

import java.util.InputMismatchException;
import java.util.Scanner;
import org.hal.phonebook.controller.MyException;

public class InOut implements View {
	
	Scanner sc = new Scanner(System.in);
	
	public void cutPage() {
		System.out.println("........................................");
	}
	
	@SuppressWarnings("null")
	public int menuLand(int i) {
		if(i<0) {
			return (Integer) null;
		}
		System.out.println("");
		if(i == 0) System.out.println("\t\t        ☏");
		System.out.println("     ┎┈┈┈┈━━━━━━┈┈┈୨♡୧┈┈━━━━━━┈┈┈┈┈┒");
		System.out.println("\t\t    "+menuArr[i]);
		System.out.println("     ┖┈┈┈┈━━━━━━┈┈┈୨♡୧┈┈━━━━━━┈┈┈┈┈┚");
		System.out.println("");
//		System.out.println("::::: ⋆ ✧　 　 · 　 ✧　✵");
//		System.out.println(":::☆ *　　 * ⋆");
//		System.out.println(":::★ *\t"+s);
//		System.out.println("::* . *　✦");
//		System.out.println(":☆ ° ✧　 　 ·");
//		System.out.println("★*");
//		System.out.println("\t:::::::: "+s+" :::::::::");
		return i;
	}
	
	public void smallmenuLand(String s) {
		System.out.println("                ❅•°• "+s+" •°•❅");
	}
	
	public void smallmenuLand(String s, String str) {
		System.out.println("                ❅•°• "+s+" •°•❅\n");
	}
	
	public void selectMenu(String[] s) {
		System.out.print("    ");
		for(int i = 1; i < s.length; i++) {
			System.out.print(i+". "+s[i]+"\t");
		}
		System.out.println();
	}
	
	public void input(String s) {
		cutPage();
		goBack();
		System.out.print(s+input+"...\t");
	}
	
	public void inputSimple(String s ) {
		System.out.print(s+input+"...\t");
	}
	
	public void inputError() {
		System.out.println(errorSymbol+inputError);
		cutPage();
	}
	
	public void noResult() {
		System.out.println(errorSymbol+noResult);
		cutPage();
	}
	
	public void goBack() {
		System.out.println(goBack);
	}
	
	public void att() {
		System.out.println(att);
	}
	
	public void full() {
		System.out.println(errorSymbol+full);
	}
	
	public void complt(String s) {
		System.out.println(happySymbol+s+complt);
		cutPage();
	}
	
	@SuppressWarnings("null")
	public int nextInt() throws MyException, InputMismatchException {
		try {
			int i = sc.nextInt();
			sc.nextLine();
			//System.out.print("넥스트인트");
			cutPage();
			if(i==0) {
				throw new MyException("");
			}
			return i;
		} catch (InputMismatchException e) {
			sc.nextLine();
			return (Integer) null;
		}
	}

	public String nextLine() throws MyException {
		String s = sc.nextLine();
		//System.out.print("넥스트라인");
		cutPage();
		if(s.equals("0")) {
			throw new MyException("");
		}		
		return s;
	}
	
	public boolean isNumeric(String s) { 
		  try {  
		    Integer.parseInt(s);  
		    return true;
		  } catch(NumberFormatException e){  
		    return false;  
		  }  
	}

	public boolean ask(String s) throws MyException {
		System.out.print("  "+s+"하시겠습니까?\t─◕████▄\n\t\t\t────◕██\n\t\t\t──◕███\n\t\t\t──◕\n\t\t\t──◕██\n");
		input(yesNo);
		String a = nextLine();
		if(a.equals("Y")||a.equals("y")||a.equals("ㅛ")) return true;
		else if(a.equals("n")||a.equals("N")||a.equals("ㅜ")) return false;
		else inputError(); return false;
	}

	@Override
	public void display() throws MyException {
		// TODO Auto-generated method stub
		
	}
	
	public void exit() {
		System.out.println("★───────────────────────────────────★");
		System.out.println("★─▄█▀▀║░▄█▀▄║▄█▀▄║██▀▄║─★");
		System.out.println("★─██║▀█║██║██║██║██║██║█║─★");
		System.out.println("★─▀███▀║▀██▀║▀██▀║███▀║─★");
		System.out.println("★───────────────────────────────────★");
		System.out.println("★───▐█▀▄─ ▀▄─▄▀── █▀▀────█───★");
		System.out.println("★───▐█▀▀▄ ───█──── █▀▀────▀───★");
		System.out.println("★───▐█▄▄▀ ───▀──── ▀▀▀────▄───★");
		System.out.println("★───────────────────────────────────★");
		
	}
	
}
