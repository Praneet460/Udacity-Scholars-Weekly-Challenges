package com.slack.weeklychallengeone.Utils;

public class Model {
    private String name;
    private int number;

    public Model(String name, int number) {
        this.name = name;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }
}
