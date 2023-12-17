package org.solid.Good.LSP_v2;

import org.solid.Good.LSP.Concert;
import org.solid.Good.LSP.Conference;
import org.solid.Good.LSP.Event;
import org.solid.Good.LSP.Exhibition;

import java.time.LocalDate;

public class Main {
    public static void main (String args[]) {

        System.out.println("\n============================================================");
        System.out.println("LSP : Event Schedule generation for different type of events");
        System.out.println("============================================================");
        System.out.println("*** Completely Adhering to Liskov Substitution Principle");

        Event eventObject;

        System.out.println("\n===========================================================");
        System.out.println("Scenario 1:' Music Concert ' Event type");
        System.out.println("===========================================================");
        eventObject = new Concert("Dartmouth Summer Sunshine Free Concerts", "Concert", LocalDate.parse("2023-07-08"));
        eventObject.generateSchedule();

        System.out.println("\n===========================================================");
        System.out.println("Scenario 2:' Exhibition ' Event type");
        System.out.println("===========================================================");
        eventObject = new Exhibition("Annapolis Valley Exhibition", "Exhibition",null);
        eventObject.generateSchedule();

        System.out.println("\n===========================================================");
        System.out.println("Scenario 3: ' Conference ' Event type");
        System.out.println("===========================================================");
        eventObject = new Conference("Human Resource Management Conference", "Conference", LocalDate.parse("2023-08-15"));
        eventObject.generateSchedule();
    }
}