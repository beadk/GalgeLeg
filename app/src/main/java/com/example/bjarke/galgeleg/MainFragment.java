package com.example.bjarke.galgeleg;


import android.app.Activity;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import logik.GalgeLogik;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {
    GalgeLogik logik;
    public MainFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View inf = inflater.inflate(R.layout.fragment_main, container, false);
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this.getActivity());
        Button startButton = (Button) inf.findViewById(R.id.startButton);
        if(!MainScreen.logik.getIsIni()){
            MainScreen.IniLogik();
        }
        logik = MainScreen.logik;
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StartGame();
            }
        });
        Button help = (Button) inf.findViewById(R.id.helpButton);
        help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Help();
            }
        });
        Button about = (Button) inf.findViewById(R.id.aboutButton);
        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                About();
            }
        });
        Button highscore = (Button) inf.findViewById(R.id.highscoreButton);
        highscore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HighScore();
            }
        });
        Button getWords = (Button) inf.findViewById(R.id.getWordsButton);
        getWords.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GetWords();
            }
        });
        Button choiceWord = (Button) inf.findViewById(R.id.choiceWord);
        choiceWord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ChoiceWord();
            }
        });
        TextView wins = (TextView) inf.findViewById(R.id.wins);
        TextView lost = (TextView) inf.findViewById(R.id.lost);
        wins.setText("Wins: "+prefs.getInt("wins",0));
        lost.setText("Looses: "+prefs.getInt("lost",0));

        return inf;
    }

    public void ChoiceWord(){
        Fragment fragment = new ListFragment();
        getFragmentManager().beginTransaction().replace(R.id.fragmentindhold,fragment).commit();
    }

    public void StartGame(){
        Fragment fragment = new StartFragment();
        getFragmentManager().beginTransaction().replace(R.id.fragmentindhold,fragment).commit();
    }
    public void GetWords(){
        final Activity act = this.getActivity();
        Toast.makeText(act,"Henter ord fra dr.dk",Toast.LENGTH_LONG).show();
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
                Toast.makeText(act,resultat.toString(),Toast.LENGTH_LONG).show();
            }
        }.execute();
    }
    public void Help(){
        Fragment fragment = new HelpFragment();
        getFragmentManager().beginTransaction().replace(R.id.fragmentindhold,fragment).commit();

    }
    public void About(){
        Fragment fragment = new AboutFragment();
        getFragmentManager().beginTransaction().replace(R.id.fragmentindhold,fragment).commit();
    }
    public void HighScore(){
        Fragment fragment = new HighscoreFragment();
        getFragmentManager().beginTransaction().replace(R.id.fragmentindhold,fragment).commit();
    }

}
