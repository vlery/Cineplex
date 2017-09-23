package net.cineplex.action.bussiness;

public class RechargeType {

	static String[] type={"银联支付","现金支付"};
	public static String  getTypeName(int i){
		return type[i];
	}
}
