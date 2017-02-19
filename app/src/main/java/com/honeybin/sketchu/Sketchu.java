package com.honeybin.sketchu;

import android.util.Log;

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
    private int hunger = 50;
    private int love = 50;

    // intelligent
    private double knowledge = 0.0;
    private double creativity = 0.0;
    private double comprehensibility = 0.0;
    private double precision = 0.0;

    // skillful
    private double musicalAbility = 0.0;
    private double artAbility = 0.0;
    private double mastery = 0.0;
    private double dexterity = 0.0;
    private double fitness = 0.0;

    // social category
    private double appearance = 0.0;
    private double reputation = 0.0;
    private double friendliness = 0.0;
    private double expressiveness = 0.0;

    // Inner peace
    private double confidence = 0.0;
    private double concentration = 0.0;
    private double happiness = 0.0;
    private double sentimentality = 0.0;

    // etc
    private double shopping = 0.0;
    private double luck = 0.0;
    private  double fat = 0.0;
    private double otakuness = 0.0;
    private double alcoholic = 0.0;

    public Sketchu(String name) {
        this.name = name;
        createDate = TimeHelper.getCurrentTimeString();
        lastUpdate = createDate;
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

    public void incDexterity(double time) {
        this.dexterity = this.dexterity + this.minToHour(time);
    }
    public void incFitness(double time) {
        this.fitness = this.fitness + this.minToHour(time);
    }

    public void incSociability(double time) {
        this.reputation = this.reputation + this.minToHour(time);
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
        this.shopping = this.shopping + this.minToHour(time);
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

    public double getDexterity() {
        return dexterity;
    }

    public void setDexterity(double dexterity) {
        this.dexterity = dexterity;
    }

    public double getFitness() {
        return fitness;
    }

    public void setFitness(double fitness) {
        this.fitness = fitness;
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
        return shopping;
    }

    public void setShoppingImpulsiveness(double shoppingImpulsiveness) {
        this.shopping = shoppingImpulsiveness;
    }

    public double getOtakuness() {
        return otakuness;
    }

    public void setOtakuness(double otakuness) {
        this.otakuness = otakuness;
    }

    public void raiseStats(String tag, long durationInMin){
        double duration = TimeHelper.minToHour(durationInMin);
        hunger += duration * 10;
        switch(tag){
            //Intelligent
            case "Study - Humanities": this.knowledge += (30 * duration);
                this.creativity += (20 * duration);
                this.comprehensibility += (40 * duration);
                this.concentration += (10 * duration);
                break;
            case "Study - Engineering": this.knowledge += (30 * duration);
                this.creativity += (30 * duration);
                this.mastery += (30 * duration);
                this.concentration += (10 * duration);
                break;
            case "Study - Math & Sciences": this.knowledge += (30 * duration);
                this.precision += (50 * duration);
                this.comprehensibility += (10 * duration);
                this.concentration += (10 * duration);
                break;
            case "Read news": this.knowledge += (30 * duration);
                this.comprehensibility += (20 * duration);
                this.friendliness += (15 * duration);
                this.expressiveness += (15 * duration);
                this.concentration += (20 * duration);
                break;
            case "Read books": this.knowledge += (40 * duration);
                this.creativity += (10 * duration);
                this.comprehensibility += (20 * duration);
                this.sentimentality += (30 * duration);
                break;
            case "Write": this.knowledge += (20 * duration);
                this.creativity += (50 * duration);
                this.expressiveness += (30 * duration);
                break;
            //Art & Music
            case "Sing": this.creativity += (20 * duration);
                this.comprehensibility += (10 * duration);
                this.musicalAbility += (30 * duration);
                this.reputation += (10 * duration);
                this.expressiveness += (10 * duration);
                this.sentimentality += (20 * duration);
                break;
            case "Dance": this.creativity += (20 * duration);
                this.musicalAbility += (15 * duration);
                this.artAbility += (10 * duration);
                this.dexterity += (20 * duration);
                this.fitness += (25 * duration);
                this.reputation += (10 * duration);
                break;
            case "Play instrument": this.creativity += (20 * duration);
                this.precision += (30 * duration);
                this.musicalAbility += (30 * duration);
                this.reputation += (10 * duration);
                this.expressiveness += (10 * duration);
                break;
            case "Exhibit art": this.creativity += (25 * duration);
                this.artAbility += (30 * duration);
                this.mastery += (25 * duration);
                this.reputation += (10 * duration);
                this.sentimentality += (10 * duration);
                break;
            // Exercise
            case "Sports": this.dexterity += (30 * duration);
                this.fitness += (30 * duration);
                this.friendliness += (10 * duration);
                this.confidence += (10 * duration);
                this.concentration += (10 * duration);
                this.happiness += (10 * duration);
                break;
            case "Workout": this.fitness += (70 * duration);
                this.confidence += (20 * duration);
                this.concentration += (10 * duration);
                break;
            case "Jogging": this.fitness += (70 * duration);
                this.confidence += (10 * duration);
                this.concentration += (10 * duration);
                this.happiness += (10 * duration);
                break;
            case "Yoga & Stretching": this.fitness += (70 * duration);
                this.confidence += (20 * duration);
                this.concentration += (10 * duration);
                break;
            //Hobby & Culture
            case "Gaming": this.otakuness += (20 * duration);
                this.precision += (20 * duration);
                this.dexterity += (40 * duration);
                this.expressiveness += (10 * duration);
                this.concentration += (10 * duration);
                break;
            case "Watch TV": this.otakuness += (30 * duration);
                this.comprehensibility += (20 * duration);
                this.happiness += (10 * duration);
                this.sentimentality += (40 * duration);
                break;
            case "Watch Movie": this.otakuness += (20 * duration);
                this.comprehensibility += (30 * duration);
                this.sentimentality += (50 * duration);
                break;
            case "Comics & Anime": this.otakuness += (50 * duration);
                this.comprehensibility += (20 * duration);
                this.creativity += (10 * duration);
                this.sentimentality += (20 * duration);
                break;
            //work
            case "Career work": this.reputation += (60 * duration);
                this.precision += (20 * duration);
                this.dexterity += (10 * duration);
                this.concentration += (10 * duration);
                break;
            case "Raise kids": this.reputation += (20 * duration);
                this.expressiveness += (10 * duration);
                this.mastery += (20 * duration);
                this.dexterity += (10 * duration);
                this.friendliness += (20 * duration);
                this.concentration += (10 * duration);
                this.happiness += (10 * duration);
                break;
            case "Hold a meeting": this.reputation += (20 * duration);
                this.knowledge += (10 * duration);
                this.creativity += (10 * duration);
                this.comprehensibility += (10 * duration);
                this.expressiveness += (40 * duration);
                this.concentration += (10 * duration);
                break;
            case "Presentation": this.reputation += (20 * duration);
                this.creativity += (10 * duration);
                this.dexterity += (10 * duration);
                this.appearance += (10 * duration);
                this.expressiveness += (50 * duration);
                break;
            case "Tutoring / Teaching": this.reputation += (20 * duration);
                this.expressiveness += (20 * duration);
                this.knowledge += (20 * duration);
                this.comprehensibility += (20 * duration);
                this.friendliness += (20 * duration);
                break;
            case "Work on project":
                this.expressiveness += (10 * duration);
                this.knowledge += (10 * duration);
                this.creativity += (30 * duration);
                this.mastery += (30 * duration);
                this.confidence += (10 * duration);
                this.concentration += (10 * duration);
                break;
            default: break;
        }
    }
}
