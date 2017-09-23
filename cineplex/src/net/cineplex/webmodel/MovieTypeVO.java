package net.cineplex.webmodel;

import java.util.ArrayList;
import java.util.List;

public class MovieTypeVO {
	String[] type={"°®ÇéÆ¬","¾çÇéÆ¬","Ï²¾çÆ¬","¼ÒÍ¥Æ¬","Â×ÀíÆ¬",
			"ÎÄÒÕÆ¬","ÒôÀÖÆ¬","¸èÎèÆ¬","¶¯ÂşÆ¬","Î÷²¿Æ¬",
			"ÎäÏÀÆ¬","¹Å×°Æ¬","¶¯×÷Æ¬","¿Ö²ÀÆ¬","¾ªã¤Æ¬",
			"Ã°ÏÕÆ¬","·¸×ïÆ¬","ĞüÒÉÆ¬","¼ÇÂ¼Æ¬","Õ½ÕùÆ¬",
			"ÀúÊ·Æ¬","´«¼ÇÆ¬","ÌåÓıÆ¬","¿Æ»ÃÆ¬","Ä§»ÃÆ¬",
			"Ææ»ÃÆ¬"};
	
	List list;

	public MovieTypeVO(){
		//³õÊ¼»¯
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
