package org.hal.phonebook.dao;

import org.hal.phonebook.model.PeopleVO;

public class PeopleDao {
	private PeopleVO[] list;	
	private int id;
	private int total;
	public PeopleDao(int size) {
		list = new PeopleVO[size];
		id=0;
		total=0;
	}
	
	public PeopleDao(int size, int a) {//테스트용
		total = 37;
		id = 0;
		list = new PeopleVO[size];
		{
			list[id] = new PeopleVO(id++, "트위치", "010-1111-1111");
			list[id] = new PeopleVO(id++, "애쉬", "010-1111-1131");
			list[id] = new PeopleVO(id++, "애쉬", "010-1111-1132");
			list[id] = new PeopleVO(id++, "애쉬", "010-1111-1133");
			list[id] = new PeopleVO(id++, "애쉬", "010-1111-1134");
			list[id] = new PeopleVO(id++, "애쉬", "010-1111-1135");
			list[id] = new PeopleVO(id++, "애쉬", "010-1111-1136");
			list[id] = new PeopleVO(id++, "애쉬", "010-1111-1137");
			list[id] = new PeopleVO(id++, "애쉬", "010-1111-1138");
			list[id] = new PeopleVO(id++, "KIM", "010-1555-1111");
			list[id] = new PeopleVO(id++, "박", "010-1111-1111");
			list[id] = new PeopleVO(id++, "김수로", "010-1331-1111");
			list[id] = new PeopleVO(id++, "트위치", "010-1111-1111");
			list[id] = new PeopleVO(id++, "미포", "010-1111-1131");
			list[id] = new PeopleVO(id++, "제드", "010-1555-1111");
			list[id] = new PeopleVO(id++, "호호호", "01032222221");
			list[id] = new PeopleVO(id++, "무무", "010-1331-1100");
			list[id] = new PeopleVO(id++, "트위치", "010-1111-1111");
			list[id] = new PeopleVO(id++, "김수로", "010-1331-1111");
			list[id] = new PeopleVO(id++, "트위치", "010-1111-1111");
			list[id] = new PeopleVO(id++, "미포", "010-1111-1131");
			list[id] = new PeopleVO(id++, "제드", "010-1555-1111");
			list[id] = new PeopleVO(id++, "호호호", "01032222221");
			list[id] = new PeopleVO(id++, "무무", "010-1331-1100");
			list[id] = new PeopleVO(id++, "제드", "010-1555-1111");
			list[id] = new PeopleVO(id++, "호호호", "01032222221");
			list[id] = new PeopleVO(id++, "무무", "010-1331-1100");
			list[id] = new PeopleVO(id++, "트위치", "010-1111-1111");
			list[id] = new PeopleVO(id++, "애쉬", "999마지막에서네번째");
			list[id] = new PeopleVO(id++, "KIM", "010-1555-1111");
			list[id] = new PeopleVO(id++, "박", "010-1111-1111");
			list[id] = new PeopleVO(id++, "김수로", "010-1331-1111");
			list[id] = new PeopleVO(id++, "애쉬", "010-1111-1131");
			list[id] = new PeopleVO(id++, "애쉬", "010-1111-1132");
			list[id] = new PeopleVO(id++, "애쉬", "010-1111-1133");
			list[id] = new PeopleVO(id++, "애쉬", "010-1111-1134");
			list[id] = new PeopleVO(id++, "애쉬", "010-1111-1135");
			};
	}
	
	public int getMax() {
		return list.length;
	}
	
	public PeopleVO[] getDao() {
		//System.out.println("id.total:"+id+"."+total);
		PeopleVO[] temp = new PeopleVO[total];
		int i = 0;
		for(int j = 0; j < total; j++) {
			for(; i < list.length;i++) {
				if(list[i]!=null) {
					//System.out.println("카피전"+j+"."+i);
					temp[j] = list[i].copy(list[i]);
					i++;
					//System.out.println("카피후");
					break;
				}
			}
		}
		return temp;
	}

	public int getTotal() {
		return total;
	}

	public int emptyIdx() {
		for(int i = 0; i < list.length; i++) {
			if(list[i] == null) {
				return i;  
			}
		} return -1;
	}
	
	public int returnIdx(PeopleVO p) {
		int i = 0;
		for(; i < list.length; i++) {
			if(list[i] != null) {
				if(list[i].getId()==p.getId()) break;
			}
		}
		return i;
	}
	
	public void insertPeople(String name, String phone) {
		if(emptyIdx()>-1) {
			list[emptyIdx()] = new PeopleVO(id++, name, phone);
			total++;
		} 
	}
	
	public PeopleVO updatePeople(PeopleVO p, String name, String phone) {
		if(name != null) list[returnIdx(p)].setName(name);
		if(phone != null) list[returnIdx(p)].setPhone(phone);
		return list[returnIdx(p)];
	}
	
	public void deletePeople(PeopleVO p) {
		list[returnIdx(p)] = null;
		total--;
	}
	
	public PeopleVO[] srcByN(String string) {
		//System.out.println("다오 서치바이엔 시작");
		int cnt = 0;
		for(int i = 0; i < list.length; i++) {
			if(list[i]!=null && list[i].getName().equals(string)) {
					cnt++;
				}
			}
		if(cnt==0) return null;
		//System.out.println("다오 서치바이엔 중간 cnt:"+cnt);
		PeopleVO[] temp = new PeopleVO[cnt];
		int j = 0;
		for(int i = 0; i < list.length; i++) {
				if(list[i]!=null && list[i].getName().equals(string)) {
				//System.out.println("카피전 j"+j+".i"+i);
				temp[j] = list[i].copy(list[i]);
				j++;
				//System.out.println("카피후 j"+j+".i"+i);			
				} 
			}
		//System.out.println("다오의서치바이엔끝");
		return temp;			
	}
	
	public PeopleVO[] srcByP(String string) {
		int cnt = 0;
		for(int i = 0; i < list.length; i++) {
			if(list[i]!=null && list[i].getPhone().equals(string)) {
					cnt++;
				}
			}
		if(cnt==0) return null;
		PeopleVO[] temp = new PeopleVO[cnt];
		int i = 0;
		for(int j = 0; j < cnt; j++) {
			for(; i < list.length;i++) {
				if(list[i]!=null && list[i].getPhone().equals(string)) {
					temp[j] = list[i].copy(list[i]);
					i++;
					break;
				} else continue;
			}
		}
		return temp;	
	}
	
	public PeopleVO[] copyPArr(PeopleVO[] p) {
		PeopleVO[] temp = new PeopleVO[p.length];
		for(int i = 0; i < p.length; i++) {
			temp[i] = p[i].copy(p[i]);
		}
		return temp;
	}
	
	
//	public PeopleVO selectPeople(int id) {
//		
//		return ;
//	}


}
