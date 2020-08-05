package com.giovicente.accessconsumer;

import java.time.LocalDateTime;

public class AccessCsv {

    private long customerId;
    private long doorId;
    private String isAccessAllowed;
    private LocalDateTime accessDate;

    public AccessCsv() { }

    public AccessCsv(long customerId, long doorId, String isAccessAllowed, LocalDateTime accessDate) {
        this.customerId = customerId;
        this.doorId = doorId;
        this.isAccessAllowed = isAccessAllowed;
        this.accessDate = accessDate;
    }

    public long getCustomerId() { return customerId; }

    public void setCustomerId(long customerId) { this.customerId = customerId; }

    public long getDoorId() { return doorId; }

    public void setDoorId(long doorId) { this.doorId = doorId; }

    public String getIsAccessAllowed() { return isAccessAllowed; }

    public void setAccessAllowed(String isAccessAllowed) { this.isAccessAllowed = isAccessAllowed; }

    public LocalDateTime getAccessDate() { return accessDate; }

    public void setAccessDate(LocalDateTime accessDate) { this.accessDate = accessDate; }

}
