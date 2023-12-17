package org.solid.Good.LSP_v2;

import java.util.Date;

public class Concert extends Event {
    public Concert(String eventName, Date eventDate){ super(eventName,  eventDate); }

    @Override
    public void generateSchedule() {
        // Reference: https://www.halifax.ca/parks-recreation/events/dartmouth-summer-sunshine-free-concerts
        super.addEventSession(new ConcertSession("Jazz", "2:00 PM - 3:00 PM", "Maura Whitman"));
        super.addEventSession(new ConcertSession("Hip-Hop", "3:00 PM - 4:00 PM", "Brooklyn Blackmore"));

        System.out.println("Concert Schedule:");
        System.out.println("------------------------------");
        System.out.println("Name    : " + super.getEventName());
        System.out.println("Date    : " + super.getEventDate());
        System.out.println("------------------------------");

        for (EventSession session : super.getEventSession()) {
            System.out.println("Session : " + session.getSessionName());
            System.out.println("Time    : " + session.getSessionTime());
            System.out.println(session.getSessionDetails());
            System.out.println("------------------------------");
        }
    }
}