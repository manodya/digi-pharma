package com.abc.user.util;

public enum AccountStatus {
    OPEN_PENDING_ACTIVATION("Open Pending Activation"),
    ACTIVATED_PENDING_KYC("Activated Pending KYC"),
    ACTIVATION_FAILED("Activation Failed."),
    ACTIVATED("Activated"),
    LOCKED("Locked."),
    DEACTIVATED("Deactivated.");

    private final String status;

    AccountStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return this.status;
    }
}
