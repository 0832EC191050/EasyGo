package com.example.easygo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Verifier1 extends AppCompatActivity {
    private TextView tt;
    private Button b1,b2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verifier1);
        tt=(TextView) findViewById(R.id.tt);
        b1=(Button) findViewById(R.id.b1);
        b2=(Button) findViewById(R.id.b2);
        Intent i=getIntent();
        String n=i.getStringExtra("name");
        tt.setText("Welcome "+n);
        b1.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent send = new Intent(Verifier1.this, Verifier.class);
                startActivity(send);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent send = new Intent(Verifier1.this, VerifHis.class);
                startActivity(send);
            }
        });
    }
}