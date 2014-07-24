package com.mc.rad.exceptions;

@SuppressWarnings("serial")
public class ApplicationException extends Exception {

	public ApplicationException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ApplicationException(String arg0, Throwable arg1, boolean arg2,
			boolean arg3) {
		super(arg0, arg1, arg2, arg3);

	}

	public ApplicationException(String arg0, Throwable arg1) {
		super(arg0, arg1);

	}

	public ApplicationException(String arg0) {
		super(arg0);

	}

	public ApplicationException(Throwable arg0) {
		super(arg0);

	}

}
