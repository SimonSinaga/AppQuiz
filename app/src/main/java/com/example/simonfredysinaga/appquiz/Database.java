package com.example.simonfredysinaga.appquiz;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.HashMap;

public class Database {

    public static final String NAMA_DB = "dbkuis";
    public static final String NAMA_TB = "tbadmin";
    public static final int DB_VER = 1;

    public static final String ID_ADMIN = "id_admin";
    public static final String NAMA_ADMIN = "nama_admin";
    public static final String USERNAME_ADMIN = "username_admin";
    public static final String PASSWORD_ADMIN = "password_admin";

    public static final String CREATE_TB = "create table "+NAMA_TB+
            "("+ID_ADMIN + " integer primary key autoincrement, "+
            NAMA_ADMIN + " text not null, " +
            USERNAME_ADMIN + " text not null, " +
            PASSWORD_ADMIN + " text not null)";

    Context context;
    SQLiteDatabase sqLiteDatabase;
    DatabaseHelper databaseHelper;

    public Database (Context context){
        this.context = context;
        databaseHelper = new DatabaseHelper(context);
        sqLiteDatabase = databaseHelper.getWritableDatabase();
    }

    public class DatabaseHelper extends SQLiteOpenHelper{
        public DatabaseHelper(Context context){
            super(context, NAMA_DB, null, DB_VER);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(CREATE_TB);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS "+NAMA_TB);
            onCreate(db);
        }
    }

    public void sisipData(String namaAdm, String usernameAdm, String passwordAdm){
        ContentValues cv = new ContentValues();
        cv.put(NAMA_ADMIN, namaAdm);
        cv.put(USERNAME_ADMIN, usernameAdm);
        cv.put(PASSWORD_ADMIN, passwordAdm);
        sqLiteDatabase.insert(NAMA_TB, null, cv);
    }



    public ArrayList<HashMap<String, String>> tampilData(){
        ArrayList<HashMap<String, String>> dataList;
        dataList = new ArrayList<HashMap<String, String>>();
        Cursor cursor = sqLiteDatabase.rawQuery(
                "select * from "+NAMA_TB, null);
        if(cursor.moveToFirst()){
            do{
                HashMap<String, String> data = new HashMap<String, String>();
                data.put(ID_ADMIN, cursor.getString(0));
                data.put(NAMA_ADMIN, cursor.getString(1));
                data.put(USERNAME_ADMIN, cursor.getString(2));
                data.put(PASSWORD_ADMIN, cursor.getString(3));
                dataList.add(data);
            }while (cursor.moveToNext());
        }
        return dataList;
    }

}
