package net.cineplex.webmodel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class HallVO {
	String name;
	List list;
	
	public void setList(List list){
		this.list=list;
	}
	public List getList(){
		return list;
	}
	public void setName(String name){
		this.name=name;
	}
	public String getName(){
		return name;
	}
	
	public int getRowNum(){
		return list.size();
	}
	public Row getItem(int i){
		Row row=(Row) list.get(i);
		return row;
	}
	
	public void init(){
		list=new ArrayList<Row>();
	    name="";
	}
	
	public void addRow(Row row){
		for(int i=0;i<list.size();i++){
			Row r=(Row) list.get(i);
			if(r.getIndex()==row.getIndex()){
				list.remove(i);
				break;
			}
		}
		list.add(row);
		Collections.sort(list, new Comparator() {
		      @Override
		      public int compare(Object o1, Object o2) {
		    	  Row r1=(Row)o1;
		    	  Row r2=(Row)o2;
		    	  return new Integer(r1.getIndex()-r2.getIndex());
		      }
		    });
	}
	
}
