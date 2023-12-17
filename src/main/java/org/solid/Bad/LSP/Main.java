package org.solid.Bad.LSP;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        System.out.println("\n===========================================================");
        System.out.println("LSP : Event Schedule generation for different type of events");
        System.out.println("===========================================================");
        System.out.println("*** Failing Liskov Substitution Principle");


        System.out.println("\n===========================================================");
        System.out.println("Scenario 1:' Concert ' Event type");
        System.out.println("===========================================================");
        Event concertEvent = new Event("Dartmouth Summer Sunshine Free Concerts", "Concert", LocalDate.parse("2023-07-08"));
        concertEvent.generateSchedule();

        System.out.println("\n===========================================================");
        System.out.println("Scenario 2:' Exhibition ' Event type");
        System.out.println("===========================================================");
        Event exhibitionEvent = new Event("Annapolis Valley Exhibition", "Exhibition",null);
        exhibitionEvent.generateSchedule();

        System.out.println("\n===========================================================");
        System.out.println("Scenario 3: ' Conference ' Event type");
        System.out.println("===========================================================");
        Event conferenceEvent = new Event("Human Resource Management Conference", "Conference", LocalDate.parse("2023-08-15"));
        conferenceEvent.generateSchedule();
    }
}