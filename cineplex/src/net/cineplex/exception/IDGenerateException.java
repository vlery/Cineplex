package net.cineplex.exception;

public class IDGenerateException  extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		public IDGenerateException(){
			super();
			System.out.println("Space Overflow : can't create any more ID use 7 numbers!!!");
		}
		
}
