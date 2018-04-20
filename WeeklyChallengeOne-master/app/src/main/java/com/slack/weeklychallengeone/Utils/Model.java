package com.slack.weeklychallengeone.Utils;

public class Model {
    private String name,desc,firstLetter;

    public Model(String name, String desc, String firstLetter) {
        this.name = name;
        this.desc = desc;
        this.firstLetter = firstLetter;
    }

    public String getName() {
        return name;
    }
    public String getDesc() {
        return desc;
    }
    public String getFirstLetter() {
        return firstLetter;
    }

}
