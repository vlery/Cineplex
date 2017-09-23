package net.cineplex.action.bussiness;

import java.util.List;

import net.cineplex.webmodel.HallVO;

public interface ManagerService {
		public 	boolean ifExist(String name);
		public boolean anthenticate(String name,String password);
		public int getIdByName(String name);
		public boolean ifStaff(int id);
		
		public void createHall(HallVO hall);
		public List getHallList();
		public List getSeatByHall(String hid);
		public String  getHallNameByHid(String hid);
		//mÅÅn×ù
		public String  getSeatBySid(String sid);
}
