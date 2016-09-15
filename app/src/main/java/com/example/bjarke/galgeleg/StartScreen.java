package com.example.bjarke.galgeleg;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import logik.GalgeLogik;

public class StartScreen extends AppCompatActivity {
    GalgeLogik logik = new GalgeLogik();
    Drawable images[];
    ImageView galge;
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_screen);
        galge = (ImageView) findViewById(R.id.imageView);
        tv = (TextView) findViewById(R.id.wordGuess);
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
        Button letterButton = (Button) findViewById(R.id.letterButton);
        letterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GuessLetter();
            }
        });
        Button wordButton = (Button) findViewById(R.id.wordButton);
        wordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GuessWord();
            }
        });
    }
    public void GuessLetter(){
        EditText letter = (EditText) findViewById(R.id.guessLetter);
        logik.gætBogstav(letter.getText().toString());
        TextView usedLetters = (TextView) findViewById(R.id.usedLetters);
        String used ="";
        for(int i=0;i>logik.getBrugteBogstaver().size();i++){
            if(i==0){
                used = logik.getBrugteBogstaver().get(i);
            } else {
                used = used + ", "+logik.getBrugteBogstaver().get(i);
            }
        }
        usedLetters.setText(logik.getBrugteBogstaver().toString());
        if(logik.erSpilletTabt()){
            Intent lost = new Intent(this, Lost.class);
            startActivity(lost);
            finish();
        } else if(logik.erSpilletVundet()){
            Intent win = new Intent(this, Win.class);
            startActivity(win);
            finish();
        }
        else {
            galge.setImageDrawable(images[logik.getAntalForkerteBogstaver()]);
            tv.setText(logik.getSynligtOrd());
            letter.setText("");
            letter.setHint("Gæt et bogstav");
        }
    }

    public void GuessWord(){
        EditText word = (EditText) findViewById(R.id.guessWord);
        if(logik.GætOrdet(word.getText().toString())){
            Intent win = new Intent(this, Win.class);
            startActivity(win);
            finish();
        } else {
            galge.setImageDrawable(images[logik.getAntalForkerteBogstaver()]);
            if(logik.erSpilletTabt()){
                Intent lost = new Intent(this, Lost.class);
                startActivity(lost);
                finish();
            }
        }
    }
    public void CheckLoss(){
        if(logik.erSpilletTabt()){
            Intent lost = new Intent(this, Lost.class);
            startActivity(lost);
            finish();
        }
    }
}
