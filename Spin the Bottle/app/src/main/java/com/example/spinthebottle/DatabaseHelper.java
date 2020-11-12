package com.example.spinthebottle;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;


public class DatabaseHelper extends SQLiteOpenHelper {

    static String name = "database";
    static int version = 1;

    String createTableUser = "CREATE TABLE \"user\" ( \"id\"\tINTEGER PRIMARY KEY AUTOINCREMENT, \"username\"\tTEXT, \"password\"\tTEXT, \"email\"\tTEXT, \"dob\"\tTEXT, \"gender\"\tTEXT )";

    public DatabaseHelper(Context context) {
        super(context, name, null, version);
        getWritableDatabase().execSQL(createTableUser);
    }

    public void  insertUser(ContentValues contentValues){
         getWritableDatabase().insert("user","",contentValues);
    }

    public boolean isLoginValid(String username, String password){
        String sql = "Select count(*) from user where username='"+ username +" and password='"+password+"'";
        SQLiteStatement statement = getReadableDatabase().compileStatement(sql);
        long l =statement.simpleQueryForLong();
        statement.close();

        if(l == 1){
            return true;
        }
        else {
            return false;
        }

    }



    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
