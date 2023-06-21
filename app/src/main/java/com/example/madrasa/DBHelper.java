package com.example.madrasa;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class DBHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "students.db";
    private static final String TABLE_NAME = "students";

    private static final String COLUMN_ID = "id";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_Age = "age";
    private static final String COLUMN_Class = "class";
    private static final String COLUMN_Sabaq = "sabaq";
    private static final String COLUMN_Sabaqi = "sabaqi";
    private static final String COLUMN_Manzil = "manzil";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + "("
                + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + COLUMN_NAME + " TEXT,"
                + COLUMN_Age + " INTEGER,"
                + COLUMN_Class + " TEXT,"
                + COLUMN_Sabaq + " TEXT,"
                + COLUMN_Sabaqi + " TEXT ,"
                + COLUMN_Manzil + " INTEGER"
                + ")";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "DROP TABLE IF EXISTS " + TABLE_NAME;
        db.execSQL(sql);
        onCreate(db);
    }


    public void addStudent(Student student) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, student.getName());
        values.put(COLUMN_Age, student.getAge());
        values.put(COLUMN_Class, student.getS_Class());
        values.put(COLUMN_Sabaq, student.getSabaq());
        values.put(COLUMN_Sabaqi, student.getSabaqi());
        values.put(COLUMN_Manzil, student.getManzil());

        db.insert(TABLE_NAME, null, values);
        db.close();

    }
    public List<Student> searchStudent(String Name) {

        List<Student> students = new ArrayList<>();

        SQLiteDatabase db = this.getWritableDatabase();
        String sql = "SELECT * FROM " + TABLE_NAME + " WHERE name=? ";
        String[] selectionArgs = {Name}; // Provide the value for the search criteria

        Cursor cursor = db.rawQuery(sql, selectionArgs);

        if (cursor != null && cursor.moveToFirst()) {
            do {
                @SuppressLint("Range") int id = cursor.getInt(cursor.getColumnIndex(COLUMN_ID));
                @SuppressLint("Range") String name = cursor.getString(cursor.getColumnIndex(COLUMN_NAME));
                @SuppressLint("Range") String age = cursor.getString(cursor.getColumnIndex(COLUMN_Age));
                @SuppressLint("Range") String S_class = cursor.getString(cursor.getColumnIndex(COLUMN_Class));
                @SuppressLint("Range") String sabaq = cursor.getString(cursor.getColumnIndex(COLUMN_Sabaq));
                @SuppressLint("Range") String sabaqi = cursor.getString(cursor.getColumnIndex(COLUMN_Sabaqi));
                @SuppressLint("Range") String manzil = cursor.getString(cursor.getColumnIndex(COLUMN_Manzil));

                students.add(new Student(name, age, S_class,sabaq,sabaqi,manzil));
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();

        return students;
    }

    public List<Student> showAllStudents() {

        List<Student> students = new ArrayList<>();

        String sql = "SELECT * FROM " + TABLE_NAME;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(sql, null);

        if (cursor.moveToFirst()) {
            do {
                @SuppressLint("Range") int id = cursor.getInt(cursor.getColumnIndex(COLUMN_ID));
                @SuppressLint("Range") String name = cursor.getString(cursor.getColumnIndex(COLUMN_NAME));
                @SuppressLint("Range") String age = cursor.getString(cursor.getColumnIndex(COLUMN_Age));
                @SuppressLint("Range") String S_class = cursor.getString(cursor.getColumnIndex(COLUMN_Class));
                @SuppressLint("Range") String sabaq = cursor.getString(cursor.getColumnIndex(COLUMN_Sabaq));
                @SuppressLint("Range") String sabaqi = cursor.getString(cursor.getColumnIndex(COLUMN_Sabaqi));
                @SuppressLint("Range") String manzil = cursor.getString(cursor.getColumnIndex(COLUMN_Manzil));

                students.add(new Student(name, age, S_class,sabaq,sabaqi,manzil));
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();

        return students;
    }
}