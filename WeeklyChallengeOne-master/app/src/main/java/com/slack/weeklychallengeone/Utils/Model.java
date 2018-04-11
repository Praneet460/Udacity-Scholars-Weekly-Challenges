package com.slack.weeklychallengeone.Utils;

public class Model {
    private String name;
    private String description;
    private String links;

    public Model(String name, String description, String links) {
        this.name = name;
        this.description = description;
        this.links=links;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }
    public  String getDescription(){
        return  description;
    }

    public String getLinks() {
        return links;
    }

    public void setLinks(String links) {
        this.links = links;
    }

}
