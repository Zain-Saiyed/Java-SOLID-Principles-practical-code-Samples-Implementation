package org.solid.Bad.LSP;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Event {
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

    public void generateSchedule() {
        if (eventType.equals("concert")) {
            // Reference: https://www.halifax.ca/parks-recreation/events/dartmouth-summer-sunshine-free-concerts
            eventSession.add(new EventSession(null, "2:00 PM - 3:00 PM", null,"Maura Whitman"));
            eventSession.add(new EventSession(null, "3:00 PM - 4:00 PM", null,"Brooklyn Blackmore"));

            System.out.println("Concert Schedule:");
            System.out.println("------------------------------");
            System.out.println("Name    : " + this.eventName);
            System.out.println("Date    : " + this.eventDate);
            System.out.println("------------------------------");

            for (EventSession session : eventSession) {
                System.out.println("Time    : " + session.getSessionTime());
                System.out.println("Artist  : " + session.getSessionSpeaker());
                System.out.println("------------------------------");
            }

        } else if (eventType.equals("exhibition")) {
            // Reference: https://annapolisvalleyexhibition.com/
            eventSession.add(new EventSession("Scarecrow contest", "10:00 AM - 3:00 PM", "14 August, 2023",null));
            eventSession.add(new EventSession("Scarecrow contest", "10:00 PM - 3:00 PM", "15 August, 2023",null));
            eventSession.add(new EventSession("Riverside stage", "8:30 PM - 9:45 PM", "19 August, 2023",null));

            System.out.println("Exhibition Schedule:");
            System.out.println("------------------------------");
            System.out.println("Name    : " + this.eventName);
            System.out.println("------------------------------");

            for (EventSession session : eventSession) {
                System.out.println("Session : " + session.getSessionName());
                System.out.println("Time    : " + session.getSessionTime());
                System.out.println("Date    : " + session.getSessionDate());
                System.out.println("------------------------------");
            }

        } else if (eventType.equals("conference")) {
            // Reference: https://www.slideteam.net/conference-agenda-powerpoint-ppt-template-bundles.html
            eventSession.add(new EventSession("Registration and Welcome", "7:30 AM - 12:00 PM",null, "Chair person"));
            eventSession.add(new EventSession("Pre-conference session", "8:15 AM - 11:15 AM", null, "Chair person"));
            eventSession.add(new EventSession("Lunch Break", "1:30 PM - 2:00 PM", null,"Organising team"));
            eventSession.add(new EventSession("Socialising strategy", "2:00 PM - 3:15 PM", null,"Zen Sai"));
            eventSession.add(new EventSession("CLosing ceremony", "3:15 PM - 3:30 PM", null,"Chair person"));

            System.out.println("Conference Schedule:");
            System.out.println("------------------------------");
            System.out.println("Name    : " + this.eventName);
            System.out.println("Date    : " + this.eventDate);
            System.out.println("------------------------------");

            for (EventSession session : eventSession) {
                System.out.println("Session : " + session.getSessionName());
                System.out.println("Time    : " + session.getSessionTime());
                System.out.println("Speaker : " + session.getSessionSpeaker());
                System.out.println("------------------------------");
            }
        }
    }
}