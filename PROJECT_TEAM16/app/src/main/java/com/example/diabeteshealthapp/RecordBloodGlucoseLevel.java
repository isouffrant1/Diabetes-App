package com.example.diabeteshealthapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RecordBloodGlucoseLevel extends AppCompatActivity {

    private EditText glucoseLevelEdt, glucoseDateEdt;
    private Button recordSave;
    private DBHandler dbHandler;
    private TextView tv_glucose;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record_blood_glucose_level);

        // initializing all our variables.
        glucoseLevelEdt = findViewById(R.id.editTextNumber);
        glucoseDateEdt = findViewById(R.id.editTextDate3);
        //courseDurationEdt = findViewById(R.id.idEdtCourseDuration);
        //courseDescriptionEdt = findViewById(R.id.idEdtCourseDescription);
        recordSave = findViewById(R.id.button);

        tv_glucose = findViewById(R.id.textView3);

        // creating a new dbhandler class
        // and passing our context to it.
        dbHandler = new DBHandler(RecordBloodGlucoseLevel.this);

        // below line is to add on click listener for our add course button.
        recordSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // below line is to get data from all edit text fields.
                String glucoseLevel = glucoseLevelEdt.getText().toString();
                String glucoseDate = glucoseDateEdt.getText().toString();
               // String courseDuration = courseDurationEdt.getText().toString();
               // String courseDescription = courseDescriptionEdt.getText().toString();

                // validating if the text fields are empty or not.
                if (glucoseLevel.isEmpty() && glucoseDate.isEmpty()) {
                    Toast.makeText(RecordBloodGlucoseLevel.this, "Please enter all the data..", Toast.LENGTH_SHORT).show();
                    return;
                }

                // on below line we are calling a method to add new
                // course to sqlite data and pass all our values to it.
                dbHandler.addGlucoseLevel(glucoseLevel, glucoseDate);

                // after adding the data we are displaying a toast message.
                Toast.makeText(RecordBloodGlucoseLevel.this, "Data has been added.", Toast.LENGTH_SHORT).show();
                glucoseLevelEdt.setText("");
                glucoseDateEdt.setText("");
               // courseTracksEdt.setText("");
               // courseDescriptionEdt.setText("");

                String gl = "You have entered:"+ " "+ glucoseLevel + " " + "mg/dL";

                tv_glucose.setText(gl);
                tv_glucose. setVisibility(View. VISIBLE);
            }
        });

        Button homeButton = findViewById(R.id.button12);
        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMainActivity();
            }
        });

        Button trackHistoryButton = findViewById(R.id.button16);
        trackHistoryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor res = dbHandler.getdata();
                if (res.getCount() == 0) {
                    Toast.makeText(RecordBloodGlucoseLevel.this, "No Entry Exists", Toast.LENGTH_SHORT).show();
                    return;
                }
                StringBuffer buffer = new StringBuffer();
                while (res.moveToNext()) {
                    buffer.append("ID :" + res.getString(0) + "\n");
                    buffer.append("Level :" + res.getString(1) + "\n");
                    buffer.append("Date :" + res.getString(2) + "\n\n");
                }
                AlertDialog.Builder builder = new AlertDialog.Builder(RecordBloodGlucoseLevel.this);
                builder.setCancelable(true);
                builder.setTitle("User Entries");
                builder.setMessage(buffer.toString());
                builder.show();
            }
        });


    }

    public void openMainActivity(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void clickexit(View v){
        moveTaskToBack(true);
        android.os.Process.killProcess(android.os.Process.myPid());
        RecordBloodGlucoseLevel.this.finish();
        System.exit(1);
    }
}

