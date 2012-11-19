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
public class StatsDataSource {
    // Database fields
    private SQLiteDatabase database;
    private ScoreSQLHelper scoreHelper;
    private String[] allColumns = { ScoreSQLHelper.COLUMN_ID,
            ScoreSQLHelper.COLUMN_NAME,
            ScoreSQLHelper.COLUMN_CODE,
            ScoreSQLHelper.COLUMN_SCORE};

    public StatsDataSource(Context context) {
        scoreHelper = new ScoreSQLHelper(context);
    }

    public void open() throws SQLException {
        database = scoreHelper.getWritableDatabase();
    }

    public void close() {
        scoreHelper.close();
    }

    public Stat createStat(String code, Integer score) {
        ContentValues values = new ContentValues();
        values.put(ScoreSQLHelper.COLUMN_CODE, code);
        long insertId = database.insert(ScoreSQLHelper.TABLE_STAT, null,
                values);
        Cursor cursor = database.query(ScoreSQLHelper.TABLE_STAT,
                allColumns, ScoreSQLHelper.COLUMN_ID + " = " + insertId, null,
                null, null, null);
        cursor.moveToFirst();
        Stat newStat = cursorToStat(cursor);
        cursor.close();
        return newStat;
    }

    public void deleteStat(Stat stat) {
        int id = stat.getId();
        System.out.println("Stat deleted with id: " + id);
        database.delete(ScoreSQLHelper.TABLE_STAT, ScoreSQLHelper.COLUMN_ID
                + " = " + id, null);
    }

    public List<Stat> getAllStats() {
        List<Stat> stats = new ArrayList<Stat>();

        Cursor cursor = database.query(ScoreSQLHelper.TABLE_STAT,
                allColumns, null, null, null, null, null);

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Stat stat = cursorToStat(cursor);
            stats.add(stat);
            cursor.moveToNext();
        }
        // Make sure to close the cursor
        cursor.close();
        return stats;
    }

    private Stat cursorToStat(Cursor cursor) {
        Stat stat = new Stat();
        stat.setId(cursor.getInt(0));
        stat.setCode(cursor.getString(1));
        return stat;
    }
}
