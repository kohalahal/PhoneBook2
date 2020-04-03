package org.hal.phonebook.controller;



import org.hal.phonebook.dao.PeopleDao;
import org.hal.phonebook.resource.DBData;
import org.hal.phonebook.view.View;

public class Service {
	private PeopleDao dao;	
	private DBData db;
	public Service(int size) {
		dao = new PeopleDao(size);
		db = new DBData();
	}
	
	public Service(int size, int test) { //테스트용:예제 연락처 생성
		dao = new PeopleDao(size, 1);
		db = new DBData();
	}
	
	public int start() throws MyException {
		return View.io.menuLand(View.menu.menuSelect());
	}
	
	public void insertP() throws MyException {
		if(dao.emptyIdx()>-1) {	
			View.io.smallmenuLand(View.insertP);
			dao.insertPeople(View.insert.inName(), View.insert.inPhoneSimple());
			View.io.complt(View.menuArr[1]);
		} else View.io.full();
	}
	
	public void Print() throws MyException { //보기
		if(dao.getTotal()==0) {
			View.io.noResult();
		} else {
			switch(View.print.selectMethod()) {
				case 1:
					View.print.display(dao.getDao());//print
					break;
				case 2:
					SearchAndPrint();
					break;
			}
		}
	}
	
	public void SearchAndPrint() throws MyException { 
		if(dao.getTotal()==0) {
			View.io.noResult();
			return;
		} else {
			switch(View.search.searchSelect()) {
			case 1:
				db.setTempPArr(dao.srcByN(View.insert.inName()));
				break;
			case 2:
				db.setTempPArr(dao.srcByP(View.insert.inPhone()));
				break;
			}
		}
		if(db.ArrFlag()) View.print.display(db.getTempPArr(), 1);
		else System.out.println("서치");View.io.noResult();
	}

	public void updateP() throws MyException {
		switch(choiceSrc(1)) {
			case 1:
				db.setTempPArr(dao.srcByN(View.insert.inName()));
				break;
			case 2:
				db.setTempPArr(dao.srcByP(View.insert.inPhone()));
				break;
			default :
				View.io.inputError();
				return;
		}
		if(db.ArrFlag()) { 
			doUpdate();
			
		} else View.io.noResult();
	}
	
	public void doUpdate() throws MyException {
		db.setTemp(View.print.display(db.getTempPArr(), "수정"));
		if(db.VOFlag()) {
			switch(View.update.upDSelect()) {
				case 1:
					dao.updatePeople(db.getTemp(), View.insert.inName(), null); break;
				case 2:
					dao.updatePeople(db.getTemp(), null, View.insert.inPhoneSimple()); break;
				case 3:
					dao.updatePeople(db.getTemp(), View.insert.inName(), View.insert.inPhoneSimple()); break;
			}	
			View.io.complt(View.menuArr[3]);
		} else View.io.inputError();
	}
	
	public void deleteP() throws MyException {
		switch(choiceSrc(2)) {
			case 1:
				db.setTempPArr(dao.srcByN(View.insert.inName()));
				break;
			case 2:
				db.setTempPArr(dao.srcByP(View.insert.inPhone()));
				break;
			default :
				View.io.inputError();
				return;
		}
		if(db.ArrFlag()) { 
			doDel();
			View.io.complt(View.menuArr[4]);
		} else View.io.noResult();
	}

	public void doDel() throws MyException {
		db.setTemp(View.print.display(db.getTempPArr(), "삭제"));
		if(View.delete.delChoice()) { dao.deletePeople(db.getTemp()); }
	}
	
	
	public void info() throws MyException {
		View.info.info(dao.getMax(),dao.getTotal());
	}
	
	public void exit() throws MyException {
		if(View.io.ask("종료")) {
			View.io.exit(); System.exit(0);
		} 
	}
	
	public int choiceSrc(int i) throws MyException {
		View.io.smallmenuLand(View.whySrc[i], "enter");
		return View.search.searchSelect();	
	}

	
}
