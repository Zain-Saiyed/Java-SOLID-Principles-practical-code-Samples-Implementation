package org.solid.Good.LSP_v2;

public abstract class EventSession {
    private String sessionName;
    private String sessionTime;

    public EventSession(String sessionName, String sessionTime) {
        this.sessionName = sessionName;
        this.sessionTime = sessionTime;
    }

    public String getSessionName() {
        return sessionName;
    }

    public String getSessionTime() {
        return sessionTime;
    }

    public abstract String getSessionDetails();
}