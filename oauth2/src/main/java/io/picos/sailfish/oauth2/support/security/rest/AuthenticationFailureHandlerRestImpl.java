package io.picos.sailfish.oauth2.support.security.rest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author dz
 */
public class AuthenticationFailureHandlerRestImpl implements AuthenticationFailureHandler {

    private static final Log logger = LogFactory.getLog(AuthenticationFailureHandlerRestImpl.class);


    @Override
    public void onAuthenticationFailure(HttpServletRequest request,
                                        HttpServletResponse response,
                                        AuthenticationException exception) throws IOException, ServletException {
        logger.error("The ajax request is not authenticated.", exception);
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.getWriter().append(String.format("{\"succeed\":false,\"message\":\"%s\"}", exception.getMessage()));
        response.flushBuffer();
    }

}
