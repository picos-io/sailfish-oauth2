package io.picos.oauth2.support.security.mvc;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author dz
 */
public class AuthenticationFailureHandlerMvcImpl extends SimpleUrlAuthenticationFailureHandler {

	private static final Log logger = LogFactory.getLog(AuthenticationFailureHandlerMvcImpl.class);

	public AuthenticationFailureHandlerMvcImpl() {
	}

	public AuthenticationFailureHandlerMvcImpl(String defaultFailureUrl) {
		super(defaultFailureUrl);
	}

	@Override
	public void onAuthenticationFailure(HttpServletRequest request,
										HttpServletResponse response,
										AuthenticationException exception) throws IOException, ServletException {
		logger.error(exception, exception);
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			logger.warn("The ajax request is not authenticated.");
			response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
			response.flushBuffer();
			return;
		}
		super.onAuthenticationFailure(request, response, exception);
	}

}
