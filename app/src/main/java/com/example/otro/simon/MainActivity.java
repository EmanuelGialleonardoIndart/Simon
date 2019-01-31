package com.example.otro.simon;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void facil(View v){
        Intent i= new Intent(this,Main2Activity.class);
        i.putExtra("dato",1);
        startActivity(i);
        this.finish();
    }
    public void normal(View v){
        Intent i= new Intent(this,Main2Activity.class);
        i.putExtra("dato",2);
        startActivity(i);
        this.finish();
    }
    public void dificil(View v){
        Intent i= new Intent(this,Main2Activity.class);
        i.putExtra("dato",3);
        startActivity(i);
        this.finish();
    }
}
