package io.picos.oauth2.support.security.rest;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author dz
 */
public class AuthenticationSuccessHandlerRestImpl implements AuthenticationSuccessHandler {


	@Override
	public void onAuthenticationSuccess(HttpServletRequest request,
										HttpServletResponse response,
										Authentication authentication) throws IOException, ServletException {
		response.setStatus(HttpServletResponse.SC_OK);
		response.getWriter().append("{\"succeed\":true}");
		response.flushBuffer();
	}

}
