package com.slack.weeklychallengeone.data;

import android.provider.BaseColumns;

/**
 * Created by Administrator on 4/8/2018.
 */

public class LayoutContract {

    public static final class LayoutEntry implements BaseColumns {
        public static final String TABLE_NAME = "layout_table";
        public static final String COLUMN_NAME = "layout_name";
        public static final String COLUMN_LINK = "layout_link";
        public static final String COLUMN_POSITION = "layout_pos";
   }
}
