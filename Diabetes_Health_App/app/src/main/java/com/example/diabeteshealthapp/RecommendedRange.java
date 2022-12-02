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

public class RecommendedRange extends AppCompatActivity {

    private EditText rrFromEdt, rrToEdt;
    private Button recordSave;
    private DBHelper dbHelper;
    private TextView tv_recommendedRange;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recommended_range);


        // initializing all our variables.
        rrFromEdt = findViewById(R.id.editTextNumber2);
        rrToEdt = findViewById(R.id.editTextNumber3);
        //courseDurationEdt = findViewById(R.id.idEdtCourseDuration);
        //courseDescriptionEdt = findViewById(R.id.idEdtCourseDescription);
        recordSave = findViewById(R.id.button11);

        tv_recommendedRange = findViewById(R.id.textView10);

        // creating a new dbhandler class
        // and passing our context to it.
        dbHelper = new DBHelper(RecommendedRange.this);

        // below line is to add on click listener for our add course button.
        recordSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // below line is to get data from all edit text fields.
                String fromRange = rrFromEdt.getText().toString();
                String toRange = rrToEdt.getText().toString();
                // String courseDuration = courseDurationEdt.getText().toString();
                // String courseDescription = courseDescriptionEdt.getText().toString();

                // validating if the text fields are empty or not.
                if (fromRange.isEmpty() && toRange.isEmpty()) {
                    Toast.makeText(RecommendedRange.this, "Please enter all the data..", Toast.LENGTH_SHORT).show();
                    return;
                }

                // on below line we are calling a method to add new
                // course to sqlite data and pass all our values to it.
                dbHelper.addRecommendedRange(fromRange, toRange);

                // after adding the data we are displaying a toast message.
                Toast.makeText(RecommendedRange.this, "Data has been added.", Toast.LENGTH_SHORT).show();
                rrFromEdt.setText("");
                rrToEdt.setText("");
                // courseTracksEdt.setText("");
                // courseDescriptionEdt.setText("");

                String gl = "You have entered recommended range from" + " " + fromRange + " " + "to" + " " + toRange + "mg/dL"+".";

                tv_recommendedRange.setText(gl);
                tv_recommendedRange.setVisibility(View.VISIBLE);
            }
        });


        Button homeButton = findViewById(R.id.button14);
        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMainActivity();
            }
        });

        Button trackHistoryButton = findViewById(R.id.button8);
        trackHistoryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor res = dbHelper.getdata();
                if (res.getCount() == 0) {
                    Toast.makeText(RecommendedRange.this, "No Entry Exists", Toast.LENGTH_SHORT).show();
                    return;
                }
                StringBuffer buffer = new StringBuffer();
                while (res.moveToNext()) {
                    buffer.append("ID:" + res.getString(0) + "\n");
                    buffer.append("From:" + res.getString(1) + " " + "mg/dL" + " ");
                    buffer.append("To:" + res.getString(2) + " " +"mg/dL" +"\n\n");
                }
                AlertDialog.Builder builder = new AlertDialog.Builder(RecommendedRange.this);
                builder.setCancelable(true);
                builder.setTitle("Recommended Glucose Range (mg/dL)");
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
        RecommendedRange.this.finish();
        System.exit(1);
    }
}