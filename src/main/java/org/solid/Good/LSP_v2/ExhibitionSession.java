package org.solid.Good.LSP_v2;

public class ExhibitionSession extends EventSession {
    private String sessionDate;

    public ExhibitionSession(String sessionName, String sessionTime, String sessionDate) {
        super(sessionName, sessionTime);
        this.sessionDate = sessionDate;
    }

    public String getSessionDate() {
        return sessionDate;
    }

    @Override
    public String getSessionDetails() {
        return "Date: " + sessionDate;
    }
}