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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;

import logik.*;

public class MainScreen extends AppCompatActivity  implements AdapterView.OnItemClickListener {
    public static GalgeLogik logik = new GalgeLogik();
    public static SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);
        if(logik.getIsIni()) {
            IniLogik();
        }

        prefs = PreferenceManager.getDefaultSharedPreferences(this);

        if (savedInstanceState == null) {
            Fragment fragment = new MainFragment();
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragmentindhold, fragment) // tom container i layout
                    .commit();
        }

    }



    static public void IniLogik(){
        logik = new GalgeLogik();
        logik.setIsIni(true);
    }

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
        super.onCreateOptionsMenu(menu);
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

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

    }
}
