package io.picos.oauth2.domain.request.impl;


import io.picos.oauth2.domain.request.DateRangedQueryRequest;

import java.util.Date;

public class DateRangedQueryParameter extends PageQueryParameter implements DateRangedQueryRequest {

    private Date beginDate;

    private Date endDate;

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

}
