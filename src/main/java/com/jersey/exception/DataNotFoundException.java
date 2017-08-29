package com.jersey.exception;

public class DataNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1756578730357571248L;

	public DataNotFoundException(String msg)
	{
		super(msg);
	}
}
