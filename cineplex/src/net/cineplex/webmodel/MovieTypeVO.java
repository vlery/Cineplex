package net.cineplex.webmodel;

import java.util.ArrayList;
import java.util.List;

public class MovieTypeVO {
	String[] type={"����Ƭ","����Ƭ","ϲ��Ƭ","��ͥƬ","����Ƭ",
			"����Ƭ","����Ƭ","����Ƭ","����Ƭ","����Ƭ",
			"����Ƭ","��װƬ","����Ƭ","�ֲ�Ƭ","���Ƭ",
			"ð��Ƭ","����Ƭ","����Ƭ","��¼Ƭ","ս��Ƭ",
			"��ʷƬ","����Ƭ","����Ƭ","�ƻ�Ƭ","ħ��Ƭ",
			"���Ƭ"};
	
	List list;

	public MovieTypeVO(){
		//��ʼ��
	}
	
	
	public void setList(List list){
		this.list=list;
	}
	public List getList(){
		return list;
	}
	public int getSize(){
		return list.size();
	}
	public String getItem(int i){
//		System.out.println(i+"-----------"+type[i]);
		int mt=(int) list.get(i);
		return type[mt];
	}
}
