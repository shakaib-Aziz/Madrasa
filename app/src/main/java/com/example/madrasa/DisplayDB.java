package com.example.madrasa;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.List;

public class DisplayDB extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    LinearLayoutManager linearLayoutManager;
    List<Student> students;
    DBHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_db);

        db=new DBHelper(this);
        students=(List<Student>) db.showAllStudents();

        recyclerView=findViewById(R.id.recyclerView_DB);
        recyclerView.setHasFixedSize(true);
        linearLayoutManager = new LinearLayoutManager(DisplayDB.this);
        recyclerView.setLayoutManager(linearLayoutManager);

        adapter = new MyAdapter(getApplicationContext(),students);
        recyclerView.setAdapter(adapter);

    }
}