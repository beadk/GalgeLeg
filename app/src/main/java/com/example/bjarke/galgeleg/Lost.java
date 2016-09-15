package com.example.bjarke.galgeleg;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Lost extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lost);
        ImageView win = (ImageView) findViewById(R.id.imageView2);
        win.setImageDrawable(getResources().getDrawable(R.drawable.gameover));
        Button toStart = (Button) findViewById(R.id.toStartButton);
        toStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ToStart();
            }
        });
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
