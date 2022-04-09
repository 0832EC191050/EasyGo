package com.example.easygo;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
private Button button;
private TextView textView2;
private TextView textView3;
//private TextView textView4;
//private TextView textView5;
private  EditText editTextTextPersonName;
private EditText editTextTextPassword;
 DBLogin DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.b);
        textView2 = findViewById(R.id.textView2);
        textView3 = findViewById(R.id.textView3);
       // textView4 = findViewById(R.id.textView4);
        //textView5 = findViewById(R.id.textView5);
        editTextTextPersonName = findViewById(R.id.t1);
        editTextTextPassword = findViewById(R.id.editTextTextPassword);
        DB = new DBLogin(this);
       /* button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Now You Are Logined", Toast.LENGTH_SHORT).show();

            }  });

        */
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String user = editTextTextPersonName.getText().toString();
                String pass = editTextTextPassword.getText().toString();

                if(user.equals("")||pass.equals(""))
                    Toast.makeText(MainActivity.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();

                else{
                    Boolean checkuserpass = DB.checkusernamepassword(user, pass);

                    if(checkuserpass==true){
                        if(user.equals("A0832EC191050")){
                            Toast.makeText(MainActivity.this, "Sign in successfull", Toast.LENGTH_SHORT).show();
                            Intent intent  = new Intent(getApplicationContext(), MainActivity2.class);
                            intent.putExtra("name",DB.getname(user));
                            intent.putExtra("mobile",DB.getmobi(user));
                            startActivity(intent);
                        }
                        if(user.charAt(0)=='S'){
                            Toast.makeText(MainActivity.this, "Sign in successfull", Toast.LENGTH_SHORT).show();
                            Intent intent  = new Intent(getApplicationContext(), Student.class);
                            intent.putExtra("name",DB.getname(user));
                            intent.putExtra("mobile",DB.getmobi(user));
                            intent.putExtra("id",user);
                            startActivity(intent);
                        }
                        if(user.charAt(0)=='V'){
                            Toast.makeText(MainActivity.this, "Sign in successfull", Toast.LENGTH_SHORT).show();
                            Intent intent  = new Intent(getApplicationContext(), Verifier1.class);
                            intent.putExtra("name",DB.getname(user));
                            intent.putExtra("mobile",DB.getmobi(user));
                            startActivity(intent);
                        }
                        if(user.charAt(0)=='K'){
                            Toast.makeText(MainActivity.this, "Sign in successfull", Toast.LENGTH_SHORT).show();
                            Intent intent  = new Intent(getApplicationContext(), Keeper.class);
                            intent.putExtra("name",DB.getname(user));
                            intent.putExtra("mobile",DB.getmobi(user));
                            startActivity(intent);
                        }

//                        Toast.makeText(MainActivity.this, "Sign in successfull", Toast.LENGTH_SHORT).show();
//                        Intent intent  = new Intent(getApplicationContext(), MainActivity2.class);
//                        startActivity(intent);
                    }else{
                        Toast.makeText(MainActivity.this, "Invalid Id,Password", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

    public TextView getTextView3() {
        return textView3;
    }

    public void setTextView3(TextView textView3) {
        this.textView3 = textView3;
    }

    public TextView getTextView2() {
        return textView2;
    }

    public void setTextView2(TextView textView2) {
        this.textView2 = textView2;
    }


//        public void  openActivity(View v)
//  {
//      //Toast.makeText(this, "Now You Are Logined ", Toast.LENGTH_SHORT).show();
//      Intent intent= new Intent(this, Student.class);
//      startActivity(intent);
//  }
}