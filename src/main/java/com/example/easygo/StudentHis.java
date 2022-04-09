package com.example.easygo;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

public class StudentHis extends ListActivity {
    ArrayAdapter<String> adapter;
    private DBPerm DP;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_his);
        DP=new DBPerm(StudentHis.this);
        Intent intent = getIntent();
        String str = intent.getStringExtra("name");
        String id = intent.getStringExtra("id");
        String mobile = intent.getStringExtra("mobile");
        ArrayList a = DP.upw(id);
        adapter=new ArrayAdapter<String>(this,
                android.R.layout.select_dialog_item,
                a);
        setListAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
}