package com.example.otro.simon;

import android.content.Intent;


import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Collection;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Random;
import java.util.LinkedList;
import java.util.logging.LogRecord;

public class Main2Activity extends AppCompatActivity {
    Random random=new Random();
    int cont=0;
    int por=5;
    int dificultad;
    int cant;
    int total=0;
    int divi=0;
    int pos2;
    int num;
    int num2;
    boolean aux=false;
    TextView texto;
    int pos;
    Button botonrojo;
    Button botonverde;
    Button botonazul;
    Button botonamarillo;
    int arreglo[]=new int[100];
    CountDownTimer conteo;
    MediaPlayer boton1;
    MediaPlayer boton2;
    MediaPlayer boton3;
    MediaPlayer boton4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        botonrojo=(Button) findViewById(R.id.botonrojo);
        botonverde=(Button) findViewById(R.id.botonverde);
        botonazul=(Button) findViewById(R.id.botonazul);
        botonamarillo=(Button)findViewById(R.id.botonamarillo);
        texto=(TextView) findViewById(R.id.texto);
        boton1=MediaPlayer.create(this.getApplicationContext(),R.raw.boton1);
        boton2=MediaPlayer.create(this.getApplicationContext(),R.raw.boton2);
        boton3=MediaPlayer.create(this.getApplicationContext(),R.raw.boton3);
        boton4=MediaPlayer.create(this.getApplicationContext(),R.raw.boton4);

        Bundle dato=getIntent().getExtras();
        for(int i=0;i<100;i++){
            arreglo[i]=0;

        }
        dificultad=dato.getInt("dato");
        if(dificultad==1){
            total=2100;
            divi=700;
        }else{
            if(dificultad==2){
                total=1500;
                divi=500;
            }else {if(dificultad==3){
                total=1200;
                divi=400;
            }}
        }


