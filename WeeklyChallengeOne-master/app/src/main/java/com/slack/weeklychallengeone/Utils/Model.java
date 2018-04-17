package com.slack.weeklychallengeone.Utils;

import android.net.Uri;

public class Model {
    private String name;
    private Uri mUri;

    public Model(String name, Uri uri) {
        this.name = name;
        mUri = uri;
    }

    public String getName() {
        return name;
    }

    public Uri getUri(){return mUri;}
}
