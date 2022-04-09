package com.example.easygo;

import static com.example.easygo.DBLogin.DBname;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity3_2 extends AppCompatActivity {
    private Button b1;
    private Button b2;
    private EditText t1,t2,t3,t4;
    DBLogin DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main32);
        b1=findViewById(R.id.b1);
        b2=findViewById(R.id.b2);
        t1=findViewById(R.id.t1);
        t2=findViewById(R.id.t2);
        t3=findViewById(R.id.t3);
        t4=findViewById(R.id.t4);
        DB =new DBLogin(this);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String n=t1.getText().toString();
                //String user=t1.getText().toString();
              //  Boolean checkupdatedata = DB.updateuserdata(user);
                SQLiteDatabase simpledb = getApplicationContext().openOrCreateDatabase("Login.db", Context.MODE_PRIVATE,null);
                Cursor c= simpledb.rawQuery("select * from users where UniqueID='"+n+"'",null);
                if(c.getCount()==0)
                {
                    Toast.makeText(getApplicationContext(), "No Record Found", Toast.LENGTH_LONG).show();
                    return;
                }

                //StringBuffer buffer =new StringBuffer();
                while(c.moveToNext())
                {
                    String name=c.getString(1);
                    String mob=c.getString(2);
                    String pass=c.getString(3);



//                    buffer.append("name "+c.getString(0)+"\n");
//                    buffer.append("mob "+c.getString(1)+"\n");
//                    buffer.append("pass "+c.getString(2)+"\n");
                    t2.setText(name);
                     t3.setText(mob);
                     t4.setText(pass);

                }
                //Toast.makeText(getApplicationContext(), "Result \n"+buffer.toString(), Toast.LENGTH_SHORT).show();


            }
        });
//        b2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                String n=t1.getText().toString();
//                //String user=t1.getText().toString();
//                //  Boolean checkupdatedata = DB.updateuserdata(user);
//                SQLiteDatabase simpledb = getApplicationContext().openOrCreateDatabase("Login.db", Context.MODE_PRIVATE,null);
//                simpledb.execSQL(" update from users where UniqueID='"+n+"'");
//
//                    Toast.makeText(MainActivity3_2.this, " Data Updated Successfully", Toast.LENGTH_SHORT).show();
//
//
////                1
//            }        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String UniqueId=t1.getText().toString();
                String name = t2.getText().toString();
                String mob = t3.getText().toString();
                String pass = t4.getText().toString();
                if(pass.length()<7 )
                {
                    Toast.makeText(MainActivity3_2.this, "password length should be more than 7 character", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(mob.length()!=10){
                    Toast.makeText(MainActivity3_2.this, "Enter valid 10 digit mobile number", Toast.LENGTH_SHORT).show();
                    return;
                }


                Boolean checkupdatedata = DB.updateuserdata(name, mob, pass,UniqueId);
                if(checkupdatedata==true)
                    Toast.makeText(MainActivity3_2.this, "Entry Updated", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(MainActivity3_2.this, "New Entry Not Updated", Toast.LENGTH_SHORT).show();
            }        });


    }
}