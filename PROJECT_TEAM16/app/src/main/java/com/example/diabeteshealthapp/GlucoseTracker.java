package com.example.diabeteshealthapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class GlucoseTracker extends AppCompatActivity {
    private DBHandler dbHandler;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_glucose_tracker);
        Button button = findViewById(R.id.button6);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openRecordBloodGlucoseLevelActivity();
            }
        });

        Button recommendedRangeButton = findViewById(R.id.button7);
        recommendedRangeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openRecommendedRangeActivity();
            }
        });

        Button homeButton = findViewById(R.id.button9);
        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMainActivity();
            }
        });




        /*Button exitButton = findViewById(R.id.button10);
        exitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GlucoseTracker.this.finish();
                System.exit(0);
            }
        }); */
    }
    public void openRecordBloodGlucoseLevelActivity(){
        Intent intent = new Intent(this, RecordBloodGlucoseLevel.class);
        startActivity(intent);
    }

    public void clickexit(View v){
        moveTaskToBack(true);
        android.os.Process.killProcess(android.os.Process.myPid());
        GlucoseTracker.this.finish();
        System.exit(1);
    }

    public void openMainActivity(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void openRecommendedRangeActivity(){
        Intent intent = new Intent(this, RecommendedRange.class);
        startActivity(intent);
    }
}

