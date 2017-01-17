package com.honeybin.sketchu;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 * Created by klee166 on 1/12/2017.
 */

public class Event {
    private static int num = 0;
    private int id;
    private String name;
    private int durationMin;
    private String startTime, endTime;
    private String detail;

    public Event(String name, int startHour, int startMinute, int endHour, int endMinute, String exp) {
        this.id = num;
        this.id++;
        this.name = name;
        this.durationMin = measureTime(startHour, startMinute, endHour, endMinute);
        this.detail = exp;
    }

    public Event(String name, String startTime, String endTime, String detail) {
        this.name = name;
        this.startTime = startTime;
        this.endTime = endTime;
        this.detail = detail;
    }

    public Event(String name, int durationMin, String detail) {
        this.name = name;
        this.durationMin = durationMin;
        this.detail = detail;
    }

    private int measureTime(int sh, int sm, int eh, int em) {
        int startTime = sh * 60 + sm;
        int endTime = eh * 60 + em;
        return endTime - startTime;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public int getDurationMin() {
        return this.durationMin;
    }

    public String getStartTime() {
        return this.startTime;
    }

    public String getEndTime() {
        return this.endTime;
    }
    public String getDetail() {
        return this.detail;
    }

    public String toString() {
        return this.name;
    }
}
