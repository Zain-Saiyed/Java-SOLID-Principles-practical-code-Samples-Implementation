package org.solid.Good.LSP;

import java.time.LocalDate;

public class Exhibition extends Event{
    public Exhibition(String eventName, String eventType, LocalDate eventDate){
        super(eventName, eventType, eventDate);
    }
    @Override
    public void generateSchedule() {
        // Reference: https://www.halifax.ca/parks-recreation/events/dartmouth-summer-sunshine-free-concerts
        super.addEventSession(new EventSession("Scarecrow contest", "10:00 AM - 3:00 PM", "14 August, 2023",null));
        super.addEventSession(new EventSession("Scarecrow contest", "10:00 PM - 3:00 PM", "15 August, 2023",null));
        super.addEventSession(new EventSession("Riverside stage", "8:30 PM - 9:45 PM", "19 August, 2023",null));

        System.out.println("Exhibition Schedule:");
        System.out.println("------------------------------");
        System.out.println("Name    : " + super.getEventName());
        System.out.println("------------------------------");

        for (EventSession session : super.getEventSession()) {
            System.out.println("Session : " + session.getSessionName());
            System.out.println("Time    : " + session.getSessionTime());
            System.out.println("Date    : " + session.getSessionDate());
            System.out.println("------------------------------");
        }
    }
}