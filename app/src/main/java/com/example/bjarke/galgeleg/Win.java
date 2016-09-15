package com.example.bjarke.galgeleg;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.FileWriter;
import java.io.IOException;

public class Win extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_win);
        ImageView win = (ImageView) findViewById(R.id.imageView3);
        win.setImageDrawable(getResources().getDrawable(R.drawable.wincheer));
        Button toStart = (Button) findViewById(R.id.toStartButton);
        toStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ToStart();
            }
        });
        Button saveScore = (Button) findViewById(R.id.saveScoreButton);
        saveScore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SaveScore();
            }
        });
    }

    public void SaveScore(){
        EditText name = (EditText) findViewById(R.id.nameField);
        try {
            FileWriter writer = new FileWriter(getFilesDir()+"highscore.txt",true);
            writer.write("Navn: "+name + "Tur: "+StartScreen.highscore);

        } catch (IOException e) {
            e.printStackTrace();
        }
        HighScore();
        finish();
    }

    public void ToStart(){
        Intent intent = new Intent(this, MainScreen.class);
        startActivity(intent);
        finish();
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
        } else if(item.getItemId() == R.id.toStart && !this.getClass().getSimpleName().equals("MainScreen")){
            ToStart();
        }
        return false;
    }
}
