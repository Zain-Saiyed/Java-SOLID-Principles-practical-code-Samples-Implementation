package org.solid.Good.LSP_v2;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class Event {
    private String eventName;
    private Date eventDate;
    List<EventSession> eventSession;

    public Event(String eventName, Date eventDate) {
        this.eventName = eventName;
        this.eventDate = eventDate;
        this.eventSession = new ArrayList<>();
    }

    public String getEventName() {
        return eventName;
    }

    public Date getEventDate() {
        return eventDate;
    }

    public List<EventSession> getEventSession() {
        return eventSession;
    }

    public void addEventSession(EventSession eventSession) {
        this.eventSession.add(eventSession);
    }

    public abstract void generateSchedule();
}