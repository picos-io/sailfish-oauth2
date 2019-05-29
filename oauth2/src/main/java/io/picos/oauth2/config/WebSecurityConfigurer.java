package io.picos.oauth2.config;

import io.picos.oauth2.support.security.UserDetailsAuthenticationProviderImpl;
import io.picos.oauth2.support.security.UserDetailsServiceImpl;
import io.picos.oauth2.support.security.rest.AuthenticationFailureHandlerRestImpl;
import io.picos.oauth2.support.security.rest.AuthenticationSuccessHandlerRestImpl;
import io.picos.oauth2.support.security.rest.LogoutSuccessHandlerRestImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.EnableGlobalAuthentication;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;

@Configuration
@EnableGlobalAuthentication
public class WebSecurityConfigurer extends WebSecurityConfigurerAdapter {

    private static final Logger logger = LoggerFactory.getLogger(WebSecurityConfigurer.class);

    @Autowired
    private OAuth2Properties oAuth2Properties;

    @Override
    public void configure(AuthenticationManagerBuilder authMgrBuilder) {
        authMgrBuilder.authenticationProvider(userDetailsAuthenticationProviderImpl()).eraseCredentials(true);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.requestMatchers()
            .antMatchers("/oauth/authorize")
            .and()
            .authorizeRequests()
            .anyRequest().authenticated()
            .and()
            .formLogin().permitAll();

        http.logout()
            .logoutUrl("/oauth/logout")
            .logoutSuccessHandler(logoutSuccessHandlerImpl())
            .deleteCookies("JSESSIONID");

        http.sessionManagement()
            .maximumSessions(1)
            .expiredUrl("/oauth/logout");
    }

    @Bean
    public LogoutSuccessHandler logoutSuccessHandlerImpl() {
        return new LogoutSuccessHandlerRestImpl();
    }

    @Bean
    public SecurityContextLogoutHandler logoutHandler() {
        SecurityContextLogoutHandler logoutHandler = new SecurityContextLogoutHandler();
        logoutHandler.setInvalidateHttpSession(true);
        logoutHandler.setClearAuthentication(true);
        return logoutHandler;
    }

    @Bean
    public AuthenticationFailureHandler authenticationFailureHandlerImpl() {
        return new AuthenticationFailureHandlerRestImpl();
    }

    @Bean
    public AuthenticationSuccessHandler authenticationSuccessHandlerImpl() {
        return new AuthenticationSuccessHandlerRestImpl();
    }

    @Bean
    public AuthenticationProvider userDetailsAuthenticationProviderImpl() {
        return new UserDetailsAuthenticationProviderImpl();
    }

    @Bean
    public UserDetailsService userDetailsServiceImpl() {
        return new UserDetailsServiceImpl();
    }

}

