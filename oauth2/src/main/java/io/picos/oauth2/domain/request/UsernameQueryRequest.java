package io.picos.oauth2.domain.request;


public interface UsernameQueryRequest extends DateRangedQueryRequest {

    /**
     * 用户名
     *
     * @return
     */
    String getUsername();

}
