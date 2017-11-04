package com.dkbrothers.app.lamus.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by dilan on 13/12/16.
 */

class ManagerSqlHelper extends SQLiteOpenHelper {


    private final static int version = 1;

    private final  static String dataBaseName = "LamuDB";


    private final static String createMusicProducers = "CREATE TABLE producers" + "(" +
            "id INTEGER PRIMARY KEY AUTOINCREMENT," +
            "name VARCHAR(100)," +
            "last_name VARCHAR(200)," +
            "email VARCHAR(300), "+
            "password VARCHAR(800) )";

    private final static String createEmployees = "CREATE TABLE employees" + "(" +
            "id INTEGER PRIMARY KEY AUTOINCREMENT," +
            "name VARCHAR(100)," +
            "last_name VARCHAR(100)," +
            "email VARCHAR(300), "+
            "password VARCHAR(800) )";


    private final static String createDirectors = "CREATE TABLE directors" + "(" +
            "id INTEGER PRIMARY KEY AUTOINCREMENT," +
            "name VARCHAR(100)," +
            "last_name VARCHAR(200)," +
            "email VARCHAR(300), "+
            "password VARCHAR(800) )";


    private final static String createTracks = "CREATE TABLE tracks" + "(" +
            "id INTEGER PRIMARY KEY AUTOINCREMENT," +
            "title VARCHAR(100)," +
            "description VARCHAR(300), "+
            "category VARCHAR(100)," +
            "autor VARCHAR(800)," +
            "file VARCHAR(800) )";


    ManagerSqlHelper(Context context) {
        super(context, dataBaseName, null, version);
    }


    @Override
    public void onOpen(SQLiteDatabase db) {
        super.onOpen(db);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        //creo las tablas para la base de datos
        db.execSQL(createDirectors);
        db.execSQL(createEmployees);
        db.execSQL(createMusicProducers);
        db.execSQL(createTracks);
        //lleno datos en la base de datos en la tabla casas de cambio
    }


    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int versionVieja, int versionnueva) {

    }


}
