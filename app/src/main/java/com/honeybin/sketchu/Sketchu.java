package com.honeybin.sketchu;

import android.util.Log;

import org.joda.time.DateTime;
import org.joda.time.Duration;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Sketchu class.
 */

public class Sketchu {
    private String form = "";
    private String createDate = "";
    private String lastUpdate = "";
    private int age = 0;
    private String name = "Babichu";

    ///essential stats
    private int hunger = 100;
    private int love = 50;

    // intelligence category
    private double knowledge = 0.0;
    private double creativity = 0.0;
    private double comprehensibility = 0.0;
    private double musicalAbility = 0.0;

    // outer appearance
    private double appearance = 0.0;
    private double physicality = 0.0;
    private double fitness = 0.0;

    // social category
    private double sociability = 0.0;
    private double friendliness = 0.0;
    private double expressiveness = 0.0;

    // mind control
    private double confidence = 0.0;
    private double concentration = 0.0;
    private double sentimentality = 0.0;

    // personality
    private double shoppingImpulsiveness = 0.0;
    private double otakuness = 0.0;

    public Sketchu() {
        createDate = TimeHelper.getCurrentTimeString();
        lastUpdate = createDate;
    }

    public Sketchu(String customName){
        this.name = customName;
    }

    private double minToHour(double minutes) {
        double timeScore = minutes / 60.0;
        return timeScore;
    }

    public void update(){
//        cal = Calendar.getInstance();
        String now = TimeHelper.getCurrentTimeString();
        long interval = TimeHelper.findTimeDiff(lastUpdate, now);
        naturalDecay(interval);
        Log.d("updating", TimeHelper.findTimeDiff(lastUpdate, now) + "");
        lastUpdate = now;
    }
//
//    private long findTimeDiff(String original, String current){
//        DateTime orig = DateTime.parse(original);
//        DateTime now = DateTime.parse(current);
//        Duration duration = new Duration(orig, now);
//        //this part should be getStandardMinutes() for actual production
//        return duration.getStandardSeconds();
//    }

    private void naturalDecay(long timePassed){
        hunger -= timePassed;
        love -= timePassed;
        if(hunger < 0){ hunger = 0;}
        if(love < 0){ love = 0;}
    }

    public void incHunger(double time) {
    }

    public void incCleanliness() {
    }

    public void incLove() {
    }

    public void incDrowsiness() {
    }

    public void incKnowledge(double time) {
        this.knowledge = this.knowledge + this.minToHour(time);
    }

    public void incCreativity(double time) {
        this.creativity = this.creativity + this.minToHour(time);
    }

    public void incComprehensibility(double time) {
        this.comprehensibility = this.comprehensibility + this.minToHour(time);
    }

    public void incMusicalAbility(double time) {
        this.musicalAbility = this.musicalAbility + this.minToHour(time);

    }

    public void incAppearance(double time) {
        this.appearance = this.appearance + this.minToHour(time);
    }

    public void incPhysicality(double time) {
        this.physicality = this.physicality + this.minToHour(time);
    }
    public void incFitness(double time) {
        this.fitness = this.fitness + this.minToHour(time);
    }

    public void incSociability(double time) {
        this.sociability = this.sociability + this.minToHour(time);
    }

    public void incFriendliness(double time) {
        this.friendliness = this.friendliness + this.minToHour(time);
    }

    public void incExpressiveness(double time) {
        this.expressiveness = this.expressiveness + this.minToHour(time);
    }

    public void incConfidence(double time) {
        this.confidence = this.confidence + this.minToHour(time);
    }

    public void incConcentration(double time) {
        this.concentration = this.concentration + this.minToHour(time);
    }

    public void incSentimentality(double time) {
        this.sentimentality = this.sentimentality + this.minToHour(time);
    }

    public void incShoppingImpulsiveness(double time) {
        this.shoppingImpulsiveness = this.shoppingImpulsiveness + this.minToHour(time);
    }

    public void incOtakuness(double time) {
        this.otakuness = this.otakuness + this.minToHour(time);
    }

    public String getForm() {
        return form;
    }

    public void setForm(String form) {
        this.form = form;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(String lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHunger() {
        return hunger;
    }

    public void setHunger(int hunger) {
        this.hunger = hunger;
    }

    public int getLove() {
        return love;
    }

    public void setLove(int love) {
        this.love = love;
    }

    public double getKnowledge() {
        return knowledge;
    }

    public void setKnowledge(double knowledge) {
        this.knowledge = knowledge;
    }

    public double getCreativity() {
        return creativity;
    }

    public void setCreativity(double creativity) {
        this.creativity = creativity;
    }

    public double getComprehensibility() {
        return comprehensibility;
    }

    public void setComprehensibility(double comprehensibility) {
        this.comprehensibility = comprehensibility;
    }

    public double getMusicalAbility() {
        return musicalAbility;
    }

    public void setMusicalAbility(double musicalAbility) {
        this.musicalAbility = musicalAbility;
    }

    public double getAppearance() {
        return appearance;
    }

    public void setAppearance(double appearance) {
        this.appearance = appearance;
    }

    public double getPhysicality() {
        return physicality;
    }

    public void setPhysicality(double physicality) {
        this.physicality = physicality;
    }

    public double getFitness() {
        return fitness;
    }

    public void setFitness(double fitness) {
        this.fitness = fitness;
    }

    public double getSociability() {
        return sociability;
    }

    public void setSociability(double sociability) {
        this.sociability = sociability;
    }

    public double getFriendliness() {
        return friendliness;
    }

    public void setFriendliness(double friendliness) {
        this.friendliness = friendliness;
    }

    public double getExpressiveness() {
        return expressiveness;
    }

    public void setExpressiveness(double expressiveness) {
        this.expressiveness = expressiveness;
    }

    public double getConfidence() {
        return confidence;
    }

    public void setConfidence(double confidence) {
        this.confidence = confidence;
    }

    public double getConcentration() {
        return concentration;
    }

    public void setConcentration(double concentration) {
        this.concentration = concentration;
    }

    public double getSentimentality() {
        return sentimentality;
    }

    public void setSentimentality(double sentimentality) {
        this.sentimentality = sentimentality;
    }

    public double getShoppingImpulsiveness() {
        return shoppingImpulsiveness;
    }

    public void setShoppingImpulsiveness(double shoppingImpulsiveness) {
        this.shoppingImpulsiveness = shoppingImpulsiveness;
    }

    public double getOtakuness() {
        return otakuness;
    }

    public void setOtakuness(double otakuness) {
        this.otakuness = otakuness;
    }
}
