package com.example.easygo;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class MyAdapter extends ArrayAdapter<String> {
    Button b;
    String s="";
private String[] arr;
private Context context;
interface Abclicklistener
{
    void onclick(int position);
}
    Abclicklistener  cd;
    public MyAdapter(@NonNull Context context, int resource, @NonNull String[] arr,Abclicklistener cd) {

        super(context, resource, arr);
        this.cd=cd;
        this.context=context;
        this.arr = arr;
    }

    @Nullable
    @Override
    public String getItem(int position) {
        return arr[position];
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {


        convertView= LayoutInflater.from(getContext()).inflate(R.layout.my_shubh_layout,parent,false);
        TextView t=convertView.findViewById(R.id.textView);
        t.setText(getItem(position));
        b= convertView.findViewById(R.id.button2);
        b.setText(getItem(position));


       convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(context, "please clicked on Button:"+arr[position], Toast.LENGTH_SHORT).show();
                cd.onclick(position);
            }
        });
            b.setOnClickListener(



                new View.OnClickListener()
                {
                    @Override
                    public void onClick(View V)
                    {
                        switch(position)
                        {
                            case 0: {
                              context.startActivity(new Intent(parent.getContext(),MainActivity3_1.class));
                               // context.startActivity(new Intent(this,MainActivity3_1.class));
                                break;
                            }
                            case 1:
                            {
                                context.startActivity(new Intent(parent.getContext(),MainActivity3_2.class));
                               break;
                            }
                            case 2:
                            {
                                context.startActivity(new Intent(parent.getContext(),MainActivity3_3.class));
                                break;
                            }
                        }
                        s=((Button) V).getText().toString();
                        Toast.makeText(context,s, Toast.LENGTH_SHORT).show();
                    }
                });
        return convertView;

    }


}
