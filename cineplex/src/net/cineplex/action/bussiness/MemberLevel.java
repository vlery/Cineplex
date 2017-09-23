package net.cineplex.action.bussiness;

public class MemberLevel {
	int[] recharge={0,200,300,400,500,1000};
	double[] discount={1,0.95,0.9,0.88,0.85,0.7};
	
	public int getLevel(double amount){
		if(amount>=recharge[5]){
			return 5;
		}else if(amount>=recharge[4]){
			return 4;
		}else if(amount>=recharge[3]){
			return 3;
		}else if(amount>=recharge[2]){
			return 2;
		}else if(amount>=recharge[1]){
			return 1;
		}else{
			return 0;
		}
	}
	public double doDiscount(double amount,int level){
		return amount*discount[level];
	}
	
}
