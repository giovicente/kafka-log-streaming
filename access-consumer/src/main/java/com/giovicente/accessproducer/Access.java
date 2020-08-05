package com.giovicente.accessproducer;

import java.time.LocalDateTime;

public class Access {

    private long customerId;
    private long doorId;
    private boolean isAccessAllowed;
    private LocalDateTime accessDate;

    public Access() { }

    public Access(long customerId, long doorId, boolean isAccessAllowed, LocalDateTime accessDate) {
        this.customerId = customerId;
        this.doorId = doorId;
        this.isAccessAllowed = isAccessAllowed;
        this.accessDate = accessDate;
    }

    public long getCustomerId() { return customerId; }

    public void setCustomerId(long customerId) { this.customerId = customerId; }

    public long getDoorId() { return doorId; }

    public void setDoorId(long doorId) { this.doorId = doorId; }

    public boolean isAccessAllowed() { return isAccessAllowed; }

    public void setAccessAllowed(boolean accessAllowed) { isAccessAllowed = accessAllowed; }

    public LocalDateTime getAccessDate() { return accessDate; }

    public void setAccessDate(LocalDateTime accessDate) { this.accessDate = accessDate; }

}
