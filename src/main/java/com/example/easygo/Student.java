package com.example.easygo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Student extends AppCompatActivity {
    private Button b1;
    private Button b2;
    private TextView ts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);
        b1=findViewById(R.id.b1);
        b2=findViewById(R.id.b2);
        ts= findViewById(R.id.ts);
        Intent intent = getIntent();
        String str = intent.getStringExtra("name");
        String id = intent.getStringExtra("id");
        String mobile = intent.getStringExtra("mobile");
        Log.e("ss",str+" "+id+" "+mobile);
        ts.setText("Welcome "+str);
        b1.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent send = new Intent(Student.this, Student1.class);
                send.putExtra("name",str);
                send.putExtra("id",id);
                send.putExtra("mobile",mobile);
                startActivity(send);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent send = new Intent(Student.this, StudentHis.class);
                send.putExtra("name",str);
                send.putExtra("id",id);
                send.putExtra("mobile",mobile);
                startActivity(send);
            }
        });
//public  void openActivity(View v)
        {

        }
    }
}