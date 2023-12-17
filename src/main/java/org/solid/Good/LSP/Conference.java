package org.solid.Good.LSP;

import java.time.LocalDate;

public class Conference extends Event{
    public Conference(String eventName, String eventType, LocalDate eventDate){
        super(eventName, eventType, eventDate);
    }
    @Override
    public void generateSchedule() {
        // Reference: https://www.halifax.ca/parks-recreation/events/dartmouth-summer-sunshine-free-concerts
        super.addEventSession(new EventSession("Registration and Welcome", "7:30 AM - 12:00 PM",null, "Chair person"));
        super.addEventSession(new EventSession("Pre-conference session", "8:15 AM - 11:15 AM", null, "Chair person"));
        super.addEventSession(new EventSession("Lunch Break", "1:30 PM - 2:00 PM", null,"Organising team"));
        super.addEventSession(new EventSession("Socialising strategy", "2:00 PM - 3:15 PM", null,"Zen Sai"));
        super.addEventSession(new EventSession("CLosing ceremony", "3:15 PM - 3:30 PM", null,"Chair person"));

        System.out.println("Conference Schedule:");
        System.out.println("------------------------------");
        System.out.println("Name    : " + super.getEventName());
        System.out.println("Date    : " + super.getEventDate());
        System.out.println("------------------------------");

        for (EventSession session : super.getEventSession()) {
            System.out.println("Session : " + session.getSessionName());
            System.out.println("Time    : " + session.getSessionTime());
            System.out.println("Speaker : " + session.getSessionSpeaker());
            System.out.println("------------------------------");
        }
    }
}