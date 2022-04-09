package com.example.easygo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity3_1 extends AppCompatActivity {
    private Button b1;
    private TextView textView3;
    private EditText t1, t2, t3, t4, t5;
    DBLogin DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main31);
        b1 = findViewById(R.id.b1);
        textView3 = findViewById(R.id.textView3);
        t1 = findViewById(R.id.t1);
        t2 = findViewById(R.id.t2);
        t3 = findViewById(R.id.t3);
        t4 = findViewById(R.id.t4);
        t5 = findViewById(R.id.t5);
        DB = new DBLogin(this);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = t1.getText().toString();
                String name = t2.getText().toString();
                String mob = t3.getText().toString();
                String pass = t4.getText().toString();
                String cpass = t5.getText().toString();

                if (user.equals("") || name.equals("") || mob.equals("") || pass.equals("") || cpass.equals("")) {
                    Toast.makeText(MainActivity3_1.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();
                    return;
                }

                else {
                    if (pass.equals(cpass)) {
                        if(pass.length()<7)
                        {
                            Toast.makeText(MainActivity3_1.this, "password length should be more than 7 character", Toast.LENGTH_SHORT).show();
                            return;
                        }
                        if(mob.length()!=10){
                            Toast.makeText(MainActivity3_1.this, "Enter valid 10 digit mobile number", Toast.LENGTH_SHORT).show();
                            return;
                        }
                        Boolean checkuser = DB.checkusername(user);
                        if (checkuser == false) {
                            Boolean insert = DB.insertData(user, pass,name,mob);
                            if (insert == true) {
                                Toast.makeText(MainActivity3_1.this, "Registered successfully", Toast.LENGTH_SHORT).show();
                                //Intent intent = new Intent(getApplicationContext(), MainActivity2.class);
                                //startActivity(intent);
                            } else {
                                Toast.makeText(MainActivity3_1.this, "Registration failed", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Toast.makeText(MainActivity3_1.this, "User already exists! please sign in", Toast.LENGTH_SHORT).show();
                        }
                    }

                    else {
                        Toast.makeText(MainActivity3_1.this, "Passwords not matching", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}



