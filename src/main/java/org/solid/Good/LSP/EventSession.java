package org.solid.Good.LSP;

public class EventSession {
    private String sessionName;
    private String sessionTime;
    private String sessionDate;
    private String sessionSpeaker;

    public EventSession(String sessionName, String sessionTime, String sessionDate,String sessionSpeaker) {
        this.sessionName = sessionName;
        this.sessionTime = sessionTime;
        this.sessionDate = sessionDate;
        this.sessionSpeaker = sessionSpeaker;
    }

    public String getSessionName() {
        return sessionName;
    }

    public void setSessionName(String sessionName) {
        this.sessionName = sessionName;
    }

    public String getSessionTime() {
        return sessionTime;
    }

    public void setSessionTime(String sessionTime) {
        this.sessionTime = sessionTime;
    }

    public String getSessionSpeaker() {
        return sessionSpeaker;
    }

    public String getSessionDate() {
        return sessionDate;
    }

    public void setSessionSpeaker(String sessionSpeaker) {
        this.sessionSpeaker = sessionSpeaker;
    }
}