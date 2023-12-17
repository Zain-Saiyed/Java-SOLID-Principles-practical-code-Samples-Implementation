package org.solid.Good.LSP_v2;

import java.util.Date;

public class Exhibition extends Event {
    public Exhibition(String eventName, Date eventDate){
        super(eventName, eventDate);
    }

    @Override
    public void generateSchedule() {
        // Reference: https://www.halifax.ca/parks-recreation/events/dartmouth-summer-sunshine-free-concerts
        super.addEventSession(new ExhibitionSession("Scarecrow contest", "10:00 AM - 3:00 PM", "14 August, 2023"));
        super.addEventSession(new ExhibitionSession("Scarecrow contest", "10:00 PM - 3:00 PM", "15 August, 2023"));
        super.addEventSession(new ExhibitionSession("Riverside stage", "8:30 PM - 9:45 PM", "19 August, 2023"));

        System.out.println("Exhibition Schedule:");
        System.out.println("------------------------------");
        System.out.println("Name    : " + super.getEventName());
        System.out.println("------------------------------");

        for (EventSession session : super.getEventSession()) {
            System.out.println("Session : " + session.getSessionName());
            System.out.println("Time    : " + session.getSessionTime());
            System.out.println(session.getSessionDetails());
            System.out.println("------------------------------");
        }
    }
}