package com.example.madrasa;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class SearchStudentData extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    List<Student> students;
    DBHelper db;
    TextView name,age;
    Button btn_searchDB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_student_data);

        recyclerView=findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        name=findViewById(R.id.et_name_search);
        age=findViewById(R.id.et_age_search);
        btn_searchDB=findViewById(R.id.btn_searchDB);

        db=new DBHelper(this);

        btn_searchDB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                students=(List<Student>) db.searchStudent(name.getText().toString(), Integer.parseInt(age.getText().toString()));
                adapter=new MyAdapter(getApplicationContext(),students);
                recyclerView.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }
        });

        db.close();
    }
}