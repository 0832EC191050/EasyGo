package com.example.easygo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class DBLogin extends SQLiteOpenHelper {

    String getname(String id)
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        String s="";
        Cursor cursor = DB.rawQuery("Select * from users where UniqueId=?", new String[]{id});
        while(cursor.moveToNext()) {
            s = cursor.getString(1);
        }
        return s;
    }
    String getmobi(String id)
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        String s="";
        Cursor cursor = DB.rawQuery("Select * from users where UniqueId=?", new String[]{id});
        while(cursor.moveToNext()) {
            s = cursor.getString(2);
        }
        return s;
    }

    public static final String DBname = "Login.db";
    private static final int version = 1;
  //  private String UniqueId;

    public DBLogin(Context context) {
        super(context, "Login.db", null, version);
        boolean a=insertData("A0832EC191050","Shubh19","Shubhank","7223027711");

    }

    @Override
    public void onCreate(SQLiteDatabase MyDB) {
        MyDB.execSQL("Create Table users(UniqueId TEXT primary key, name TEXT, mob TEXT,password TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase MyDB, int i, int i1) {

        MyDB.execSQL("drop Table if exists users");
    }


//    public Boolean insertData(String UniqueId, String password) {
//        SQLiteDatabase MyDB = this.getWritableDatabase();
//        ContentValues contentValues = new ContentValues();
//        contentValues.put("UniqueId", UniqueId);
//        contentValues.put("password", password);
//        long result = MyDB.insert("UniqueID", null, contentValues);
//        if (result == -1)
//            return false;
//        else
//            return true;
//
//    }

    public Boolean insertData(String UniqueId, String password, String name, String mob) {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("UniqueId", UniqueId);
        contentValues.put("password", password);
        contentValues.put("name", name);
        contentValues.put("mob", mob);

        long result = MyDB.insert("users", null, contentValues);
        if (result == -1) {

            MyDB.close();
            return false;}
        else{
            MyDB.close();
            return true;}
    }


    public Boolean updateuserdata(String name, String mob, String password, String UniqueId)
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("UniqueId", UniqueId);
        contentValues.put("name", name);
        contentValues.put("mob", mob);
        contentValues.put("password", password);
        Cursor cursor = DB.rawQuery("Select * from users where UniqueId = ?", new String[]{UniqueId});
        if (cursor.getCount() > 0) {
            long result = DB.update("users", contentValues, "UniqueId=?", new String[]{UniqueId});
            if (result == -1) {
                cursor.close();
                DB.close();
                return false;
            } else {
                cursor.close();
                DB.close();
                return true;
            }
        } else {
            cursor.close();
            DB.close();
            return false;
        }
    }
    public Boolean deletedata (String UniqueId)
    {
        SQLiteDatabase DB = this.getWritableDatabase();
//        Cursor cursor = DB.rawQuery("Select * from Users where UniqueId= ?", new String[]{UniqueId});
//        if (cursor.getCount() > 0) {
//            long result = DB.delete("Users", "UniqueId=?", new String[]{UniqueId});
//            if (result == -1) {
//                return false;
//            } else {
//                return true;
//            }
//        } else {
//            return false;
//        }
        long result = DB.delete("users", "UniqueId=?", new String[]{UniqueId});
        if(result>0){
            DB.close();
            return true;
        }
        else{
            DB.close();
            return false;
        }

    }


    public Cursor getdata ()
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("Select * from Users", null);
        return cursor;
    }



    public Boolean checkusername(String UniqueId) {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from users where UniqueId = ?", new String[]{UniqueId});
        if (cursor.getCount() > 0){
            cursor.close();
        MyDB.close();
            return true;}
        else{
        cursor.close();
        MyDB.close();
            return false;}
    }
    public String chec(String UniqueId) {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        String d="";
        Cursor cursor = MyDB.rawQuery("Select * from users where UniqueId = ?", new String[]{UniqueId});
        while(cursor.moveToNext()) {
            d = cursor.getString(1);
        }
        cursor.close();
        MyDB.close();
            return d;
    }

    public Boolean checkusernamepassword(String UniqueId, String password) {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from users where UniqueId = ? and password = ?", new String[]{UniqueId, password});
        if (cursor.getCount() > 0){
            cursor.close();
            MyDB.close();
            return true;}
        else{
            cursor.close();
            MyDB.close();
            return false;}
    }
}


