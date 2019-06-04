package io.picos.sailfish.oauth2.domain.request;


public interface UsernameQueryRequest extends DateRangedQueryRequest {

    /**
     * 用户名
     *
     * @return
     */
    String getUsername();

}
