package com.example.madrasa;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    //  private DBHelper dbHelper;

    Button btnSave, btnDailyTasks, btnSearch, btnGit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //    dbHelper = new DBHelper(this);

        btnSave = findViewById(R.id.btn_save);
        btnDailyTasks = findViewById(R.id.btn_save_dailytasks);
        btnSearch = findViewById(R.id.btn_search);
        btnGit = findViewById(R.id.btn_git);

    }

    public void menu(View v) {
        int id = v.getId();
        if (id == R.id.btn_save) {
            Intent intent1=new Intent(MainActivity.this,SaveStudentActivity.class);
            startActivity(intent1);
        } else if (id == R.id.btn_save_dailytasks) {
            Intent intent2=new Intent(MainActivity.this,SaveDailyTasks.class);
            startActivity(intent2);
        } else if (id == R.id.btn_search) {
            //showSearchForm();
           // setContentView(R.layout.activity_save_student);
        } else {
            String githubUrl = "https://github.com/S-H-A-B-B-Y/Madrasa";
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(githubUrl));
            startActivity(intent);
        }
        setContentView(R.layout.activity_main);
    }
}

  /*  private void showSaveForm() {
        setContentView(R.layout.activity_save_student);

        EditText etName = findViewById(R.id.et_name);
        EditText etAge = findViewById(R.id.et_age);
        EditText etClass = findViewById(R.id.et_class);
        Button btnSaveStudent = findViewById(R.id.btn_save_st);

        btnSaveStudent.setOnClickListener(v -> {
            String name = etName.getText().toString().trim();
            int age = Integer.parseInt(etAge.getText().toString().trim());
            String studentClass = etClass.getText().toString().trim();
            int manzil = 1; // Set the initial Manzil to 1

          //  Student student = new Student(0, name, age, studentClass, sabaq, sabaqi, manzil);
          //  dbHelper.saveStudent(student);

            Toast.makeText(MainActivity.this, "Student saved successfully", Toast.LENGTH_SHORT).show();

            etName.setText("");
            etAge.setText("");
            etClass.setText("");
        });
    }
    private void showDTForm() {
        setContentView(R.layout.activity_save_dailytask);

        EditText etSabaq = findViewById(R.id.et_sabaq);
        EditText etSabaqi = findViewById(R.id.et_sabaqi);
        EditText etManzil = findViewById(R.id.et_manzil);
        Button btnSaveDT = findViewById(R.id.btn_save_dt);

          btnSaveStudent.setOnClickListener(v -> {
            String name = etName.getText().toString().trim();
            int age = Integer.parseInt(etAge.getText().toString().trim());
            String studentClass = etClass.getText().toString().trim();
            int manzil = 1; // Set the initial Manzil to 1

            //  Student student = new Student(0, name, age, studentClass, sabaq, sabaqi, manzil);
            //  dbHelper.saveStudent(student);

            Toast.makeText(MainActivity.this, "Student saved successfully", Toast.LENGTH_SHORT).show();

            etName.setText("");
            etAge.setText("");
            etClass.setText("");

        });
    }

    private void showSearchForm() {
        setContentView(R.layout.activity_save_dailytask);

     /*   EditText etSearchQuery = findViewById(R.id.et_search_query);
        Button btnSearchStudents = findViewById(R.id.btn_search_students);

        btnSearchStudents.setOnClickListener(v -> {
            String searchQuery = etSearchQuery.getText().toString().trim();
            ArrayList<Student> searchResults = dbHelper.searchStudents(searchQuery);

            Intent intent = new Intent(MainActivity.this, SearchResultActivity.class);
            intent.putParcelableArrayListExtra("searchResults", searchResults);
            startActivity(intent);
        });
    }
*/