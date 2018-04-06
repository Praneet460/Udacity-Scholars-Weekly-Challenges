package com.slack.weeklychallengeone.Utils;

public class Model {
    private String name;
    private String desc;
    private String longDesc;

    public Model(String name, String desc) {
        this.name = name;
        this.desc = desc;
        this.longDesc = longDesc;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setLongDesc(String longDesc) {
        this.longDesc = longDesc;
    }

    public String getName() {

        return name;
    }

    public String getDesc() {
        return desc;
    }

    public String getLongDesc() {
        return longDesc;
    }
}
