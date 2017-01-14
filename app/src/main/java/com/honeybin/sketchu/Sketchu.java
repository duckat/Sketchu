package com.honeybin.sketchu;

/**
 * Sketchu class.
 */

public class Sketchu {
    private String form = "";

    private int hunger = 0;
    private int cleanliness = 0;
    private int love = 0;
    private int drowsiness = 0;

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

    }
    private double timeConversion(double minutes) {
        double timeScore = minutes / 60.0;
        return timeScore;
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
        this.knowledge = this.knowledge + this.timeConversion(time);
    }

    public void incCreativity(double time) {
        this.creativity = this.creativity + this.timeConversion(time);
    }

    public void incComprehensibility(double time) {
        this.comprehensibility = this.comprehensibility + this.timeConversion(time);
    }

    public void incMusicalAbility(double time) {
        this.musicalAbility = this.musicalAbility + this.timeConversion(time);

    }

    public void incAppearance(double time) {
        this.appearance = this.appearance + this.timeConversion(time);
    }

    public void incPhysicality(double time) {
        this.physicality = this.physicality + this.timeConversion(time);
    }
    public void incFitness(double time) {
        this.fitness = this.fitness + this.timeConversion(time);
    }

    public void incSociability(double time) {
        this.sociability = this.sociability + this.timeConversion(time);
    }

    public void incFriendliness(double time) {
        this.friendliness = this.friendliness + this.timeConversion(time);
    }

    public void incExpressiveness(double time) {
        this.expressiveness = this.expressiveness + this.timeConversion(time);
    }

    public void incConfidence(double time) {
        this.confidence = this.confidence + this.timeConversion(time);
    }

    public void incConcentration(double time) {
        this.concentration = this.concentration + this.timeConversion(time);
    }

    public void incSentimentality(double time) {
        this.sentimentality = this.sentimentality + this.timeConversion(time);
    }

    public void incShoppingImpulsiveness(double time) {
        this.shoppingImpulsiveness = this.shoppingImpulsiveness + this.timeConversion(time);
    }

    public void incOtakuness(double time) {
        this.otakuness = this.otakuness + this.timeConversion(time);
    }
}
