package com.abc.order.dto;

import java.io.Serializable;

public class ModifyOrderStatusRequest implements Serializable {

    private static final long serialVersionUID = 159348938L;

    private String remarks;

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
