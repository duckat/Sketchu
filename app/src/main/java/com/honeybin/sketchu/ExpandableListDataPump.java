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

        List<String> knowledge = new ArrayList<String>();
        knowledge.add("Study - Humanities");
        knowledge.add("Study - Engineering");
        knowledge.add("Study - Math & Sciences");
        knowledge.add("Read news");
        knowledge.add("Read books");

        List<String> artMusic = new ArrayList<String>();
        artMusic.add("Practice art");
        artMusic.add("Practice music");
        artMusic.add("Go to exhibition");
        artMusic.add("Go to concert");
        artMusic.add("Hold exhibition");
        artMusic.add("Hold concert");

        List<String> exercise = new ArrayList<String>();
        exercise.add("Sports");
        exercise.add("Workout");
        exercise.add("Jogging");

        List<String> hobbyCulture = new ArrayList<String>();
        hobbyCulture.add("Gaming");
        hobbyCulture.add("House Party");
        hobbyCulture.add("Movie");
        hobbyCulture.add("Drama");
        hobbyCulture.add("Music");

        List<String> activity = new ArrayList<String>();
        activity.add("Travel");
        activity.add("Shopping");
        activity.add("Meet friends");
        activity.add("Eat good food");
        activity.add("Drink");

        List<String> life = new ArrayList<String>();
        life.add("Work");
        life.add("Raise Kids");

        expandableListDetail.put("KNOWLEDGE", knowledge);
        expandableListDetail.put("ART & MUSIC", artMusic);
        expandableListDetail.put("EXERCISE", exercise);
        expandableListDetail.put("HOBBY & CULTURE", hobbyCulture);
        expandableListDetail.put("ACTIVITIES", activity);
        expandableListDetail.put("LIFE", life);
        return expandableListDetail;
    }
}