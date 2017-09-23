package net.cineplex.exception;

public class IDRecoveryException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public  IDRecoveryException(){
		super();
		System.out.println("Invalid ID: This ID haven't been created !!!");
	}
}
