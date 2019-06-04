package io.picos.sailfish.oauth2.exception;

/**
 * @author dz
 */
public class PasscodeException extends ApplicationException {

	public PasscodeException() {
	}

	public PasscodeException(String message) {
		super(message);
	}

	public PasscodeException(String message, Throwable cause) {
		super(message, cause);
	}

	public PasscodeException(Throwable cause) {
		super(cause);
	}

	public PasscodeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
