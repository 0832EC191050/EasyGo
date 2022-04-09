package com.example.easygo;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity3_3 extends AppCompatActivity {
    private Button b;
    private EditText t1,t2;
    DBLogin DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main33);
        b=findViewById(R.id.b);
        t1=findViewById(R.id.t1);
        t2=findViewById(R.id.t2);
        DB =new DBLogin(this);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = t1.getText().toString();
                if(user.equals("A0832EC19050")){
                    Toast.makeText(MainActivity3_3.this, "You cannot remove main admin!!!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if(DB.checkusername(user)){
                    Alert(DB.chec(user),user);
                }

                else{
                    Toast.makeText(MainActivity3_3.this, "Id not found!!!", Toast.LENGTH_SHORT).show();
                }
              //  String name = t2.getText().toString();

                           }
        });
    }
    public  void Alert(String name, String id)
    {
        AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity3_3.this);
        builder.setMessage("Do you want to remove "+name+"'s record");
        builder.setTitle("Confirmation Alert");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Boolean checkudeletedata = DB.deletedata(id);
                if(checkudeletedata==true)
                    Toast.makeText(MainActivity3_3.this, "Successfully Id Deleted", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(MainActivity3_3.this, "Id Not Founded", Toast.LENGTH_SHORT).show();
                dialogInterface.cancel();
                recreate();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                dialogInterface.cancel();
                recreate();
            }
        });
        AlertDialog ac=builder.create();
        ac.show();
    }
}