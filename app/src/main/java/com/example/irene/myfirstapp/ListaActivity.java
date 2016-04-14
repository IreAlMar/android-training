package com.example.irene.myfirstapp;

import android.app.ListActivity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class ListaActivity extends ListActivity {

    public static final String TAG = ListaActivity.class.getSimpleName();
    private TextView textViewTitle;
    public static String[] days = {"Monday", "Tuesday", "Wednesday", "Thursday"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);
        Intent intent = getIntent();

        textViewTitle = (TextView) findViewById(R.id.textViewTitle);

        setListAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, days));

        /*
        Intent intent = getIntent();
        TextView textView = new TextView(this);
        textView.setTextSize(20);
        textView.setText("My message for the list");

        RelativeLayout layout = (RelativeLayout) findViewById(R.id.content);
        layout.addView(textView);*/
    }

    protected void onListItemClick(ListView l, View v, int position, long id){
        super.onListItemClick(l,v, position, id);

        String item = getListAdapter().getItem(position).toString();
        String pulsado = "Pulsado" + position + " " + item;
        Log.d(TAG,pulsado);

        switch (days[position]){
            case "Monday":
                textViewTitle.setTextColor(Color.RED);
                break;
            case "Tuesday":
                textViewTitle.setTextColor(Color.GREEN);
                break;
            case "Wednesday":
                textViewTitle.setTextColor(Color.BLUE);
                break;
            case "Thursday":
                textViewTitle.setTextColor(Color.BLACK);
                break;
        }
    }
}
