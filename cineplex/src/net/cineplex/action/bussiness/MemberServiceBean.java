package net.cineplex.action.bussiness;

import java.sql.Date;
import java.util.List;

import net.cineplex.dao.MemberDao;
import net.cineplex.dao.MemberInfoDao;
import net.cineplex.dao.MembershipDao;
import net.cineplex.dao.RechargeDao;
import net.cineplex.exception.IDGenerateException;
import net.cineplex.factory.DaoFactory;
import net.cineplex.factory.IDFactory;
import net.cineplex.factory.MemberIDFactory;
import net.cineplex.model.Member;
import net.cineplex.model.MemberInfo;
import net.cineplex.model.Membership;
import net.cineplex.model.Recharge;
import net.cineplex.webmodel.RegisterInfo;

public class MemberServiceBean  implements MemberService{
	private static double integral_to_deposit_rate=0.5;
	StatService statService=new StatServiceBean();
	
	static IDFactory memberIDFactory=new MemberIDFactory();
	DaoFactory daoFactory=new DaoFactory();
	@SuppressWarnings("static-access")
	MemberDao memberDao=daoFactory.getMemberDao();
	@SuppressWarnings("static-access")
	MemberInfoDao memberInfoDao=daoFactory.getMemberInfoDao();
	@SuppressWarnings("static-access")
	RechargeDao rechargeDao=daoFactory.getRechargeDao();
	@SuppressWarnings("static-access")
	MembershipDao membershipDao=daoFactory.getMembershipDao();
	@Override
	public boolean checkNickName(String nickName) {
		// TODO Auto-generated method stub
		List<Member> list =memberDao.find();
		for(Member m:list){
			if(m.getNickName().equals(nickName)){
				return true;
			}
		}
		return false;
	}
	//ok
	@Override
	public Member create(String nickName, String password) {
		// TODO Auto-generated method stub
		Member member=new Member();
		member.setNickName(nickName);
		member.setPassword(password);
		return member;
	}
	//ok
	@Override
	public boolean register(Member member, MemberInfo memberInfo) {
		// TODO Auto-generated method stub
		try {
			String id=memberIDFactory.generate();
			System.out.println("create member, id="+ id);
			member.setId(id);
			memberInfo.setId(id);
			member.setBankPassword("123456");
			member.setDeposit(0);
			member.setIntegral(0);
			member.setLevel(0);
			member.setForceful(0);
			member.setStartTime(new DateTool().getDefaultDate());
			memberInfo.setRegisterTime(new DateTool().getNowDate());
			
			memberDao.save(member);
			memberInfoDao.save(memberInfo);
			
			Membership ms=new Membership();
			ms.setId(id);
			ms.setTime(new DateTool().getNowDate());
			ms.setType(0);
			membershipDao.save(ms);
			
		} catch (IDGenerateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	@Override
	public void modify(Member member, MemberInfo memberInfo) {
		// TODO Auto-generated method stub
		memberDao.save(member);
		memberInfoDao.save(memberInfo);
	}

	@Override
	public MemberInfo scanInfo(String id) {
		// TODO Auto-generated method stub
		return memberInfoDao.findById(id);
	}

	@Override
	public Member scanMemberInfo(String id) {
		// TODO Auto-generated method stub
		return memberDao.findById(id);
	}
	@Override
	public void pause(String id){
		Member member =memberDao.findById(id);
		member.setForceful(0);
		member.setLevel(0);
		memberDao.updateById(member);
		Membership ms=new Membership();
		ms.setId(id);
		ms.setTime(new DateTool().getNowDate());
		ms.setType(1);
		membershipDao.save(ms);
	}
	
	@Override
	public void cancel(String id) {
		// TODO Auto-generated method stub
		memberDao.removeById(id);
		memberInfoDao.removeById(id);
		Member member=memberDao.findById(id);
//		System.out.println(member);

		Membership ms=new Membership();
		ms.setId(id);
		ms.setTime(new DateTool().getNowDate());
		ms.setType(2);
		membershipDao.save(ms);
		statService.removeUserStat(id);
	}

	@Override
	public boolean anthenticate(String nickname, String password) {
		// TODO Auto-generated method stub
		List list=memberDao.find();
		for(int i=0;i<list.size();i++){
			Member member=(Member) list.get(i);
			if(member.getNickName().equals(nickname) && member.getPassword().equals(password)){
				testMemberShip(member);
				return true;
			}
		}
		return false;
	}
	private void testMemberShip(Member member) {
		// TODO Auto-generated method stub
		if(member.getForceful()==1){
				Date start=member.getStartTime();
				Date empire=new Date(start.getYear()+1,start.getMonth(),start.getDate());
				Date forceStop=new Date(start.getYear()+2,start.getMonth(),start.getDate());
				Date today=new DateTool().getNowDate();
				if(today.after(forceStop)){
					member.setStartTime(new DateTool().getDefaultDate());
				}else if(today.after(empire)){
					member.setLevel(0);
					member.setForceful(0);
					pause(member.getId());
				}
				
		}
		
	}
	@Override
	public boolean ifIdExist(String id) {
		// TODO Auto-generated method stub
		List<Member> list =memberDao.find();
		for(Member m:list){
			if(m.getId().equals(id)){
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean anthenticateBank(String id, String bankPassword) {
		// TODO Auto-generated method stub
		Member member=memberDao.findById(id);
		if(member.getBankPassword().equals(bankPassword)){
			return true;
		}else{
			return false;
		}
		
	}

	@Override
	public void addIntegral(String id,int integral) {
		// TODO Auto-generated method stub
		Member member=memberDao.findById(id);
		member.setIntegral(member.getIntegral()+integral);
	}

	@Override
	public void integralToDeposit(String id) {
		// TODO Auto-generated method stub
		Member member=memberDao.findById(id);
		member.setDeposit(member.getIntegral()*integral_to_deposit_rate+member.getDeposit());
		member.setIntegral(0);
		memberDao.updateById(member);
	}

	@Override
	public void rechargeByBank(String id, double amount) {
		// TODO Auto-generated method stub
		Recharge recharge=new Recharge();
		recharge.setId(id);
		recharge.setType(0);
		recharge.setAmount(amount);
		recharge.setTime(new DateTool().getNowDate());
		Member member =memberDao.findById(id);
		member.setDeposit(member.getDeposit()+amount);
		testIfUpgrade(amount,member);
		//System.out.println(member.getDeposit());
		memberDao.updateById(member);
		rechargeDao.save(recharge);
	}

	@Override
	public void rechargeByCash(String id, double amount) {
		// TODO Auto-generated method stub
		Recharge recharge=new Recharge();
		recharge.setId(id);
		recharge.setType(1);
		recharge.setAmount(amount);
		recharge.setTime(new DateTool().getNowDate());
		Member member =memberDao.findById(id);
		member.setDeposit(member.getDeposit()+amount);
		testIfUpgrade(amount,member);
		memberDao.updateById(member);
		rechargeDao.save(recharge);
	}
	private void testIfUpgrade(double amount,Member member) {
		// TODO Auto-generated method stub
			int level=new MemberLevel().getLevel(amount);
			int db_level=member.getLevel();
			
			if(amount>=200){
				if(level>db_level){
					member.setLevel(level);
					
					if(db_level==0){
						member.setForceful(1);
						member.setStartTime(new DateTool().getNowDate());
					}
					memberDao.updateById(member);
				}
			}else{
				Date start=member.getStartTime();
				Date empire=new Date(start.getYear()+1,start.getMonth(),start.getDate());
				Date today=new DateTool().getNowDate();
				double futureDeposit=member.getDeposit()+amount;
				//继续会员
				if((!today.after(empire))&&member.getLevel()==0&&futureDeposit>=200){
					member.setForceful(1);
					member.setStartTime(new DateTool().getNowDate());
					member.setLevel(1);
					memberDao.updateById(member);
				}
			}
			
			
	}
	//ok
	@Override
	public String getIdByNickname(String nickname) {
		// TODO Auto-generated method stub
		Member member=memberDao.findByName(nickname);
		return member.getId();
	}
	//ok
	@Override
	public Member findByNickname(String nickname) {
		// TODO Auto-generated method stub
		return memberDao.findByName(nickname);
	}
	@Override
	public boolean changePassword(String id,String oldPassword, String newPassword) {
		
		// TODO Auto-generated method stub
		Member member=memberDao.findById(id);
		if(member.getPassword().equals(oldPassword)){
			member.setPassword(newPassword);
			memberDao.updateById(member);
			return true;
		}else{
			return false;
		}
		
		
		
	}
	@Override
	public boolean changeOtherInfo(String id, String crtNickname,String nickname, String gender,
			String birthday, String mail, String tel, String bankID) {
		// TODO Auto-generated method stub
		if((!crtNickname.equals(nickname))&&checkNickName(nickname)){
			return false;
		}else{
			Member member=memberDao.findById(id);
			MemberInfo memberInfo=memberInfoDao.findById(id);
			member.setNickName(nickname);
			
			memberInfo.setBirthday(new DateTool().stringToDate(birthday));
			
			if(gender.equals("女")){
				memberInfo.setGender(0);
			}else{
				memberInfo.setGender(1);
			}
			memberInfo.setTel(tel);
			memberInfo.setMail(mail);
			member.setBankID(bankID);
			memberDao.updateById(member);
			memberInfoDao.updateById(memberInfo);
			return true;
		}
	}
	@Override
	public RegisterInfo findRevisableInfo(String id) {
		// TODO Auto-generated method stub
		Member member=memberDao.findById(id);
		MemberInfo memberInfo=memberInfoDao.findById(id);
		RegisterInfo ri=new RegisterInfo();
		
		ri.setBankID(member.getBankID());
		
		ri.setBirthday(String.valueOf(memberInfo.getBirthday()));
		ri.setCity(String.valueOf(memberInfo.getCity()));
		ri.setProvince(String.valueOf(memberInfo.getCity()));
		ri.setMail(memberInfo.getMail());
		ri.setName(member.getName());
		ri.setTel(memberInfo.getTel());
		if(memberInfo.getGender()==0){
			ri.setGender("男");
		}else{
			ri.setGender("女");
		}
		
		return ri;
	}

}
