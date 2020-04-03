package org.hal.phonebook.view;

import org.hal.phonebook.controller.MyException;
import org.hal.phonebook.view.pages.Delete;
import org.hal.phonebook.view.pages.Front;
import org.hal.phonebook.view.pages.Info;
import org.hal.phonebook.view.pages.Insert;
import org.hal.phonebook.view.pages.Menu;
import org.hal.phonebook.view.pages.Print;
import org.hal.phonebook.view.pages.Search;
import org.hal.phonebook.view.pages.Update;


public interface View {
	
	public void display() throws MyException;
	
	Front front = new Front();
	Menu menu = new Menu();
	Insert insert =  new Insert();
	Search search = new Search();
	Print print = new Print();
	Update update = new Update();
	Delete delete = new Delete();
	Info info = new Info(); 
	InOut io = new InOut();
	
	String[] menuArr = {"메 뉴", "저 장", "보 기", "수 정", "삭 제", "정 보", "종 료"};
	String[] prtArr = {null, "전부 보기", "찾아 보기"};
	String[] srcArr = {null, "이름으로", "전화 번호로"};
	String[] upDArr = {null, "이름", "전화 번호", "모두"};
	String[] whySrc = {null, "수정할 전화 번호 찾기", "삭제할 전화 번호 찾기"};
	
	String zero = "";
	String name = "이름 ";
	String phone = "전화 번호 ";
	String input = "입력";
	String errorSymbol = "\t┏(°.°)┛!!";
	String inputError = " 잘못 입력하셨습니다.";
	String noResult = " 찾을 수 없습니다.";
	String att = " #\t이름\t\t전화 번호\n---------------------------------------.";
	String insertP = "전화 번호 저장하기";
	String full = "전화 번호부가 가득찼습니다.";
	String happySymbol = "\t{ ♥‿♥ } ";
	String complt = " 성공!";
	String pageName =" 페이지";
	String pageMove = "\t\t이전(<) / 다음(>)";
	String prevP = "\t이전 페이지";
	String nextP = "\t다음 페이지";
	String firstPage ="\t( ͡°_̯° )? 첫번째 페이지입니다.";
	String lastPage ="\t( ͡°_̯° )? 마지막 페이지입니다.";
	String goBack = "\t\t        [↩] 돌아가기(0)";
	String yesNo = "선택(Y/N) ";
	String upDChoice = "무엇을 수정하시겠습니까?";
	
}
