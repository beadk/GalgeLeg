package com.example.bjarke.galgeleg;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class HighscoreFragment extends Fragment {


    public HighscoreFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View inf = inflater.inflate(R.layout.fragment_highscore,container,false);
        if(!MainScreen.logik.getIsIni()){
            MainScreen.IniLogik();
        }
        Button toStart = (Button)  inf.findViewById(R.id.toStartButton);
        toStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ToStart();
            }
        });


        return inf;
    }
    public void ToStart(){
        Fragment fragment = new MainFragment();
        getFragmentManager().beginTransaction().replace(R.id.fragmentindhold,fragment).commit();
    }
}
