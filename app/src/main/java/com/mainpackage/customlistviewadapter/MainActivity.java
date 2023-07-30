package com.mainpackage.customlistviewadapter;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Objects;


public class MainActivity extends AppCompatActivity {

    public CustomAdapter adapter;
    ListView listView;
    ArrayList<CoursesModelClass> dataModels;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 1- AdapterView: a listView
        listView = findViewById(R.id.listview);

        // 2- Data source
        dataModels = new ArrayList<>();

        dataModels.add(new CoursesModelClass("Java", R.drawable.java));
        dataModels.add(new CoursesModelClass("Kotlin", R.drawable.kotlin));
        dataModels.add(new CoursesModelClass("Python", R.drawable.python));
        dataModels.add(new CoursesModelClass("C++", R.drawable.c_plusplus));
        dataModels.add(new CoursesModelClass("C", R.drawable.c));
        dataModels.add(new CoursesModelClass("Dart", R.drawable.dart));
        dataModels.add(new CoursesModelClass("Flutter", R.drawable.flutter));


        // 3- Adapter
        adapter = new CustomAdapter(dataModels, getApplicationContext());

        listView.setAdapter(adapter);


        // 4- Handling the click events on Listview items
        listView.setOnItemClickListener((adapterView, view, i, l) -> Toast.makeText(MainActivity.this,
                "Courses " + Objects.requireNonNull(adapter.getItem(i)).getCourseName() + "\n" +
                        "Icon " + Objects.requireNonNull(adapter.getItem(i)).getIconImg(),
                Toast.LENGTH_SHORT).show());


    }


}