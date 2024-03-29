package com.company.model.obligation;

import com.company.model.Probabilities;

public class Obligation implements Probabilities {
    private String description;
    private int probability; // 0-4: 0 - rare, ... , 4 - frequent
    private long approxImpact; // dollars
    private long cost; // dollars

    Obligation(String description, int probability, long impact){
        this.description = description;
        this.probability = probability;
        this.approxImpact = impact;
        this.cost = this.calculateCost();
    }

    public String getDescription() {
        return description;
    }

    public int getProbability() {
        return probability;
    }

    public long getApproxImpact() {
        return approxImpact;
    }

    public long getCost() {
        return cost;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setProbability(int probability) {
        this.probability = probability;
    }

    public void setApproxImpact(long approxImpact) {
        this.approxImpact = approxImpact;
    }

    public void setCost(long cost) {
        this.cost = cost;
    }

    public long calculateCost(){
        return (long) (PROBABILITY_COST_MULTIPLIERS[getProbability()] * getApproxImpact());
    };

    @Override
    public String toString() {
        return  "Description: '" + description + '\'' +
                ",\nProbability: " + PROBABILITIES[probability] +
                ",\nApproximate impact: " + approxImpact +
                "$,\nCost: " + cost + "$";
    }
}
