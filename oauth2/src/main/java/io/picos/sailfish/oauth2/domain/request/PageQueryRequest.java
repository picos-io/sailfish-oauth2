package io.picos.sailfish.oauth2.domain.request;

/**
 * page query request
 */
public interface PageQueryRequest extends AbstractQueryRequest {

	/**
	 * @return 0 as default
	 */
	int getStart();

	/**
	 * @return 20 as default
	 */
	int getLimit();

}
