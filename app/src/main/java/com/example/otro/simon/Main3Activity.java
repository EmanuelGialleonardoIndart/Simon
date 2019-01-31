package com.example.otro.simon;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Main3Activity extends AppCompatActivity {
    TextView texto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        texto=(TextView) findViewById(R.id.texto1);
        Bundle dato=getIntent().getExtras();
        int result=dato.getInt("dificultad");
        if(result==0){
        texto.setText("has hecho "+String.valueOf(dato.getInt("dato"))+" puntos.");}
        else{
            if(result==1){
                texto.setText("nuevo record facil: "+String.valueOf(dato.getInt("dato"))+" puntos.");
            }
            else{
                if(result==2){
                    texto.setText("nuevo record normal: "+String.valueOf(dato.getInt("dato"))+" puntos.");

                }else{
                    texto.setText("nuevo record dificil: "+String.valueOf(dato.getInt("dato"))+" puntos.");
                }
            }
        }

    }
    public void volver(View v){
        Intent i=new Intent(this,MainActivity.class);
        startActivity(i);
        this.finish();
    }
}
