package org.solid.Bad.ISP;

import java.util.ArrayList;
import java.util.Random;

public class SpaceXRover implements Spacecraft {

    private boolean hasLanded;
    private String landedBase;
    private boolean foundResourceLocation;
    private String destination;
    private ArrayList<String> locationReport;

    public SpaceXRover() {
        this.hasLanded = true;
        this.landedBase = "Home Base";
        this.destination = null;
        this.locationReport = new ArrayList<String>();
    }
    @Override
    public void launch(String destination) {
        System.out.println("\n--- LAUNCH ---");
        this.destination = destination;
        System.out.println("Initiating launch, to search samples in area: "+destination);
        for (int i = 10; i < 0; i--) {
            System.out.println("T-"+i);
        }
        System.out.println("Launching Rover towards area: "+destination);
        this.hasLanded=false;
        System.out.println("--- LAUNCH ---\n");
    }

    @Override
    public void land(String base) {
        System.out.println("\n--- LAND ---");
        this.landedBase = base;
        this.foundResourceLocation = true;
        System.out.println("Rover docked at Base: "+base+". Initiating charging.");
        System.out.println("--- LAND ---\n");
    }

    @Override
    public String communicate() {
        System.out.println("\n--- COMMUNICATION ---");
        System.out.println("...Establishing connection with Earth...");
        System.out.println("...Sending sample's analysis result report to Earth...");
        String messageResponse = "";
        int mineralNum = 1;
        for (String mineralReport : this.locationReport) {
            messageResponse += "Mineral-ID: "+mineralNum+" Resource density: "+mineralReport+"|#|";
        }
        return messageResponse;
    }
    @Override
    public void fly() {
        System.out.println("\n--- FLY ---");
        if (hasLanded) {
            if (landedBase!=null)
                System.out.println("Rover has already landed at base: "+this.landedBase+" and is Charging.");
            else
                System.out.println("Rover has not begun its journey. It is ready for launch!");
            System.out.println("Possible options: Finalize the new location to search for possible resources, and launch Rover.");
        }
        else {
            System.out.println("Rover is finding possible resource minerals at location: "+this.destination);
        }
        System.out.println("--- FLY ---\n");
    }

    public void locateSampleSource() {
        System.out.println("\n--- FINDING SAMPLE SOURCE ---");
        if (hasLanded) {
            System.out.println("Rover is at base: "+this.landedBase+" and is Charging.");
            if (this.foundResourceLocation) {
                System.out.println("Rover has found minerals and resources at destination: "+this.destination+". Please send a SpaceX-Starship to analyse mineral resource samples at the destination.");
            }
            else
                System.out.println("Rover Ready for launch at a new destination!");
        } else {
            System.out.println("Rover is in flight, locating resource minerals...");
            Random chooseRandomStatus = new Random();
            String[] mineralType = {"sparse","median", "rich", "unexplored"};
            for (int i = 0; i < (chooseRandomStatus.nextInt(15)+1); i++) {
                System.out.println("...Found Collected sample num-["+(i+1)+"]");
                String analysisReport = mineralType[chooseRandomStatus.nextInt(mineralType.length)];
                System.out.println("Analysis Result: "+analysisReport);
                this.locationReport.add(analysisReport);
            }
            System.out.println("Total Mineral Resources found: "+this.locationReport.size());
        }
        System.out.println("--- FINDING SAMPLE SOURCE ---\n");
    }

    @Override
    public void collectSamples(int numSamples) {
        System.out.println("INVALID OPERATION! Do you mean to explore and find sample resource location? Consider: locateSampleSource()");
    }

    @Override
    public void analyzeSamples() {
        System.out.println("INVALID OPERATION! Do you mean to explore and find sample resource location? Consider: locateSampleSource()");
    }
}