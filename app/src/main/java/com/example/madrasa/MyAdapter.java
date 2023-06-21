package com.example.madrasa;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<myViewHolder> {

    Context context;
    List<Student> students;

    public MyAdapter(Context context, List<Student> students) {
        this.context = context;
        this.students = students;
    }

    public myViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new myViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view,parent,false));
    }


    public void onBindViewHolder( myViewHolder holder, int position) {
        holder.name.setText(students.get(position).getName());
        holder.age.setText(students.get(position).getAge());
        holder.s_class.setText(students.get(position).getS_Class());
        holder.sabaq.setText(students.get(position).getSabaq());
        holder.sabaqi.setText(students.get(position).getSabaqi());
        holder.manzil.setText(students.get(position).getManzil());
    }


    public int getItemCount() {
        return students.size();
    }
}
