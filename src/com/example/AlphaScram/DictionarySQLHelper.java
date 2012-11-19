package com.example.AlphaScram;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Environment;
import android.util.Log;

/**
 * Created with IntelliJ IDEA.
 * User: Abbey
 * Date: 11/10/12
 * Time: 12:09 PM
 * To change this template use File | Settings | File Templates.
 */
public class DictionarySQLHelper extends SQLiteOpenHelper {

    public static final String TABLE_WORDS = "words";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_WORD = "word";


    private static final String DATABASE_NAME = "dictionary.db";
    private static final int DATABASE_VERSION = 1;

    // Database creation sql statement
    private static final String DATABASE_CREATE = "create table "
            + TABLE_WORDS + "(" + COLUMN_ID
            + " integer primary key autoincrement, " + COLUMN_WORD
            + " text not null, " + COLUMN_WORD + " text not null"
            + ");";


    public DictionarySQLHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        // sqLiteDatabase.execSQL(DATABASE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i2) {
//        Log.w(ScoreSQLHelper.class.getName(),
//                "Upgrading database from version " + i + " to "
//                        + i2 + ", which will destroy all old data");
//        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_STAT);
//        onCreate(sqLiteDatabase);
    }
}
