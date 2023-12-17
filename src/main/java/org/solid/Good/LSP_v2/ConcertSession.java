package org.solid.Good.LSP_v2;

public class ConcertSession extends EventSession {
    private String sessionArtist;

    public ConcertSession(String sessionName, String sessionTime, String sessionArtist) {
        super(sessionName, sessionTime);
        this.sessionArtist = sessionArtist;
    }

    public String getSessionArtist() {
        return sessionArtist;
    }

    @Override
    public String getSessionDetails() {
        return "Artist: " + sessionArtist;
    }
}
