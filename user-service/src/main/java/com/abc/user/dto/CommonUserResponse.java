package com.abc.user.dto;

import java.io.Serializable;
import java.util.List;

public class CommonUserResponse implements Serializable {
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
