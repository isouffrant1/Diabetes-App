package com.example.diabeteshealthapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class FoodListview extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_listview);

        listView = findViewById(R.id.listView);

        ArrayList<CustomListView> arrayList = new ArrayList<>();

        arrayList.add(new CustomListView(R.drawable.apple, "Apple", "Gain nutrients without impacting blood sugar levels."));
        arrayList.add(new CustomListView(R.drawable.apricot, "Apricot", "Abundant in vitamin A and fiber"));
        arrayList.add(new CustomListView(R.drawable.berries, "Berries", "Jampacked with antioxidants and fiber."));
        arrayList.add(new CustomListView(R.drawable.orange, "Orange", "Micronutrients that help regulate blood pressure."));
        arrayList.add(new CustomListView(R.drawable.kiwi, "Kiwi", "Best Fruits For Type 1 And Type 2 Diabetes"));
        arrayList.add(new CustomListView(R.drawable.peaches, "Peaches", "Nutrition Rich Fruits For Diabetes"));
        arrayList.add(new CustomListView(R.drawable.pear, "Pear", "Measure low on the Glycemic Index "));
        arrayList.add(new CustomListView(R.drawable.banana, "Banana", "Energy-Rich Fruits For Diabetes"));

        CustomBaseAdapter customAdapter = new CustomBaseAdapter(this, R.layout.list_row,arrayList);

        listView.setAdapter(customAdapter);

    }
}