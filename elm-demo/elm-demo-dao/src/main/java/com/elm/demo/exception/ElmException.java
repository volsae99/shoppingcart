package com.elm.demo.exception;

public class ElmException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public ElmException() { 
		super(); 
	}

	public ElmException(String msg, Throwable e) { 
		super(msg, e); 
	}

	public ElmException(String msg) {
		super(msg);
	}

	public ElmException(Throwable e) {
		super(e);
	}	

}
