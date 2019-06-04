package io.picos.sailfish.oauth2.domain.request;


public interface UserQueryRequest extends UsernameQueryRequest {

	/**
	 * @return 是否启用(或禁用)
	 */
	Boolean getEnabled();

	/**
	 * @return 显示的用户名
	 */
	String getDisplayName();

}
