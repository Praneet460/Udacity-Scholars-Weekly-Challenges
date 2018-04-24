package com.slack.weeklychallengeone.Utils;

import android.net.Uri;

public class Model {
    private String name;
    private Uri uri;
    private int backgroundCard;

    public Model(String name,Uri uri,int backgroundCard) {
        this.name = name;
        this.uri = uri;
        this.backgroundCard = backgroundCard;
    }

    public String getName() {
        return name;
    }

    public Uri getUri(){return uri;}

    public int getBackgroundCard() {
        return backgroundCard;
    }

    public void setBackgroundCard(int backgroundCard) {
        this.backgroundCard = backgroundCard;
    }
}
