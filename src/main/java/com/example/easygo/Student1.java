package com.example.easygo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Student1 extends AppCompatActivity {
    private EditText t1,t2,t3,t4,t5;
     private Button b;
DBPerm DP;
    DBLogin DB;
    protected boolean ch(String s){
        if(s.length()==0){
            return false;
        }
        else{
            return true;
        }
    }
    protected boolean dat(String d){
        int a=0;
        for(int i=0;i<d.length();i++){
            if(d.charAt(i)=='/'){
                a++;
            }
        }
        if(a==2){
            return true;
        }
        else{
            return false;
        }
    }
    protected boolean ti(String s){
        String[] t=s.split(":");
        if(t.length!=2){
            return false;
        }
        if(Integer.parseInt(t[0])>24 && Integer.parseInt(t[1])>60){
            return false;
        }
        return true;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student1);
        t1=findViewById(R.id.t1);
        t2=findViewById(R.id.t2);
        t3=findViewById(R.id.t3);
        t4=findViewById(R.id.t4);
        t5=findViewById(R.id.t5);
        b=findViewById(R.id.b);
        DP = new DBPerm(this);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String reason = t1.getText().toString();
                String room = t2.getText().toString();
                String place= t3.getText().toString();
                String date = t4.getText().toString();
                String time = t5.getText().toString();
Intent intent=getIntent();
             String str = intent.getStringExtra("name");
                String id = intent.getStringExtra("id");
                String mobile = intent.getStringExtra("mobile");
                Log.e("this :::::",id+" "+str+" "+mobile+" "+room+" "+reason+" "+place+" "+date+" "+time);
                if (reason.equals("") || room.equals("") || place.equals("") || date.equals("") || time.equals("")) {
                    Toast.makeText(Student1.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(ch(room) && ch(reason) && ch(place) && ch(date) && ch(time)){
                    if(dat(date) && ti(time)){
                        boolean a=DP.insertData(id,str,mobile,place,date,time ,room,reason);
                        if(a){
                            Toast.makeText(Student1.this, "Request sent", Toast.LENGTH_SHORT).show();
                        }
                        else{
                            Toast.makeText(Student1.this, "Please try again", Toast.LENGTH_SHORT).show();
                            return;
                        }
                    }
                    else{
                        Toast.makeText(Student1.this, "Enter correct details", Toast.LENGTH_SHORT).show();
                        return;
                    }

                }
                else{
                    Toast.makeText(Student1.this, "Enter all correct details", Toast.LENGTH_SHORT).show();
                    return;
                }

            }
        });
                }
    }
