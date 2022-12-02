package com.example.diabeteshealthapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.button1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGlucoseTrackerActivity();
            }
        });

        Button foodButton = findViewById(R.id.button2);
        foodButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFoodListviewActivity();
            }
        });

        Button notificationButton = findViewById(R.id.button3);
        notificationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAlarmActivity();
            }
        });



       /* Button exitButton = findViewById(R.id.button5);
        exitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.this.finish();
                System.exit(0);
            }
        }); */

    }



    public void openGlucoseTrackerActivity(){
        Intent intent = new Intent(this, GlucoseTracker.class);
        startActivity(intent);
    }

    public void clickexit(View v){
        moveTaskToBack(true);
        android.os.Process.killProcess(android.os.Process.myPid());
        MainActivity.this.finish();
        System.exit(1);
    }

    public void openFoodListviewActivity(){
        Intent intent = new Intent(this, FoodListview.class);
        startActivity(intent);
    }

    public void openAlarmActivity(){
        Intent intent = new Intent(this, Notification.class);
        startActivity(intent);
    }

}

