package com.example.efm;

import android.content.res.AssetManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.io.IOException;
import java.io.InputStream;

public class DisclaimerFragment extends Fragment {


    TextView titleTv,textTv;
    AssetManager assetManager;
    FileInput fileInput;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

       View v = inflater.inflate(R.layout.disclaimer_fragment, container, false);
        assetManager = v.getContext().getAssets();
        textTv = v.findViewById(R.id.disclaimerMessageTv);
        fileInput = new FileInput();
        try {
            textTv.setText(fileInput.FileInputText(v.getContext(),"Disclaimer"));


        } catch (IOException e) {
            e.printStackTrace();
        }


        return v;



    }
}
