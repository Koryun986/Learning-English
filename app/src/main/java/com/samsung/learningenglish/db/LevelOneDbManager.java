package com.samsung.learningenglish.db;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOneDbManager {
    private Context context;
    private LevelOneDbHelper dbHelper;
    private SQLiteDatabase db;

    public LevelOneDbManager(Context context) {
        this.context = context;
        dbHelper = new LevelOneDbHelper(context);
    }

    public void openDb(){
        db = dbHelper.getWritableDatabase();
    }

    public void insertToDb(String word, String missChar){
        ContentValues cv = new ContentValues();
        cv.put(Constants.WORD, word);
        cv.put(Constants.MISSING_LETTER, missChar);
        db.insert(Constants.LEVEL_ONE_TABLE_NAME, null, cv);
    }

    public Queue<String> readWordsFromDb(){
        Queue<String> wordsList = new LinkedList<>();
        Cursor cursor = db.query(Constants.LEVEL_ONE_TABLE_NAME, null, null,null,null,null,null);
        while (cursor.moveToNext()){
            @SuppressLint("Range") String word = cursor.getString(cursor.getColumnIndex(Constants.WORD));
            wordsList.add(word);
        }
        cursor.close();
        return wordsList;
    }

    public Queue<String> readMissLettersFromDb(){
        Queue<String> charList = new LinkedList<>();
        Cursor cursor = db.query(Constants.LEVEL_ONE_TABLE_NAME, null, null,null,null,null,null);
        while (cursor.moveToNext()){
            @SuppressLint("Range") String word = cursor.getString(cursor.getColumnIndex(Constants.MISSING_LETTER));
            charList.add(word);
        }
        cursor.close();
        return charList;
    }

    public void closeDb() {
        dbHelper.close();
    }
}
