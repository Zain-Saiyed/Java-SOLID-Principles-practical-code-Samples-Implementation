package org.solid.Good.LSP_v2;

import java.util.Date;

public class Conference extends Event {
    public Conference(String eventName, Date eventDate){
        super(eventName, eventDate);
    }

    @Override
    public void generateSchedule() {
        // Reference: https://www.halifax.ca/parks-recreation/events/dartmouth-summer-sunshine-free-concerts
        super.addEventSession(new ConferenceSession("Registration and Welcome", "7:30 AM - 12:00 PM", "Chair person"));
        super.addEventSession(new ConferenceSession("Pre-conference session", "8:15 AM - 11:15 AM", "Chair person"));
        super.addEventSession(new ConferenceSession("Lunch Break", "1:30 PM - 2:00 PM", "Organising team"));
        super.addEventSession(new ConferenceSession("Socialising strategy", "2:00 PM - 3:15 PM", "Zen Sai"));
        super.addEventSession(new ConferenceSession("Closing ceremony", "3:15 PM - 3:30 PM", "Chair person"));

        System.out.println("Conference Schedule:");
        System.out.println("------------------------------");
        System.out.println("Name    : " + super.getEventName());
        System.out.println("Date    : " + super.getEventDate());
        System.out.println("------------------------------");

        for (EventSession session : super.getEventSession()) {
//            ConferenceSession conferenceSession = (ConferenceSession) session;
            System.out.println("Session : " + session.getSessionName());
            System.out.println("Time    : " + session.getSessionTime());
            System.out.println(session.getSessionDetails());
            System.out.println("------------------------------");
        }
    }
}
