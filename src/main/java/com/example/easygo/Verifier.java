package com.example.easygo;

import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
public class Verifier extends ListActivity {
    ArrayAdapter<String> adapter;
    String idd="";
    String date="";
    private Button b;
    private EditText t1;

    String time="";
    private DBPerm DP;
    //DEFINING A STRING ADAPTER WHICH WILL HANDLE THE DATA OF THE LISTVIEW


    //RECORDING HOW MANY TIMES THE BUTTON HAS BEEN CLICKED

    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.activity_verifier);
        // list = (ListView) findViewById(R.id.list);
        DP=new DBPerm(Verifier.this);
        b=(Button) findViewById(R.id.b);
        t1=(EditText) findViewById(R.id.t1);
        ArrayList a = DP.upd();
        adapter=new ArrayAdapter<String>(this,
                android.R.layout.select_dialog_item,
                a);
        setListAdapter(adapter);
        adapter.notifyDataSetChanged();
        b.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                String s=t1.getText().toString();
                if(s.length()==0){
                    ArrayList a = DP.upd();
                    adapter=new ArrayAdapter<String>(Verifier.this,
                            android.R.layout.select_dialog_item,
                            a);
                    setListAdapter(adapter);
                    adapter.notifyDataSetChanged();
                }
                else{
                    ArrayList c =DP.updd(s);
                    adapter=new ArrayAdapter<String>(Verifier.this, android.R.layout.select_dialog_item,c);
                    setListAdapter(adapter);
                    adapter.notifyDataSetChanged();
                }
            }
        });


        //list.setAdapter(adapter);

        //list = (ListView) findViewById(R.id.list);
        //adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_item, a);

    }
    protected void onListItemClick(ListView listView, View v, int position, long id) {
        // Get the list data adapter.
        ListAdapter listAdapter = listView.getAdapter();
        // Get user selected item object.
        Object selectItemObj = listAdapter.getItem(position);
        String itemText = (String)selectItemObj;
        int a;
        String b="",c="";
        String st[]=itemText.split(" ");
        for(int i=14;i<st.length;i++)
        {
            if(st[i].equals("Date:")){
                c=st[i+1];
            }

        }
        idd=st[2];
        date=c;
        time=st[st.length-1];
        Log.e("Id:       ",st[2]);
        Log.e("Date:       ",c);
        Log.e("Time:       ",st[st.length-1]);

        // Create an AlertDialog to show.
        onBackPr();

        //AlertDialog alertDialog = new AlertDialog.Builder(this).create();
        //alertDialog.setMessage(itemText);
        //alertDialog.show();
    }
    public void onBackPr()
    {

        // Create the object of
        // AlertDialog Builder class
        AlertDialog.Builder builder
                = new AlertDialog
                .Builder(Verifier.this);

        // Set the message show for the Alert time
        builder.setMessage("Will you give him/her permission ?");

        // Set Alert Title
        builder.setTitle("Alert !");

        // Set Cancelable false
        // for when the user clicks on the outside
        // the Dialog Box then it will remain show
        //builder.setCancelable(false);

        // Set the positive button with yes name
        // OnClickListener method is use of
        // DialogInterface interface.

        builder
                .setPositiveButton(
                        "Yes",
                        new DialogInterface
                                .OnClickListener() {

                            @Override
                            public void onClick(DialogInterface dialog,
                                                int which)
                            {
                                DP.updatedat("Yes",idd,date,time);
                                // When the user click yes button
                                // then app will close
                                dialog.cancel();
                                recreate();
                            }
                        });

        // Set the Negative button with No name
        // OnClickListener method is use
        // of DialogInterface interface.
        builder
                .setNegativeButton(
                        "No",
                        new DialogInterface
                                .OnClickListener() {

                            @Override
                            public void onClick(DialogInterface dialog,
                                                int which)
                            {
                                DP.updatedat("No",idd,date,time);
                                // If user click no
                                // then dialog box is canceled.
                                dialog.cancel();
                                recreate();
                            }
                        });

        // Create the Alert dialog
        AlertDialog alertDialog = builder.create();

        // Show the Alert Dialog box
        alertDialog.show();
    }


}

//METHOD WHICH WILL HANDLE DYNAMIC INSERTION
   /* public void addItems(View v) {
        listItems.add("Clicked : "+clickCounter++);
        adapter.notifyDataSetChanged();
    }*/
