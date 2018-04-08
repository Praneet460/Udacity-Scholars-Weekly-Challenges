package com.slack.weeklychallengeone.Utils;

public class Model {
    private String name;
    private String description;

    public Model(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
