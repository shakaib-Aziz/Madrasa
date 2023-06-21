package com.example.madrasa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class SaveStudentActivity extends AppCompatActivity {

    TextView etname,etage,etclass,etsabaq,etsabaqi,etmanzil;;
    Button btn_save_st;
    Student student;
    DBHelper dataBase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save_students);

        etname=findViewById(R.id.et_name);
        etage=findViewById(R.id.et_age);
        etclass=findViewById(R.id.et_class);
        etsabaq=findViewById(R.id.et_sabaq);
        etsabaqi=findViewById(R.id.et_sabaqi);
        etmanzil=findViewById(R.id.et_manzil);

        dataBase=new DBHelper(this);
        btn_save_st=findViewById(R.id.btn_save_st);

        btn_save_st.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name=etname.getText().toString();
                String age=etage.getText().toString();
                String s_class=etclass.getText().toString();
                String sabaq=etsabaq.getText().toString();
                String sabaqi=etsabaqi.getText().toString();
                String manzil=etmanzil.getText().toString();

                student=new Student(name,age,s_class,sabaq,sabaqi,manzil);
                dataBase.addStudent(student);
                Toast.makeText(SaveStudentActivity.this,"Student with daily task recorded successfully!",Toast.LENGTH_LONG).show();

                etname.setText("");
                etage.setText("");
                etclass.setText("");
                etsabaq.setText("");
                etsabaqi.setText("");
                etmanzil.setText("");
            }
        });

    }
}