package com.example.otro.simon;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Main4Activity extends AppCompatActivity {
    TextView texto1;
    TextView texto2;
    TextView texto3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        texto1=(TextView) findViewById(R.id.text5);
        texto2=(TextView) findViewById(R.id.texto1);
        texto3=(TextView) findViewById(R.id.texto2);
        Bundle dato=getIntent().getExtras();
        int dato1=dato.getInt("dato1");
        int dato2=dato.getInt("dato2");
        int dato3=dato.getInt("dato3");
        texto1.setText("facil: "+String.valueOf(dato1)+".");
        texto2.setText("normal: "+String.valueOf(dato2)+".");
        texto3.setText("dificil: "+String.valueOf(dato3)+".");
    }
    public void volver(View v){
        Intent i=new Intent(this,MainActivity.class);
        startActivity(i);
        this.finish();
    }
}
