package com.samsung.learningenglish.db;

public class Constants {
    public static final String DB_NAME = "words.db";
    public static final int DB_VERSION = 2;
    public static final String LEVEL_ONE_TABLE_NAME = "level_one";
    public static final String _ID = "_id";
    public static final String WORD = "word";
    public static final String MISSING_LETTER = "missing_letter";
    public static final String TABLE_STRUCTURE =
            "CREATE TABLE " + LEVEL_ONE_TABLE_NAME + " (" +
                    _ID + " INTEGER PRIMARY KEY," +
                    WORD + " TEXT," +
                    MISSING_LETTER + " TEXT)";
    public static final String LEVEL_ONE_DROP_TABLE =
            "DROP TABLE IF EXISTS " +  LEVEL_ONE_TABLE_NAME;
}
