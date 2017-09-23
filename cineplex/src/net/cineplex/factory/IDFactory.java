package net.cineplex.factory;

import net.cineplex.exception.IDGenerateException;
import net.cineplex.exception.IDRecoveryException;

public abstract class IDFactory {
	
	abstract public   String generate() throws IDGenerateException;
	abstract public   void  recovery(String id) throws IDRecoveryException;
}