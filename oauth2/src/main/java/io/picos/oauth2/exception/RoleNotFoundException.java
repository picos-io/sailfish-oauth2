package io.picos.oauth2.exception;


/**
 *
 */
public class RoleNotFoundException extends RoleException {

	public RoleNotFoundException() {
	}

	public RoleNotFoundException(String message) {
		super(message);
	}

	public RoleNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public RoleNotFoundException(Throwable cause) {
		super(cause);
	}
}
