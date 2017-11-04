package com.dkbrothers.app.lamus.dao;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.dkbrothers.app.lamus.models.Director;
import com.dkbrothers.app.lamus.models.Employee;
import com.dkbrothers.app.lamus.models.MusicProducer;
import com.dkbrothers.app.lamus.models.Track;


/**
 * Created by kevin on 16/04/2017.
 */
public class LamuDao{



    private static final  String NAME_TABLE_DIRECTORS="directors";
    private static final  String NAME_TABLE_TRACKS="tracks";
    private final  String NAME_TABLE_EMPLOYEES="employees";
    private static final  String NAME_TABLE_MUSIC_PRODUCERS="producers";
    private final  String ID="id";
    private  final String NAME="name";
    private  final String LAST_NAME="last_name";
    private  final String EMAIL="email";
    private  final String PASSWORD="password";
    private  final String FILE="file";
    private  static final String AUTOR="autor";
    private  static final String TITLE="title";
    private  static final String DESCRIPTION="description";
    private  static final String CATEGORY="category";
    public static String NAME_TABLE ="";
    private Context mContext;


    public LamuDao(Context mContext) {
        this.mContext = mContext;
    }



    public Employee getEmployee( String email, String  password){

        SQLiteDatabase db = new ManagerSqlHelper(mContext).getWritableDatabase();

        //consultar todo
        Cursor c = db.rawQuery("SELECT * FROM "+NAME_TABLE+" WHERE email="+email
                + "AND password="+password, null);

        Employee employee  = null;

        if(c.moveToNext()) {

            employee = new Employee();
            employee.setId(c.getInt(c.getColumnIndex(ID)));
            employee.setName(c.getString(c.getColumnIndex(NAME)));
            employee.setLastName(c.getString(c.getColumnIndex(LAST_NAME)));
            employee.setEmail(c.getString(c.getColumnIndex(EMAIL)));
            employee.setPassword(c.getString(c.getColumnIndex(PASSWORD)));

        }
        //cierro la base de datos
        db.close();
        //cierro el cursor
        c.close();

        return employee;
    }


    public Director getDirector( String email, String  password){

        SQLiteDatabase db = new ManagerSqlHelper(mContext).getWritableDatabase();

        //consultar todo
        Cursor c = db.rawQuery("SELECT * FROM "+NAME_TABLE+" WHERE email="+email
                + "AND password="+password, null);

        Director director  = null;

        if(c.moveToNext()) {

            director = new Director();
            director.setId(c.getInt(c.getColumnIndex(ID)));
            director.setName(c.getString(c.getColumnIndex(NAME)));
            director.setLastName(c.getString(c.getColumnIndex(LAST_NAME)));
            director.setEmail(c.getString(c.getColumnIndex(EMAIL)));
            director.setPassword(c.getString(c.getColumnIndex(PASSWORD)));

        }
        //cierro la base de datos
        db.close();
        //cierro el cursor
        c.close();

        return director;
    }



    public MusicProducer getMusicProducer( String email, String  password){

        SQLiteDatabase db = new ManagerSqlHelper(mContext).getWritableDatabase();

        //consultar todo
        Cursor c = db.rawQuery("SELECT * FROM "+NAME_TABLE+" WHERE email="+email
                + "AND password="+password, null);

        MusicProducer musicProducer  = null;

        if(c.moveToNext()) {

            musicProducer = new MusicProducer();
            musicProducer.setId(c.getInt(c.getColumnIndex(ID)));
            musicProducer.setName(c.getString(c.getColumnIndex(NAME)));
            musicProducer.setLastName(c.getString(c.getColumnIndex(LAST_NAME)));
            musicProducer.setEmail(c.getString(c.getColumnIndex(EMAIL)));
            musicProducer.setPassword(c.getString(c.getColumnIndex(PASSWORD)));

        }
        //cierro la base de datos
        db.close();
        //cierro el cursor
        c.close();

        return musicProducer;
    }



    public boolean saveEmployee(Employee employee){

        long inserted = 0;
        SQLiteDatabase db = new ManagerSqlHelper(mContext).getWritableDatabase();
        if (db!=null){
            ContentValues newItem = new ContentValues();
            newItem.put(NAME, employee.getName());
            newItem.put(EMAIL, employee.getEmail());
            newItem.put(PASSWORD, employee.getPassword());
            inserted=db.insert(NAME_TABLE_EMPLOYEES, null, newItem);
            db.close();
        }

        return inserted>0;

    }



    public boolean saveTrack(Track track){

        long inserted = 0;
        SQLiteDatabase db = new ManagerSqlHelper(mContext).getWritableDatabase();
        if (db!=null){
            ContentValues newItem = new ContentValues();
            newItem.put(TITLE, track.getTitle());
            newItem.put(DESCRIPTION, track.getDescription());
            newItem.put(CATEGORY, track.getCategory());
            newItem.put(AUTOR, track.getAutor());
            //newItem.put(FILE, track.getFile);
            inserted=db.insert(NAME_TABLE_TRACKS, null, newItem);
            db.close();
        }

        return inserted>0;

    }




}
