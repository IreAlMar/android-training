package com.example.irene.myfirstapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Observer;

public class DisplayMessageActivity extends Activity implements View.OnClickListener {

    private Button buttonListenerClase;
    private Button buttonListenerAnonimo;
//Esto es un cambio
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);
        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);
        buttonListenerClase = (Button) findViewById(R.id.buttonListenerClase);
        buttonListenerClase.setOnClickListener(this);
        buttonListenerAnonimo = (Button) findViewById(R.id.buttonListenerAnonimo);
        buttonListenerAnonimo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("BTN", "onClick() [Anonimo]");
                muestraToast(v);
            }
        });

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent intent = getIntent();
        String message = intent.getStringExtra(MyActivity.EXTRA_MESSAGE);
        TextView textView = new TextView(this);
        textView.setTextSize(40);
        textView.setText(message);
        RelativeLayout layout = (RelativeLayout) findViewById(R.id.content);
        layout.addView(textView);

    }

    private void muestraToast(View v){
        Button b = (Button)v;
        Toast.makeText(this,b.getText(), Toast.LENGTH_LONG).show();
    }

    public void onClick(View v){
        Log.i("BTN", "onClick() [Clase]");
        muestraToast(v);
    }

}
