package io.picos.sailfish.oauth2.exception;

/**
 *
 */
public class UserException extends ApplicationException {

	public UserException() {
	}

	public UserException(String message) {
		super(message);
	}

	public UserException(String message, Throwable cause) {
		super(message, cause);
	}

	public UserException(Throwable cause) {
		super(cause);
	}
}
