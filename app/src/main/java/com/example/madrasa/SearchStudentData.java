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
    LinearLayoutManager linearLayoutManager;
    List<Student> students;
    DBHelper db;
    TextView name;
    Button btn_searchDB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_student_data);

        recyclerView=findViewById(R.id.recyclerView);

        name=findViewById(R.id.et_name_search);
        btn_searchDB=findViewById(R.id.btn_searchDB);

        db=new DBHelper(this);

        btn_searchDB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                students=(List<Student>) db.searchStudent(name.getText().toString());

                recyclerView.setHasFixedSize(true);
                linearLayoutManager = new LinearLayoutManager(SearchStudentData.this);
                recyclerView.setLayoutManager(linearLayoutManager);

                adapter = new MyAdapter(getApplicationContext(),students);
                recyclerView.setAdapter(adapter);
            }
        });

        db.close();
    }
}