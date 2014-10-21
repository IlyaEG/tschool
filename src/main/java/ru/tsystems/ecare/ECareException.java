package ru.tsystems.ecare;

public class ECareException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 15566752341257L;
	String message;

	public ECareException(String message) {
		super(message);
		this.message = message;
	}

	public ECareException(String message, Throwable e) {
		super(message, e);
		this.message = message;
	}

	@Override
	public String getMessage() {
		return message;
	}
}
