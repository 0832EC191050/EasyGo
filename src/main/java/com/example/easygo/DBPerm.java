package com.example.easygo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.Random;

public class DBPerm extends SQLiteOpenHelper {

    private static final int version = 1 ;
    private static final String TABLE_NAME = "perm";
    private static final String Iddt = "iddt";



    public DBPerm(Context context) {
        super(context, "Perm.db",null,version);
    }

    @Override
    public void onCreate(SQLiteDatabase mydb) {
        mydb.execSQL("Create Table perm(UniqueId TEXT, name TEXT, sno INTEGER PRIMARY KEY AUTOINCREMENT,mob TEXT, room TEXT,place TEXT, reason TEXT,perm TEXT,date TEXT,time TEXT, secure TEXT,Iddt TEXT)");


    }

    @Override
    public void onUpgrade(SQLiteDatabase mydb, int i, int i1) {
        mydb.execSQL("drop Table if exists perm");


    }
    public Boolean insertData(String UniqueId, String name, String mob,String place,String date,String time, String room, String reason) {
        SQLiteDatabase mydb = this.getWritableDatabase();
        ContentValues Values = new ContentValues();
        Values.put("UniqueId", UniqueId);
        //contentValues.put("password", password);
        Values.put("name", name);
        Values.put("mob", mob);
        Values.put("room", room);
        Values.put("reason", reason);
        Values.put("place", place);
        Values.put("date", date);
        Values.put("time", time);
        Values.put("perm", "0");
        Values.put("Iddt", UniqueId+date+time);

       // values.put("iddt", UniqueId+date+time);

        long result = mydb.insert("perm", null, Values);
        if (result == -1) {

            mydb.close();
            return false;}
        else{
            mydb.close();
            return true;}
    }
    public int deleteRec(String id,String name) {
        SQLiteDatabase db = this.getWritableDatabase();
        int r=db.delete(TABLE_NAME, "UniqueId=? and name=?", new String[]{id,name});
        db.close();
        return r;
    }
    public ArrayList upd()
    {
        int temp=0;
        ArrayList s=new ArrayList();
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery("SELECT * FROM perm",null, null);
        while (cursor.moveToNext()){
            if(cursor.getString(7).equals("0")){
                Log.e("Per:",cursor.getString(7));
                String a=String.valueOf(++temp)+". Id: "+cursor.getString(0)+"\n Name: "+cursor.getString(1)+"\n Mobile: "+cursor.getString(3)+" \nRoom No: "+cursor.getString(4)+"\n Reason: "+cursor.getString(6)+"\n Place: "+cursor.getString(5)+"\n Date: "+cursor.getString(8)+"\n Time: "+cursor.getString(9);
                s.add(a);
            }}

        cursor.close();
        db.close();
        return s;
    }
    public ArrayList vieup()
    {
        int temp=0;
        ArrayList s=new ArrayList();
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery("SELECT * FROM perm ORDER BY sno DESC",null, null);
        while (cursor.moveToNext()){
            if(!(cursor.getString(7).equals("0"))){
                Log.e("Per:",cursor.getString(7));
                String a=String.valueOf(++temp)+". Permission: "+cursor.getString(7)+"\n Id: "+cursor.getString(0)+"\n Name: "+cursor.getString(1)+"\n Mobile: "+cursor.getString(3)+" \n Room No: "+cursor.getString(4)+"\n Reason: "+cursor.getString(6)+"\n Place: "+cursor.getString(5)+"\n Date: "+cursor.getString(8)+"\n Time: "+cursor.getString(9);
                s.add(a);
            }}

        cursor.close();
        db.close();
        return s;
    }
    public ArrayList keepv()
    {
        int temp=0;
        ArrayList s=new ArrayList();
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery("SELECT * FROM perm ORDER BY sno DESC",null, null);
        while (cursor.moveToNext()){
            if(cursor.getString(7).equals("Yes")){
                Log.e("Per:",cursor.getString(7));
                String a=String.valueOf(++temp)+". Security Code: "+cursor.getString(10)+"\n Id: "+cursor.getString(0)+"\n Name: "+cursor.getString(1)+"\n Mobile: "+cursor.getString(3)+" \n Room No: "+cursor.getString(4)+"\n Reason: "+cursor.getString(6)+"\n Place: "+cursor.getString(5)+"\n Date: "+cursor.getString(8)+"\n Time: "+cursor.getString(9);
                s.add(a);
            }}

        cursor.close();
        db.close();
        return s;
    }

