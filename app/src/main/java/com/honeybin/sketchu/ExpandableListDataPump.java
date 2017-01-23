package com.honeybin.sketchu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/**
 * Created by Anthony Kim on 1/20/2017.
 */
public class ExpandableListDataPump {
    public static HashMap<String, List<String>> getData() {
        HashMap<String, List<String>> expandableListDetail = new HashMap<String, List<String>>();

        List<String> intellectual = new ArrayList<String>();
        intellectual.add("Study - Humanities");
        intellectual.add("Study - Engineering");
        intellectual.add("Study - Math & Sciences");
        intellectual.add("Read news");
        intellectual.add("Read books");
        intellectual.add("Write");

        List<String> performance = new ArrayList<String>();
        performance.add("Sing");
        performance.add("Dance");
        performance.add("Play instrument");
        performance.add("Exhibit art");

        List<String> exercise = new ArrayList<String>();
        exercise.add("Sports");
        exercise.add("Workout");
        exercise.add("Jogging");
        exercise.add("Yoga & Stretching");

        List<String> hobbyCulture = new ArrayList<String>();
        hobbyCulture.add("Gaming");
        hobbyCulture.add("Watch TV");
        hobbyCulture.add("Watch Movie");
        hobbyCulture.add("Comics & Anime");

        List<String> activity = new ArrayList<String>();
        activity.add("Travel");
        activity.add("Shopping");
        activity.add("Meet friends");
        activity.add("Eating");
        activity.add("Drinking");
        activity.add("Party");
        activity.add("Cooking");


        List<String> work = new ArrayList<String>();
        work.add("Career work");
        work.add("Raise kids");
        work.add("Hold a meeting");
        work.add("Presentation");
        work.add("Tutoring / Teaching");
        work.add("Work on project");

        expandableListDetail.put("INTELLECTUAL", intellectual);
        expandableListDetail.put("PERFORMANCE & ARTS", performance);
        expandableListDetail.put("EXERCISE", exercise);
        expandableListDetail.put("HOBBY & CULTURE", hobbyCulture);
        expandableListDetail.put("ACTIVITIES", activity);
        expandableListDetail.put("LIFE & CAREER", work);
        return expandableListDetail;
    }
}