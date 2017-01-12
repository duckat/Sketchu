package com.honeybin.sketchu;

/**
 * Created by klee166 on 1/12/2017.
 */

public class Event {
    private String name;
    private double durationMin;
    private String explanation;

    public Event(String name, double startTime, double endTime, String exp) {
        this.name = name;
        this.durationMin = measureTime(startTime, endTime);
        this.explanation = exp;
    }

    private double measureTime(double startTime, double endTime) {
        return endTime - startTime;
    }
}
