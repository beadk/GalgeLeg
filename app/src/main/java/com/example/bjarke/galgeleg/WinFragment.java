package com.example.bjarke.galgeleg;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import java.io.FileWriter;
import java.io.IOException;

import logik.GalgeLogik;


public class WinFragment extends Fragment {
    GalgeLogik logik = MainScreen.logik;
    View inf;
    public WinFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        inf = inflater.inflate(R.layout.fragment_win, container, false);
        ImageView win = (ImageView) inf.findViewById(R.id.imageView3);
        win.setImageDrawable(getResources().getDrawable(R.drawable.wincheer));
        Button toStart = (Button) inf.findViewById(R.id.toStartButton);
        toStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ToStart();
            }
        });
        Button saveScore = (Button) inf.findViewById(R.id.saveScoreButton);
        saveScore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SaveScore();
            }
        });
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this.getActivity());
        prefs.edit().putInt("wins",prefs.getInt("wins",0)+1).commit();


        return inf;
    }
    public void ToStart(){
        logik.nulstil();
        Fragment fragment = new MainFragment();
        getFragmentManager().beginTransaction().replace(R.id.fragmentindhold,fragment).commit();
    }

    public void SaveScore(){
        EditText name = (EditText) inf.findViewById(R.id.nameField);
        /*try {
            FileWriter writer = new FileWriter(this.getFilesDir()+"highscore.txt",true);
            writer.write("Navn: "+name + "Tur: "+StartScreen.highscore);
            logik.nulstil();
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        HighScore();
    }

    public void HighScore(){
        Fragment fragment = new HighscoreFragment();
        getFragmentManager().beginTransaction().replace(R.id.fragmentindhold,fragment).commit();
    }
}
