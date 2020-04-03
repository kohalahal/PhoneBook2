package org.hal.phonebook.view.pages;

import org.hal.phonebook.controller.MyException;
import org.hal.phonebook.model.PeopleVO;
import org.hal.phonebook.view.InOut;


public class Print extends InOut {
	
	@SuppressWarnings("null")
	public int selectMethod() throws MyException {
		selectMenu(prtArr);
		input("");
		int i = nextInt();
		System.out.println();
		if(i < prtArr.length) {
			smallmenuLand(prtArr[i]);
			System.out.println();
			return i;
		} else return (Integer) null;
	}
	
	public void display(PeopleVO[] p) throws MyException {
		if(p.length==0) io.noResult(); 
		else prArr(p);	
	}
	
	public void display(PeopleVO[] p, int a) throws MyException {
		if(p.length==0) io.noResult(); 
		else io.complt(prtArr[2]); prArr(p);	
	}
	
	public PeopleVO display(PeopleVO[] p, String s) throws MyException {
		if (p.length==0) { io.noResult(); return null;} 
		else { return prArrSelect(p, s); }	
	}
	
	
//프린트만
	public void prArr(PeopleVO[] p) throws MyException {
		int pageMax = (p.length/10)+(p.length%10==0?0:1);
		for(int i = 0; i < pageMax+1; i++) {
			if(i > 0) {
				System.out.println(pageMove);
				io.input("");
				switch (io.nextLine()) {
					case "<": 
					case ",":
						if(i > 1) {i -= 2; System.out.println(happySymbol+prevP); cutPage(); break;}
						else System.out.println(firstPage); cutPage(); i = 0; break;
					case ">": 
					case ".":
						if(i == pageMax) {System.out.println(lastPage); cutPage(); i--; break;}
						else System.out.println(happySymbol+nextP); cutPage(); break;
					default : 
						io.inputError(); 
						i--;
				}//end of switch		
			}//if it's not the first loop
			
			io.att();
			int k = 1;	
			for(int j = i*10; j<p.length; j++) {
				if(p[j]!=null) System.out.println("["+(j+1)+"]"+p[j].toString()); k++;
				if(k==11) break;
			}
			cutPage();
			System.out.printf("█ "+(i+1)+"/"+pageMax+pageName+" █");	
		}
	}
	
//프린트 중에서 고르기
	private PeopleVO prArrSelect(PeopleVO[] p, String para) throws MyException {
		// TODO Auto-generated method stub
		String s;
		int n = -1;
		int pageMax = (p.length/10)+(p.length%10==0?0:1);
		for(int i = 0; i < pageMax+1; i++) {
			if(i > 0) {
				System.out.println(pageMove);
				io.input(para+"할 연락처 번호 # ");
				s = nextLine();
				
				if(isNumeric(s)) {
					n = Integer.parseInt(s);
					//System.out.println("n:"+n+"i:"+i);
					if( n > (i*10)-10 && n < (i*10)+1) {
						//System.out.println("리턴 n:"+n);
						return p[n-1];
					} else inputError(); i--;
				} else {
					switch (s) {
						case "<": 
							if(i > 1) {i -= 2; System.out.println(happySymbol+prevP); cutPage(); break;}
							else System.out.println(firstPage); cutPage(); i = 0; break;
						case ">": 
							if(i == pageMax) {System.out.println(lastPage); cutPage(); i--; break;}
							else System.out.println(happySymbol+nextP); cutPage(); break;
						default : 
							io.inputError(); 
							i--;
					}//end of switch
				}
			}//if it's not the first loop
			
			io.att();
			int k = 1;	
			for(int j = i*10; j<p.length; j++) {
				System.out.println("["+(j+1)+"]"+p[j].toString()); k++;
				if(k==11) break;
			}
			cutPage();
			System.out.printf("█ "+(i+1)+"/"+pageMax+pageName+" █");	
		}
		return null;
	}
	

	
}
