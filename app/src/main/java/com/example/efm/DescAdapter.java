package com.example.efm;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.github.chrisbanes.photoview.PhotoView;

public class DescAdapter extends ArrayAdapter<String> {

    String desc [];
    int image [];
    Context context;
    PhotoView imageviewBox;




    public DescAdapter(@NonNull Context context, int image[], String desc[]) {
        super(context,R.layout.row,R.id.descTV,desc);
        this.context = context;
        this.image = image;
        this.desc = desc;

    }


    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater layoutInflater = (LayoutInflater) context.getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        int layout = R.layout.row;
        if (image.length == 0) {
            layout = R.layout.row3;

        }
        View view = layoutInflater.inflate(layout, parent, false);



        TextView descTV = view.findViewById(R.id.descTV);
        if (image.length != 0)
        {
            final ImageView imageView = view.findViewById(R.id.imagecam);
           // imageView.setImageResource(image[position]);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageviewBox = new PhotoView(context);

                imageviewBox.setImageResource(image[position]);

                AlertDialog.Builder builder =
                        new AlertDialog.Builder(context).
                                setMessage(desc[position]).
                                setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.dismiss();
                                    }
                                }).
                                setView(imageviewBox);
                builder.create().show();
            }
        });


    }
        descTV.setText(desc[position]);
        return view;
    }
}
