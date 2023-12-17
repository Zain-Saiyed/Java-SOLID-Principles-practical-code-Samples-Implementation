package org.solid.Good.LSP_v2;

public class ConferenceSession extends EventSession {
    private String sessionSpeaker;

    public ConferenceSession(String sessionName, String sessionTime, String sessionSpeaker) {
        super(sessionName, sessionTime);
        this.sessionSpeaker = sessionSpeaker;
    }

    public String getSessionSpeaker() {
        return sessionSpeaker;
    }

    @Override
    public String getSessionDetails() {
        return "Speaker: " + sessionSpeaker;
    }
}
