package com.example.bjarke.galgeleg;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;

import logik.*;

public class MainScreen extends AppCompatActivity {
    static GalgeLogik logik = new GalgeLogik();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);

        if (savedInstanceState == null) {
            Fragment fragment = new MainFragment();
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragmentindhold, fragment) // tom container i layout
                    .commit();
        }


        /*Button startButton = (Button) findViewById(R.id.startButton);
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StartGame();
            }
        });
        Button help = (Button) findViewById(R.id.helpButton);
        help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Help();
            }
        });
        Button about = (Button) findViewById(R.id.aboutButton);
        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                About();
            }
        });
        Button highscore = (Button) findViewById(R.id.highscoreButton);
        highscore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                About();
            }
        });
        Button getWords = (Button) findViewById(R.id.getWordsButton);
        getWords.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GetWords();
            }
        });

        TextView wins = (TextView) findViewById(R.id.wins);
        TextView lost = (TextView) findViewById(R.id.lost);
        wins.setText("Wins: "+prefs.getInt("wins",0));
        lost.setText("Looses: "+prefs.getInt("lost",0));
        */
    }

    /*public void StartGame(){
        Intent intent = new Intent(this, StartScreen.class);
        logik.nulstil();
        startActivity(intent);
    }
    public void GetWords(){
        Toast.makeText(this,"Henter ord fra dr.dk",Toast.LENGTH_LONG).show();
        new AsyncTask(){
            @Override
            protected Object doInBackground(Object[] objects) {
                try {
                    logik.hentOrdFraDr();
                    return "Orderne blev korrekt hentet fra DR's server";
                } catch (Exception e) {
                    e.printStackTrace();
                    return "Orderne blev ikke hentet korrekt" +e;
                }
            }
            @Override
            protected void onPostExecute(Object resultat){
                Toast.makeText(MainScreen.this,resultat.toString(),Toast.LENGTH_LONG).show();
            }
        }.execute();
    }*/
    public void Help(){
        Fragment fragment = new HelpFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentindhold,fragment).commit();
    }
    public void About(){
        Fragment fragment = new AboutFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentindhold,fragment).commit();
    }
    public void HighScore(){
        Fragment fragment = new HighscoreFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentindhold,fragment).commit();
    }
    public void ToStart(){
        Fragment fragment = new MainFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentindhold,fragment).commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu); // tilføj evt standardmenuer
        getMenuInflater().inflate(R.menu.menus, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.about&& !this.getClass().getSimpleName().equals("About")){
            About();
        } else if(item.getItemId() == R.id.help&& !this.getClass().getSimpleName().equals("Help")){
            Help();
        } else if(item.getItemId() == R.id.highscore&& !this.getClass().getSimpleName().equals("Highscore")){
            HighScore();
        } else if(item.getItemId() == R.id.toStart){
            ToStart();
        }
        return false;
    }
}
