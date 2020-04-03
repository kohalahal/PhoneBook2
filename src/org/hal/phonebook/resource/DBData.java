package org.hal.phonebook.resource;

import org.hal.phonebook.model.PeopleVO;

public class DBData {
	PeopleVO temp;
	PeopleVO[] tempPArr;
	
	public PeopleVO getTemp() {
		PeopleVO p = temp.copy(temp);
		temp = null;
		return p;
	}
	public void setTemp(PeopleVO temp) {
		this.temp = temp;
	}
	public PeopleVO[] getTempPArr() {
		PeopleVO[] copy = new PeopleVO[tempPArr.length];
		for(int i = 0; i < tempPArr.length; i++) {
			copy[i] = tempPArr[i].copy(tempPArr[i]);
		}
		tempPArr = null;
		return copy;
	}
	public void setTempPArr(PeopleVO[] tempPArr) {
		this.tempPArr = tempPArr;
	}
	public boolean ArrFlag() {
		if(tempPArr==null) return false;
		else return true;
	}
	public boolean VOFlag() {
		if(temp==null) return false;
		else return true;
	}

}
