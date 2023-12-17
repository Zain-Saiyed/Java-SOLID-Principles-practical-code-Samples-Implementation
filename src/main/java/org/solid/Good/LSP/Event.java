package org.solid.Good.LSP;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public abstract class Event {
    private String eventName;
    private String eventType;
    private LocalDate eventDate;
    List<EventSession> eventSession;

    public Event(String eventName, String eventType, LocalDate eventDate) {
        this.eventName = eventName;
        this.eventType = eventType.toLowerCase();
        this.eventDate = eventDate;
        this.eventSession = new ArrayList<>();
    }

    public String getEventName() {
        return eventName;
    }

    public String getEventType() {
        return eventType;
    }

    public LocalDate getEventDate() {
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