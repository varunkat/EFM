package com.example.efm;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.github.chrisbanes.photoview.PhotoView;

import java.io.IOException;

public class listContentFragment extends Fragment {

private String fileName;
String contentList;
TextView contentTV;
FileInput fileInput;
Button managementBut,imageBut;
String title;

    PhotoView imageviewBox;
    int image;
    listContentFragment(String fileName, int image, String title) {
        this.fileName = fileName;
        this.image = image;
        this.title = title;
    }

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.text_firstbutton_list, container, false);
        contentTV = view.findViewById(R.id.listTextView);
        managementBut = view.findViewById(R.id.managementButton);
        imageBut = view.findViewById(R.id.imageButton);

        managementBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HomeThirdDefinitionFragment thirdList = new HomeThirdDefinitionFragment();
                replaceFragment(thirdList);
            }
        });

        imageBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                        if(image !=0 && image != R.drawable.ic_camera_alt_black_24dp) {

                            imageviewBox = new PhotoView(view.getContext());

                            imageviewBox.setImageResource(image);
                            //imageviewBox.setScaleType(ImageView.ScaleType.MATRIX);
                            imageviewBox.setZoomable(true);
                            AlertDialog.Builder builder =
                                    new AlertDialog.Builder(view.getContext()).
                                            setMessage(title).
                                            setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                                @Override
                                                public void onClick(DialogInterface dialog, int which) {
                                                    dialog.dismiss();
                                                }
                                            }).
                                            setView(imageviewBox);
                            builder.create().show();
                        }
                        else
                            Toast.makeText(view.getContext(),"No Image",Toast.LENGTH_SHORT).show();

                }












        });





        fileInput= new FileInput();
        try {
            contentList = fileInput.FileInputText(view.getContext(),fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            contentTV.setText(Html.fromHtml(contentList));
        } else {
            contentTV.setText(Html.fromHtml( contentList));
        }

        return view;

    }


    public void replaceFragment(Fragment someFragment) {
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, someFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

}
