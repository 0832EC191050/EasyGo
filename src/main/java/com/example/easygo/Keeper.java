package com.example.easygo;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class Keeper extends ListActivity {
    private TextView t1;
    ArrayAdapter<String> adapter;
    private DBPerm DP;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_keeper);

        Intent intent = getIntent();
        String str = intent.getStringExtra("name");
        t1=(TextView) findViewById(R.id.tv1);
        t1.setText("Welcome "+str);
        DP=new DBPerm(Keeper.this);
        ArrayList a = DP.keepv();
        adapter=new ArrayAdapter<String>(this,
                android.R.layout.select_dialog_item,
                a);
        setListAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
}