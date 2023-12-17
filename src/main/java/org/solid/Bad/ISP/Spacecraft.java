package org.solid.Bad.ISP;

public interface Spacecraft {
    public void launch(String destination);
    public void land(String base);
    public void fly();
    public void collectSamples(int numSamples);
    public void analyzeSamples();
    public String communicate();
    public void locateSampleSource();
}
