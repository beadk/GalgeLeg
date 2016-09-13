package com.example.bjarke.galgeleg;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

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
    }
    public void ToStart(){
        Intent intent = new Intent(this, MainScreen.class);
        startActivity(intent);
    }
}
