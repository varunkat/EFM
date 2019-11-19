package com.example.efm;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class DescAdapter extends ArrayAdapter<String> {

    String desc [];
    int image;
    Context context;





    public DescAdapter(@NonNull Context context, int image, String desc[]) {
        super(context,R.layout.row,R.id.descTV,desc);
        this.context = context;
        this.image = image;
        this.desc = desc;

    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater layoutInflater = (LayoutInflater) context.getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = layoutInflater.inflate(R.layout.row,parent,false);


        ImageView imageView = view.findViewById(R.id.imagecam);
        TextView descTV = view.findViewById(R.id.descTV);

        imageView.setImageResource(image);
        descTV.setText(desc[position]);


        return view;
    }
}
