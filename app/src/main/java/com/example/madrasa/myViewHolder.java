package com.example.madrasa;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class myViewHolder extends RecyclerView.ViewHolder {

    TextView name,age,s_class,sabaq,sabaqi,manzil;

    public myViewHolder( View itemView) {
        super(itemView);

        name=itemView.findViewById(R.id.tv_name_rv);
        age=itemView.findViewById(R.id.tv_age_rv);
        s_class=itemView.findViewById(R.id.tv_class_rv);
        sabaq=itemView.findViewById(R.id.tv_sabaq_rv);
        sabaqi=itemView.findViewById(R.id.tv_sabaqi_rv);
        manzil=itemView.findViewById(R.id.tv_manzil_rv);

    }
}