    public ArrayList upw(String id)
    {
        int temp=0;
        ArrayList s=new ArrayList();
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery("SELECT * FROM perm ORDER BY sno DESC",null, null);
        while (cursor.moveToNext()){
            if(cursor.getString(0).equals(id) && (cursor.getString(7).equals("Yes") || cursor.getString(7).equals("No"))){
                Log.e("Per:",cursor.getString(9));
                String a=String.valueOf(++temp)+". Permission: "+cursor.getString(7)+"\n Id: "+cursor.getString(0)+"\n Name: "+cursor.getString(1)+"\n Mobile: "+cursor.getString(3)+" \n Room No: "+cursor.getString(4)+"\n Reason: "+cursor.getString(6)+"\n Place: "+cursor.getString(5)+"\n Date: "+cursor.getString(8)+"\n Time: "+cursor.getString(9)+"\n Security Code: "+cursor.getString(10);
                s.add(a);
            }}

        cursor.close();
        db.close();
        return s;
    }
    public ArrayList updd(String id)
    {
        int temp=0;
        ArrayList s=new ArrayList();
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery("SELECT * FROM perm",null, null);
        while (cursor.moveToNext()){
            if(cursor.getString(7).equals("0") && cursor.getString(0).equals(id)){
                Log.e("Per:",cursor.getString(7));
                String a=String.valueOf(++temp)+". Id: "+cursor.getString(0)+"\n Name: "+cursor.getString(1)+"\n Mobile: "+cursor.getString(3)+" \nRoom No: "+cursor.getString(4)+"\n Reason: "+cursor.getString(6)+"\n Place: "+cursor.getString(5)+"\n Date: "+cursor.getString(8)+"\n Time: "+cursor.getString(9);
                s.add(a);
            }}

        cursor.close();
        db.close();
        return s;
    }
    // below is the method for updating our courses
    static char[] OTP(int len)
    {
        String numbers = "0123456789";
        Random rndm_method = new Random();
        char[] otp = new char[len];
        for (int i = 0; i < len; i++)
        {
            // Use of charAt() method : to get character value
            // Use of nextInt() as it is scanning the value as int
            otp[i] =
                    numbers.charAt(rndm_method.nextInt(numbers.length()));
        }
        return otp;
    }
    public void updatedat(String per,String id,String date,String time) {

        // calling a method to get writable database.
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        // on below line we are passing all values
        // along with its key and value pair.

        values.put("perm", per);
        if(per.equals("Yes")){
            values.put("secure", String.valueOf(OTP(6)));
        }
        else{
            values.put("secure", "");
        }
        String ar[]=(id+date+time).split("\n");
        Log.e("id+d+t",ar[0]+ar[1]+ar[2]);
        //String updateQuery ="UPDATE permite SET permission = "+per+" and code = "+String.valueOf(OTP(6))+" WHERE (id+date+time) = "+ar[0]+ar[1]+ar[2];
        //Cursor c= db.rawQuery(updateQuery, null);

        //c.moveToFirst();
        //c.close();


        // on below line we are calling a update method to update our database and passing our values.
        // and we are comparing it with name of our course which is stored in original name variable.
        db.update(TABLE_NAME, values, "iddt=?", new String[]{ar[0]+ar[1]+ar[2]});

        //Log.e("per",cursor.getString(9));

        db.close();
    }






}
