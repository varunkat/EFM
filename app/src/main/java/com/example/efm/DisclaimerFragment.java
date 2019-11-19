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

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

       View v = inflater.inflate(R.layout.disclaimer_fragment, container, false);
        assetManager = v.getContext().getAssets();
        textTv = v.findViewById(R.id.disclaimerMessageTv);


        // To load text file
        InputStream input;
        try {
            input = assetManager.open("Disclaimer");

            int size = input.available();
            byte[] buffer = new byte[size];
            input.read(buffer);
            input.close();

            // byte buffer into a string
            String tex = new String(buffer);

            textTv.setText(tex);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }



        //textTv.setText(text);

        return v;



    }
}
