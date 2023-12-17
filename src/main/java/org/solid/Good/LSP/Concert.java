package org.solid.Good.LSP;

import java.time.LocalDate;

public class Concert extends Event{
    public Concert(String eventName, String eventType, LocalDate eventDate){
        super(eventName, eventType, eventDate);
    }
    @Override
    public void generateSchedule() {
        // Reference: https://www.halifax.ca/parks-recreation/events/dartmouth-summer-sunshine-free-concerts
        super.addEventSession(new EventSession(null, "2:00 PM - 3:00 PM", null,"Maura Whitman"));
        super.addEventSession(new EventSession(null, "3:00 PM - 4:00 PM", null,"Brooklyn Blackmore"));

        System.out.println("Concert Schedule:");
        System.out.println("------------------------------");
        System.out.println("Name    : " + super.getEventName());
        System.out.println("Date    : " + super.getEventDate());
        System.out.println("------------------------------");

        for (EventSession session : super.getEventSession()) {
            System.out.println("Time    : " + session.getSessionTime());
            System.out.println("Artist  : " + session.getSessionSpeaker());
            System.out.println("------------------------------");
        }
    }
}