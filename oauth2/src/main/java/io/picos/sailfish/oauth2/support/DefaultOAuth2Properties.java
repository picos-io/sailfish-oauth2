package io.picos.sailfish.oauth2.support;

import io.picos.sailfish.oauth2.config.OAuth2Properties;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("oauth2")
public class DefaultOAuth2Properties implements OAuth2Properties {

    private String idpEndpoint;

    public String getIdpEndpoint() {
        return idpEndpoint;
    }

    public void setIdpEndpoint(String idpEndpoint) {
        this.idpEndpoint = idpEndpoint;
    }

}
