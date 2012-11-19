package com.example.AlphaScram;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Abbey
 * Date: 11/10/12
 * Time: 12:33 PM
 * To change this template use File | Settings | File Templates.
 */
public class DictionaryDataSource {
    // Database fields
    private SQLiteDatabase database;
    private DictionarySQLHelper helper;
    private String[] allColumns = { DictionarySQLHelper.COLUMN_WORD};

    public DictionaryDataSource(Context context) {
        helper = new DictionarySQLHelper(context);
    }

    public void open() throws SQLException {
        database = helper.getWritableDatabase();
    }

    public void close() {
        helper.close();
    }

    public boolean inDictionary(String word){
       /*
        open();
        String whereClause = "word = LOWER('";
        whereClause += word;
        whereClause += "')";
        Cursor cursor = database.query(DictionarySQLHelper.TABLE_WORDS,
                allColumns, whereClause, null, null, null,null);

        if(cursor.getCount() > 0)
            return true;
        else
            return false;
            */
        return true;
    }

//    public Stat createStat(String code, Integer score) {
//        ContentValues values = new ContentValues();
//        values.put(ScoreSQLHelper.COLUMN_CODE, code);
//        long insertId = database.insert(ScoreSQLHelper.TABLE_STAT, null,
//                values);
//        Cursor cursor = database.query(ScoreSQLHelper.TABLE_STAT,
//                allColumns, ScoreSQLHelper.COLUMN_ID + " = " + insertId, null,
//                null, null, null);
//        cursor.moveToFirst();
//        Stat newStat = cursorToStat(cursor);
//        cursor.close();
//        return newStat;
//    }
//
//    public void deleteStat(Stat stat) {
//        int id = stat.getId();
//        System.out.println("Stat deleted with id: " + id);
//        database.delete(ScoreSQLHelper.TABLE_STAT, ScoreSQLHelper.COLUMN_ID
//                + " = " + id, null);
//    }
//
//    public List<Stat> getAllStats() {
//        List<Stat> stats = new ArrayList<Stat>();
//
//        Cursor cursor = database.query(ScoreSQLHelper.TABLE_STAT,
//                allColumns, null, null, null, null, null);
//
//        cursor.moveToFirst();
//        while (!cursor.isAfterLast()) {
//            Stat stat = cursorToStat(cursor);
//            stats.add(stat);
//            cursor.moveToNext();
//        }
//        // Make sure to close the cursor
//        cursor.close();
//        return stats;
//    }
//
//    private Stat cursorToStat(Cursor cursor) {
//        Stat stat = new Stat();
//        stat.setId(cursor.getInt(0));
//        stat.setCode(cursor.getString(1));
//        return stat;
//    }
}
