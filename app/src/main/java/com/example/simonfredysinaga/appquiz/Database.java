package com.example.simonfredysinaga.appquiz;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Database {

    public static final String NAMA_DB = "dbkuis";
    public static final String NAMA_TB = "tb_admin";
    public static final int DB_VER = 1;

    public static final String ID_ADMIN = "id_admin";
    public static final String NAMA_ADMIN = "nama_admin";
    public static final String USERNAME_ADMIN = "username_admin";
    public static final String PASSWORD_ADMIN = "password_ADMIN";

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

}
