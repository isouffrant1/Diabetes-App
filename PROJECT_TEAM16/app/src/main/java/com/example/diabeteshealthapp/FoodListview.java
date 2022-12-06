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
        arrayList.add(new CustomListView(R.drawable.broccoli, "Broccoli", "Helps reduce type 2 diabetes."));
        arrayList.add(new CustomListView(R.drawable.carrot, "Carrot", "Non-starchy vegetable."));
        arrayList.add(new CustomListView(R.drawable.tomato, "Tomato", "Non-starchy vegetable."));
        arrayList.add(new CustomListView(R.drawable.wheat_bread, "Wheat Bread", "Whole grain bread like 100% whole wheat."));
        arrayList.add(new CustomListView(R.drawable.chicken, "Chicken", "Lean meat like chick breast and protein rich."));
        arrayList.add(new CustomListView(R.drawable.eggs, "Eggs", "Low carb and low glycemic index score."));
        arrayList.add(new CustomListView(R.drawable.nuts, "Nuts", "Helps keep blood sugar levels low."));


        CustomBaseAdapter customAdapter = new CustomBaseAdapter(this, R.layout.list_row,arrayList);

        listView.setAdapter(customAdapter);

    }
}