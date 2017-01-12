package com.honeybin.sketchu;

/**
 * Created by klee166 on 1/12/2017.
 */

public class Event {
    private String name;
    private double durationMin;
    private String explanation;

    public Event(String name, int startHour, int startMinute, int endHour, int endMinute, String exp) {
        this.name = name;
        this.durationMin = measureTime(startHour, startMinute, endHour, endMinute);
        this.explanation = exp;
    }

    private double measureTime(int sh, int sm, int eh, int em) {
        int hour = eh - sh;
        int minute = em - sm;
        return hour + (minute / 60.0);
    }

    public String toString() {
        return this.name;
    }
}
