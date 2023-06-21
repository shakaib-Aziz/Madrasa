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

    private Intent intent;
    Button btnSave, btnSearch, btnGit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSave = findViewById(R.id.btn_save);
        btnSearch = findViewById(R.id.btn_search);
        btnGit = findViewById(R.id.btn_git);
    }

    public void menu(View v) {
        int id = v.getId();
        if (id == R.id.btn_save) {
            intent=new Intent(MainActivity.this,SaveStudentActivity.class);
            startActivity(intent);
        } else if (id==R.id.btn_displayDB) {
            intent=new Intent(MainActivity.this,DisplayDB.class);
            startActivity(intent);

        } else if (id == R.id.btn_search) {
            intent=new Intent(MainActivity.this,SearchStudentData.class);
            startActivity(intent);
        } else {
            String githubUrl = "https://github.com/S-H-A-B-B-Y/Madrasa";
            intent = new Intent(Intent.ACTION_VIEW, Uri.parse(githubUrl));
            startActivity(intent);
        }
    }
}