package com.slack.weeklychallengeone.Utils;

public class Model {
    private String name;
    private String description;
    private String url;
    private boolean isImportant = false;

    public Model(String name, String description, String url) {
        this.name = name;
        this.description = description;
        this.url = url;
    }

    public String getDescription() {
        return description;
    }

    public String getUrl() {
        return url;
    }

    public boolean isImportant() {
        return isImportant;
    }

    public void setImportant(boolean important) {
        isImportant = important;
    }

    public String getName() {
        return name;
    }

}
