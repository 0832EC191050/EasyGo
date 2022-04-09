package com.example.easygo;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

public class VerifHis extends ListActivity {
    ArrayAdapter<String> adapter;
    private DBPerm DP;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verif_his);
        DP=new DBPerm(VerifHis.this);
        ArrayList a = DP.vieup();
        adapter=new ArrayAdapter<String>(this,
                android.R.layout.select_dialog_item,
                a);
        setListAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
}