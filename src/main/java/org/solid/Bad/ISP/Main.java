package org.solid.Bad.ISP;

public class Main {
    public static void main(String[] args) {

        System.out.println("\n===========================================================================================");
        System.out.println("ISP : SpaceX spacecraft resource exploration scenario");
        System.out.println("===========================================================================================");
        System.out.println("*** Failing Interface Segregation Principle");

        System.out.println("\n===========================================================================================");
        System.out.println("SpaceX : Rover - Responsible for ONLY locating resource and NOT analysing resource");
        System.out.println("===========================================================================================");

        SpaceXRover spaceXRover = new SpaceXRover();

        spaceXRover.fly();
        spaceXRover.locateSampleSource();
        spaceXRover.launch("Destination A312");
        spaceXRover.fly();
        spaceXRover.locateSampleSource();
        // INVALID METHOD for Rover
        spaceXRover.collectSamples(15);
        // INVALID METHOD for Rover
        spaceXRover.analyzeSamples();
        spaceXRover.land("Charging docking station-X22");
        spaceXRover.fly();
        spaceXRover.communicate();
        spaceXRover.locateSampleSource();

        System.out.println("\n===========================================================================================");
        System.out.println("SpaceX : Starship - Responsible for ONLY analysing resource and NOT locating resource");
        System.out.println("===========================================================================================");

        SpaceXStarship spaceXStarship = new SpaceXStarship();

        spaceXStarship.fly();
        // INVALID METHOD for Starship
        spaceXStarship.locateSampleSource();
        spaceXStarship.launch("Destination R998");
        spaceXStarship.fly();
        // INVALID METHOD for Starship
        spaceXStarship.locateSampleSource();
        spaceXStarship.collectSamples(15);
        spaceXStarship.analyzeSamples();
        spaceXStarship.land("Charging docking station-X1A");
        spaceXStarship.fly();
        spaceXStarship.communicate();
        spaceXStarship.collectSamples(20);
        spaceXStarship.analyzeSamples();

        // increasing num of Flights by launch and landing of Starship spacecraft
        spaceXStarship.launch("Destination R035");
        spaceXStarship.fly();
        spaceXStarship.land("Charging docking station-X9C");

        spaceXStarship.launch("Destination R478");
        spaceXStarship.fly();
        spaceXStarship.land("Charging docking station-X32");

        spaceXStarship.launch("Destination R111");
        spaceXStarship.fly();
        spaceXStarship.land("Charging docking station-X22");

        System.out.println("Number of Flights done by Starship = "+spaceXStarship.getNumFlights());
    }
}