package net.cineplex.action.bussiness;

import java.util.List;

import net.cineplex.dao.HallDao;
import net.cineplex.dao.ManagerDao;


import net.cineplex.dao.SeatDao;
import net.cineplex.factory.DaoFactory;
import net.cineplex.factory.IDFactory;
import net.cineplex.factory.MemberIDFactory;
import net.cineplex.model.Hall;
import net.cineplex.model.Manager;
import net.cineplex.model.Seat;
import net.cineplex.webmodel.HallVO;
import net.cineplex.webmodel.Row;

public class ManagerServiceBean implements ManagerService{
	static IDFactory memberIDFactory=new MemberIDFactory();
	DaoFactory daoFactory=new DaoFactory();
	@SuppressWarnings("static-access")
	ManagerDao managerDao=daoFactory.getManagerDao();
	@SuppressWarnings("static-access")
	HallDao hallDao=daoFactory.getHallDao();
	@SuppressWarnings("static-access")
	SeatDao seatDao=daoFactory.getSeatDao();
	
	QuizService quizService=new QuizServiceBean();
	@Override
	public boolean ifExist(String name) {
		// TODO Auto-generated method stub
		List<Manager> list =managerDao.find();
		for(Manager m:list){
			
			if(m.getName().equals(name)){		
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean anthenticate(String name, String password) {
		// TODO Auto-generated method stub
		List<Manager> list =managerDao.find();
		for(Manager m:list){
			if(m.getName().equals(name)&&m.getPassword().equals(password)){
				quizService.checkResult();
				return true;
			}
		}
		return false;
	}

	@Override
	public int getIdByName(String name) {
		// TODO Auto-generated method stub
		Manager manager= managerDao.findByName(name);
		return manager.getId();
	}

	@Override
	public boolean ifStaff(int id) {
		// TODO Auto-generated method stub
		Manager manager=managerDao.findById(id);
		if(manager.getType()==2){
			return true;
		}else{
			return false;
		}
		
		
		
	}

	@Override
	public void createHall(HallVO hallVO) {
		// TODO Auto-generated method stub
		//添加至hall表
		Hall hall=new Hall();
		hall.setName(hallVO.getName());
		hall.setRow(hallVO.getRowNum());
		hallDao.save(hall);
		String hid=hallDao.getHidByName(hallVO.getName());

		//添加至seat表
		Seat seat=new Seat();
		seat.setHid(hid);
		for(int n=0;n<hallVO.getRowNum();n++){
			Row row=hallVO.getItem(n);
			seat.setRow(row.getIndex());
			for(int i=0;i<row.getSeats();i++){
				seat.setSeatIndex(i+1);
				seatDao.save(seat);
			}
		}
	}

	@Override
	public List getHallList() {
		// TODO Auto-generated method stub
		List list=hallDao.find();
		
		return list;
	}

	@Override
	public List getSeatByHall(String hid) {
		// TODO Auto-generated method stub
		return seatDao.findByHall(hid);
	}

	@Override
	public String getHallNameByHid(String hid) {
		// TODO Auto-generated method stub
		Hall hall=hallDao.findById(hid);
		return hall.getName();
	}

	@Override
	public String getSeatBySid(String sid) {
		// TODO Auto-generated method stub
		Seat seat=seatDao.findById(sid);
		String s=String.valueOf(seat.getRow())+"排"
				+String.valueOf(seat.getSeatIndex())+"座";
		return s;
	}
}
