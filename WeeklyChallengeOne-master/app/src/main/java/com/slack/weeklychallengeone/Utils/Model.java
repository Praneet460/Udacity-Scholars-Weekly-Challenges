package com.slack.weeklychallengeone.Utils;

public class Model {
    private String itemName;
    private String itemExtends;
    private String itemDescription;

    public Model(String itemName, String itemExtends, String itemDescription) {
        this.itemName = itemName;
        this.itemExtends = itemExtends;
        this.itemDescription = itemDescription;
    }

    String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemExtends() {
        return itemExtends;
    }

    public void setItemExtends(String itemExtends) {
        this.itemExtends = itemExtends;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }
}
