package com.abc.order.dto;

import java.io.Serializable;
import java.util.List;

public class CommonOrderResponse implements Serializable {
    private Boolean status = true;
    private List<String> failReasons;

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public List<String> getFailReasons() {
        return failReasons;
    }

    public void setFailReasons(List<String> failReasons) {
        this.failReasons = failReasons;
    }
}
