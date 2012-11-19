package com.example.AlphaScram;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created with IntelliJ IDEA.
 * User: Abbey
 * Date: 11/10/12
 * Time: 12:09 PM
 * To change this template use File | Settings | File Templates.
 */
public class ScoreSQLHelper extends SQLiteOpenHelper {

    public static final String TABLE_STAT = "stat";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_CODE = "code";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_SCORE = "score";

    private static final String DATABASE_NAME = "stat.db";
    private static final int DATABASE_VERSION = 1;

    // Database creation sql statement
    private static final String DATABASE_CREATE = "create table "
            + TABLE_STAT + "(" + COLUMN_ID
            + " integer primary key autoincrement, " + COLUMN_CODE
            + " text not null, " + COLUMN_NAME + " text not null, "
            + COLUMN_SCORE + " integer not null "
            + ");";


    public ScoreSQLHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(DATABASE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i2) {
        Log.w(ScoreSQLHelper.class.getName(),
                "Upgrading database from version " + i + " to "
                        + i2 + ", which will destroy all old data");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_STAT);
        onCreate(sqLiteDatabase);
    }
}
