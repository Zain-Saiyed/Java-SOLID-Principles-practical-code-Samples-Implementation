package org.solid.Bad.ISP;

import java.util.ArrayList;
import java.util.Random;

public class SpaceXStarship implements Spacecraft{
    private boolean hasLanded;
    private boolean reachDestination;
    private String landedBase;
    private String destination;
    private int numFlights;
    private int samplesCollected;
    ArrayList<String> analysisResult ;

    public SpaceXStarship() {
        this.hasLanded = true;
        this.landedBase = "Home Base";
        this.destination = null;
        this.reachDestination = false;
        this.numFlights = 0;
        this.samplesCollected = 0;
        this.analysisResult = new ArrayList<String>();
    }

    @Override
    public void launch(String destination) {
        this.destination = destination;
        System.out.println("\n--- LAUNCH ---");
        System.out.println("Initiating launch towards destination: "+destination);
        for (int i = 10; i < 0; i--) {
            System.out.println("T-"+i);
        }
        System.out.println("Launching Starship towards destination: "+destination);
        this.hasLanded = false;
        System.out.println("--- LAUNCH ---\n");
    }

    @Override
    public void land(String base) {
        System.out.println("\n--- LAND ---");
        this.landedBase = base;
        this.numFlights += 1;
        this.reachDestination = true;
        System.out.println("Initiating Starship landing at Base: "+base);
        System.out.println("--- LAND ---\n");
    }

    @Override
    public void fly() {
        System.out.println("\n--- FLY ---");
        if (hasLanded) {
            if (landedBase!=null)
                System.out.println("Starship has already landed at base: "+this.landedBase);
            else
                System.out.println("Starship has not begun its journey. It is ready to launch!");
            System.out.println("Possible options: Check, Finalize operations, and initiate launch to another base destination.");
        }
        else {
            System.out.println("Starship in flight towards base destination: "+this.destination);
        }
        System.out.println("--- FLY ---\n");
    }

    @Override
    public void collectSamples(int numSamples) {
        System.out.println("\n--- SAMPLE COLLECTION ---");
        System.out.println(numSamples);
        if (hasLanded) {
            System.out.println("Starship has already landed at base: "+this.landedBase+" . Samples can be collected only when in flight.");
            System.out.println("Number of samples already collected: "+this.samplesCollected);
        } else {
            System.out.println("Starship in flight. Initiating sample collection...");
            for (int i = 0; i < numSamples; i++) {
                System.out.println("...Collected sample ["+(i+1)+"]");
                this.samplesCollected += 1;
            }
            System.out.println("Total samples collected: "+this.samplesCollected);
        }
        System.out.println("--- SAMPLE COLLECTION ---\n");
    }

    @Override
    public void analyzeSamples() {
        System.out.println("\n--- SAMPLE ANALYSIS ---");
        if (hasLanded) {
            System.out.println("Starship in flight. Initiating sample analysis...");
            Random chooseRandomStatus = new Random();
            String[] analysisStatus = {"defective sample","C Grade", "B Grade", "A Grade", "S Grade", "SSS Grade"};
            for (int i = 0; i < this.samplesCollected; i++) {
                System.out.println("...Analysing Collected sample num-["+(i+1)+"]");
                String analysisReport = analysisStatus[chooseRandomStatus.nextInt(analysisStatus.length)];
                System.out.println("Analysis Result: "+analysisReport);
                this.analysisResult.add(analysisReport);
            }
            System.out.println("Total samples analysed: "+this.samplesCollected);
            System.out.println("To analyse more sample consider: flying to a resource rich destination for better quality samples.");
        } else {
            System.out.println("Starship has already landed at base: "+this.landedBase+" . Samples can be analysed while in flight for better analysis profitability.");
        }
        System.out.println("--- SAMPLE ANALYSIS ---\n");
    }

    @Override
    public String communicate() {
        System.out.println("\n--- COMMUNICATION ---");
        System.out.println("...Establishing connection with Earth...");
        System.out.println("...Sending sample's analysis result report to Earth...");
        String messageResponse = "";
        int sampleNum = 1;
        for (String report:analysisResult) {
            messageResponse += "Sample-ID: "+sampleNum+" Report: "+report+"|#|";
        }
        return messageResponse;
    }
    @Override
    public void locateSampleSource() {
        System.out.println("INVALID OPERATION! Do you mean to analyze resource location? Consider: collectSamples() OR analyzeSamples()");
    }

    public int getNumFlights() {
        return numFlights;
    }
}