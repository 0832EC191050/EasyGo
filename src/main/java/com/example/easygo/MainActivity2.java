package com.example.easygo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;



public class MainActivity2 extends AppCompatActivity implements MyAdapter.Abclicklistener {
ListView listView;
TextView tv;
    MyAdapter ad;

//private Button button2;
String arr[]={"Add","Update","Remove"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {

//        @override
//        void onclick(int position);
//        {
//
//        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        listView =findViewById(R.id.listView);
tv=(TextView)findViewById(R.id.textView7);
        Intent intent=getIntent();
        String str = intent.getStringExtra("name");
tv.setText("Welcome "+str);
       // button2 =findViewById(R.id.button2);

        // ArrayAdapter ad=new ArrayAdapter(this,android.R.layout.simple_list_item_1,arr);
        //listView.setAdapter(ad);
       ad=new MyAdapter(this,R.layout.my_shubh_layout,arr,this);
        listView.setAdapter(ad);


//    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//        @Override
//        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//            Toast.makeText(MainActivity2.this, "you clicked on:"+i, Toast.LENGTH_SHORT).show();
//        }
//    });

    }

   public void  openActivity(View v)
    {
        String s=ad.s;
        if(s.equals("Add"))
        {
            Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
            Intent intent= new Intent(this, MainActivity3_1.class);
            startActivity(intent);
        }

        //Toast.makeText(this, "Now You Are Logined ", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onclick(int position) {
        //Intent inti;

//        switch(position)
//        {
//            case 0:
//                Intent inti;
//                inti =new Intent(this,MainActivity3_1.class) ;
//                startActivity(inti);
//        }

    }
}