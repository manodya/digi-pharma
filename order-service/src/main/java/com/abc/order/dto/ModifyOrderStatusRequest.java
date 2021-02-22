package com.abc.order.dto;

import java.io.Serializable;

public class ModifyOrderStatusRequest implements Serializable {

    private String remarks;

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
