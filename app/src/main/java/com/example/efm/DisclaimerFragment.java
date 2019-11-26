package com.example.efm;

import android.content.res.AssetManager;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.io.IOException;

public class DisclaimerFragment extends Fragment {


    TextView titleTv,textTv;
    AssetManager assetManager;
    FileInput fileInput;
    String disclaimerText;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

       View v = inflater.inflate(R.layout.disclaimer_fragment, container, false);
        assetManager = v.getContext().getAssets();
        textTv = v.findViewById(R.id.disclaimerMessageTv);
        fileInput = new FileInput();
        try {
            disclaimerText =fileInput.FileInputText(v.getContext(), "Disclaimer");


            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                textTv.setText(Html.fromHtml(disclaimerText));
            } else {
                textTv.setText(Html.fromHtml( disclaimerText));
            }




        } catch (IOException e) {
            e.printStackTrace();
        }


        return v;



    }
}
