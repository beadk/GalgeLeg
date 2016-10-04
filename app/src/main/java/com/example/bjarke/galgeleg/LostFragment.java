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
import android.widget.ImageView;

import logik.GalgeLogik;


public class LostFragment extends Fragment {
    GalgeLogik logik = MainScreen.logik;
    public LostFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View inf = inflater.inflate(R.layout.fragment_lost, container, false);
        if(!MainScreen.logik.getIsIni()){
            MainScreen.IniLogik();
            logik = MainScreen.logik;
        }
        ImageView lost = (ImageView) inf.findViewById(R.id.imageView2);
        lost.setImageDrawable(getResources().getDrawable(R.drawable.gameover));
        Button toStart = (Button) inf.findViewById(R.id.toStartButton);
        toStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ToStart();
            }
        });
        SharedPreferences prefs = MainScreen.prefs;
        prefs.edit().putInt("lost",prefs.getInt("lost",0)+1).commit();
        return inf;
    }
    public void ToStart(){
        logik.nulstil();
        Fragment fragment = new MainFragment();
        getFragmentManager().beginTransaction().replace(R.id.fragmentindhold,fragment).commit();
    }
}
