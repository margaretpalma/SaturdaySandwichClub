package com.saturdaysandwichshop.models;

//info about bread type

public class Bread {

//white, wheat, rye, wrap

    private String breadType;

//constructor - super
    public Bread(String breadType) {
        this.breadType = breadType;
    }
//getters and setters
    public String getBreadType() {
        return breadType;
    }
    public void setBreadType(String breadType) {
        this.breadType = breadType;
    }

    @Override
    public String toString(){
    return breadType + " Bread";
    }
}

