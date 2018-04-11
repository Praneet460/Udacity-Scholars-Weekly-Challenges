package com.slack.weeklychallengeone.data;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.slack.weeklychallengeone.Utils.Model;

import java.util.ArrayList;

import static com.slack.weeklychallengeone.data.LayoutContract.LayoutEntry.*;
public class LayoutDbHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "layout.db";
    private static final int DATABASE_VERSION = 1;
    public LayoutDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query = "CREATE TABLE "+TABLE_NAME+"  (";
        query+= _ID+" INTEGER PRIMARY KEY AUTOINCREMENT, ";
        query+= COLUMN_NAME+" TEXT NOT NULL, ";
        query+= COLUMN_LINK+" TEXT NOT NULL, ";
        query+= COLUMN_POSITION+" INTEGER NOT NULL ); ";
        sqLiteDatabase.execSQL(query);
        StringBuilder insertQuery = new StringBuilder("INSERT INTO "+TABLE_NAME+" ("+COLUMN_NAME+","+COLUMN_LINK+","+COLUMN_POSITION+") VALUES ");
        ArrayList<Model> list = getMokeData();
        for (int i = 0; i <list.size() ; i++) {
            Model m = list.get(i);
            insertQuery.append("('")
                    .append(m.getName())
                    .append("','")
                    .append(m.getLink())
                    .append("',")
                    .append(i)
                    .append("),");
        }
        String s = insertQuery.substring(0,insertQuery.length()-1);
        sqLiteDatabase.execSQL(s);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE "+TABLE_NAME);
        onCreate(sqLiteDatabase);
    }

    public ArrayList<Model> getMokeData(){
        ArrayList<Model> list = new ArrayList<Model>();

        list.add(new Model("Constraint Layout","https://developer.android.com/training/constraint-layout/index.html"));
        list.add(new Model("Linear Layout","https://developer.android.com/reference/android/widget/LinearLayout.html"));
        list.add(new Model("Relative Layout","https://developer.android.com/guide/topics/ui/layout/relative.html"));
        list.add(new Model("Card View","https://developer.android.com/guide/topics/ui/layout/cardview.html"));
        list.add(new Model("Scroll Views","https://developer.android.com/reference/android/widget/ScrollView.html"));
        list.add(new Model("Grid View","https://developer.android.com/guide/topics/ui/layout/gridview.html"));
        return list;
    }
}