        comenzar();


        }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater mi=getMenuInflater();
        mi.inflate(R.menu.menu_opciones,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        if(item.getItemId()==R.id.fa){
            facil();
        }
        else{
            if(item.getItemId()==R.id.nor){
                normal();
            }
            else {
                if (item.getItemId()==R.id.dif){
                    dificil();
                }else{
                    if(item.getItemId()==R.id.salida){
                        Intent i=new Intent(this,MainActivity.class);
                        startActivity(i);
                        this.finish();
                    }else{
                        if(item.getItemId()==R.id.puntajes){
                            puntages();
                        }
                    }

                }
            }
        }
        return true;
    }

    public void comenzar(){cant=0;
        pos=0;
        new CountDownTimer(1000,1000){
            public void onTick(long millisUntilFinished) {}
            public void onFinish(){generico();
            }}.start();

        //varia la entrada para couldown dependiendo de la cantidad de repeticiones y la velocidad elegida

    }
    public void generico(){
        int num1=1+random.nextInt(4);
        arreglo[cont]=num1;
        conteo=new CountDownTimer(total,divi){
            public void onTick(long millisUntilFinished){
                if(cant%2==0){

                    int num=arreglo[pos];

                    if(num==1){
                        botonrojo.setBackgroundColor(getResources().getColor(R.color.rojoClaro));
                        boton1.seekTo(0);
                        if(!boton1.isPlaying()){
                            boton1.start();
                        }


                    }else{
                        if(num==2){
                            botonverde.setBackgroundColor(getResources().getColor(R.color.verdeclaro));
                            boton2.seekTo(0);
                            if(!boton2.isPlaying()){
                                boton2.start();
                            }

                        }else{
                            if(num==3){
                                botonazul.setBackgroundColor(getResources().getColor(R.color.azulclaro));
                                boton3.seekTo(0);
                                if(!boton3.isPlaying()){
                                    boton3.start();
                                }

                            }else{
                                if (num==4){
                                    botonamarillo.setBackgroundColor(getResources().getColor(R.color.amarilloclaro));
                                    boton4.seekTo(0);
                                    if(!boton4.isPlaying()){
                                        boton4.start();
                                    }

                                }
                            }
                        }

                    }cant++;pos++;


                }else{
                    botonverde.setBackgroundColor(getResources().getColor(R.color.verdeoscuro));
                    botonrojo.setBackgroundColor(getResources().getColor(R.color.rojoOscuro));
                    botonazul.setBackgroundColor(getResources().getColor(R.color.azuloscuro));
                    botonamarillo.setBackgroundColor(getResources().getColor(R.color.amarillooscuro));
                    cant++;
                    if(arreglo[pos+1]==0){
                        aux=true;
                        pos2=0;
                        botonrojo.setBackground(getResources().getDrawable(R.drawable.botonrojo));
                        botonazul.setBackground(getResources().getDrawable(R.drawable.botonazul));
                        botonverde.setBackground(getResources().getDrawable(R.drawable.botonverde));
                        botonamarillo.setBackground(getResources().getDrawable(R.drawable.botonamarillo));


                    }

                }

            }
            public void onFinish(){
            }

        }.start();
    }
    public void rojo(View v){
        if(aux==true){
            boton1.seekTo(0);
            if(!boton1.isPlaying()){
                boton1.start();
            }
            num=1;
            procezar(num);

        }
    }
    public void verde(View v){
        if(aux==true){
            boton2.seekTo(0);
            if(!boton2.isPlaying()){
                boton2.start();
            }
            num=2;
            procezar(num);

        }
    }
    public void azul(View v){
        if(aux==true){
            boton3.seekTo(0);
            if(!boton3.isPlaying()){
                boton3.start();
            }
            num=3;
            procezar(num);

        }}
    public void amarillo(View v){
        if(aux==true){
            boton4.seekTo(0);
            if(!boton4.isPlaying()){
                boton4.start();
            }
            num=4;
            procezar(num);

        }
    }
    public void procezar(int num){
            num2=arreglo[pos2];
            pos2++;
            if(num2!=num) {
                aux = false;
                activity3();


            }else{

                    if(arreglo[pos2]==0){
                        botonverde.setBackgroundColor(getResources().getColor(R.color.verdeoscuro));
                        botonrojo.setBackgroundColor(getResources().getColor(R.color.rojoOscuro));
                        botonazul.setBackgroundColor(getResources().getColor(R.color.azuloscuro));
                        botonamarillo.setBackgroundColor(getResources().getColor(R.color.amarillooscuro));
                        aux=false;
                        cont++;
                        texto.setText(String.valueOf(cont));
                        if(dificultad==1){
                            total=total+1400;
                        }else{
                            if(dificultad==2){
                                total=total+1000;
                            }else{
                                if(dificultad==3){
                                    if(divi!=100){
                                    divi=divi-20;
                                    total=divi*por;
                                    por=por+2;}else{
                                        total=total+(divi*2);
                                    }


                                }
                            }
                        }



                        comenzar();


                }
        }
    }

    public void activity3(){
        Intent i= new Intent(this,Main3Activity.class);
        i.putExtra("dato",cont);
        SharedPreferences preferencias= getPreferences(MODE_PRIVATE);
        if(dificultad==1){
            int info=preferencias.getInt("facil",0);
            if(info<cont){
                SharedPreferences.Editor editor=preferencias.edit();
                editor.putInt("facil",cont);
                editor.commit();
                i.putExtra("dificultad",1);
            }else{i.putExtra("dificultad",0);}

        }else{
            if(dificultad==2){
                int info=preferencias.getInt("normal",0);
                if(info<cont){
                    SharedPreferences.Editor editor=preferencias.edit();
                    editor.putInt("normal",cont);
                    editor.commit();
                    i.putExtra("dificultad",2);
                }else{i.putExtra("dificultad",0);}

            }else{
                int info=preferencias.getInt("dificil",0);
                if(info<cont){
                    SharedPreferences.Editor editor=preferencias.edit();
                    editor.putInt("dificil",cont);
                    editor.commit();
                    i.putExtra("dificultad",3);
                }else{i.putExtra("dificultad",0);}



        }}
        startActivity(i);
        this.finish();
    }
    @Override
    protected void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        outState.putInt("adificultad",dificultad);
        outState.putInt("atotal",total);
        outState.putInt("adivi",divi);
        outState.putInt("acont",cont);
        outState.putInt("apos",pos);
        outState.putInt("apos2",pos2);
        outState.putInt("acant",cant);
        outState.putInt("apor",por);
        outState.putBoolean("aaux",aux);
        outState.putIntArray("aarreglo",arreglo);
        outState.putInt("anum",num);
        outState.putInt("anum2",num2);

    }
    @Override
    protected void onRestoreInstanceState(Bundle saveInstaceState){
        super.onRestoreInstanceState(saveInstaceState);
        dificultad=saveInstaceState.getInt("adificultad");
        total=saveInstaceState.getInt("atotal");
        divi=saveInstaceState.getInt("adivi");
        cont=saveInstaceState.getInt("acont");
        texto.setText(String.valueOf(cont));
        pos=saveInstaceState.getInt("apos");
        pos2=saveInstaceState.getInt("apos2");
        cant=saveInstaceState.getInt("acant");
        por=saveInstaceState.getInt("apor");
        aux=saveInstaceState.getBoolean("aaux");
        arreglo=saveInstaceState.getIntArray("aarreglo");
        num=saveInstaceState.getInt("anum");
        num2=saveInstaceState.getInt("anum2");


    }


    public void facil(){
        Intent i= new Intent(this,Main2Activity.class);
        i.putExtra("dato",1);
        this.finish();
        startActivity(i);
    }
    public void normal(){
        Intent i= new Intent(this,Main2Activity.class);
        i.putExtra("dato",2);
        this.finish();
        startActivity(i);

    }
    public void dificil(){
        Intent i= new Intent(this,Main2Activity.class);
        i.putExtra("dato",3);
        this.finish();
        startActivity(i);
    }

    public void puntages(){
        SharedPreferences preferencias=getPreferences(MODE_PRIVATE);
        int dato1=preferencias.getInt("facil",0);
        int dato2=preferencias.getInt("normal",0);
        int dato3=preferencias.getInt("dificil",0);
        Intent i= new Intent(this,Main4Activity.class);
        i.putExtra("dato1",dato1);
        i.putExtra("dato2",dato2);
        i.putExtra("dato3",dato3);
        startActivity(i);
        this.finish();

    }








    }



