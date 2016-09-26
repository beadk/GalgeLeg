package com.example.bjarke.galgeleg;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import logik.GalgeLogik;


public class StartFragment extends Fragment {
    GalgeLogik logik = MainScreen.logik;
    Drawable images[];
    ImageView galge;
    TextView tv;
    View inf;
    static int highscore;

    public StartFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        inf = inflater.inflate(R.layout.fragment_start, container, false);
        galge = (ImageView) inf.findViewById(R.id.imageView);
        tv = (TextView) inf.findViewById(R.id.wordGuess);
        images = new Drawable[]{
                getResources().getDrawable(R.drawable.forkert6),
                getResources().getDrawable(R.drawable.forkert5),
                getResources().getDrawable(R.drawable.forkert4),
                getResources().getDrawable(R.drawable.forkert3),
                getResources().getDrawable(R.drawable.forkert2),
                getResources().getDrawable(R.drawable.forkert1),
                getResources().getDrawable(R.drawable.galge)
        };
        tv.setText(logik.getSynligtOrd());
        galge.setImageDrawable(images[logik.getAntalForkerteBogstaver()]);
        TextView usedLetters = (TextView) inf.findViewById(R.id.usedLetters);
        String used = "";
        for (int i = 0; i > logik.getBrugteBogstaver().size(); i++) {
            if (i == 0) {
                used = logik.getBrugteBogstaver().get(i);
            } else {
                used = used + ", " + logik.getBrugteBogstaver().get(i);
            }
        }
        usedLetters.setText(logik.getBrugteBogstaver().toString());
        Button letterButton = (Button) inf.findViewById(R.id.letterButton);
        letterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GuessLetter();
            }
        });
        Button wordButton = (Button) inf.findViewById(R.id.wordButton);
        wordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GuessWord();
            }
        });
        return inf;
    }
    public void GuessLetter() {
        EditText letter = (EditText) inf.findViewById(R.id.guessLetter);
        logik.gætBogstav(letter.getText().toString());
        TextView usedLetters = (TextView) inf.findViewById(R.id.usedLetters);
        String used = "";
        for (int i = 0; i > logik.getBrugteBogstaver().size(); i++) {
            if (i == 0) {
                used = logik.getBrugteBogstaver().get(i);
            } else {
                used = used + ", " + logik.getBrugteBogstaver().get(i);
            }
        }
        usedLetters.setText(logik.getBrugteBogstaver().toString());
        if (logik.erSpilletTabt()) {
            Fragment fragment = new LostFragment();
            getFragmentManager().beginTransaction().replace(R.id.fragmentindhold,fragment).commit();
        } else if (logik.erSpilletVundet()) {
            highscore = logik.getBrugteBogstaver().size();
            Fragment fragment = new WinFragment();
            getFragmentManager().beginTransaction().replace(R.id.fragmentindhold,fragment).commit();
        } else {
            galge.setImageDrawable(images[logik.getAntalForkerteBogstaver()]);
            tv.setText(logik.getSynligtOrd());
            letter.setText("");
            letter.setHint("Gæt et bogstav");
        }
    }

    public void GuessWord() {
        EditText word = (EditText) inf.findViewById(R.id.guessWord);
        if (logik.GætOrdet(word.getText().toString())) {
            highscore = logik.getBrugteBogstaver().size();
            Fragment fragment = new WinFragment();
            getFragmentManager().beginTransaction().replace(R.id.fragmentindhold,fragment).commit();
        } else {
            galge.setImageDrawable(images[logik.getAntalForkerteBogstaver()]);
            if (logik.erSpilletTabt()) {
                Fragment fragment = new LostFragment();
                getFragmentManager().beginTransaction().replace(R.id.fragmentindhold,fragment).commit();
            }
        }
    }

}
