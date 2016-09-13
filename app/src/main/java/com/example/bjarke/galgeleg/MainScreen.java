package com.example.bjarke.galgeleg;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import logik.*;

public class MainScreen extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);
        Button startButton = (Button) findViewById(R.id.startButton);
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
    }
    public void StartGame(){
        Intent intent = new Intent(this, StartScreen.class);
        startActivity(intent);
    }
    public void Help(){
        Intent intent = new Intent(this, Help.class);
        startActivity(intent);
    }
    public void About(){
        Intent intent = new Intent(this, About.class);
        startActivity(intent);
    }
    public void HighScore(){
        Intent intent = new Intent(this, Highscore.class);
        startActivity(intent);
    }
}
