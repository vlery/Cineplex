package net.cineplex.action.bussiness;

import net.cineplex.model.Member;
import net.cineplex.model.MemberInfo;
import net.cineplex.webmodel.RegisterInfo;

public interface MemberService {
	public boolean checkNickName(String nickName);
	
	public  Member create(String name,String password);

	public  boolean register(Member member,MemberInfo memberInfo);
	
	public void modify(Member member,MemberInfo memberInfo);

	public MemberInfo scanInfo(String id);
	
	public Member scanMemberInfo(String id);
	
	public  void rechargeByBank(String id,double amount);

	public void rechargeByCash(String id,double amount);
	
	public void pause(String id);
	
	public void cancel(String id);
	
	public boolean anthenticate(String nickname,String password);
	
	public boolean ifIdExist(String id);
	
	public boolean anthenticateBank(String id,String bankPassword);

	public void addIntegral(String id,int integral);
	
	public void integralToDeposit(String id);
	
	public String  getIdByNickname(String nickname);
	
	public Member findByNickname(String name);

	public boolean changePassword(String id,String oldPassword,String newPassword);

	public boolean changeOtherInfo(String id, String crtNickname,String nickname, String gender,
			String birthday, String mail, String tel, String bankID);

	public RegisterInfo findRevisableInfo(String id);

}
