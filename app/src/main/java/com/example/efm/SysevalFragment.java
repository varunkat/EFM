package com.example.efm;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.io.IOException;

public class SysevalFragment extends Fragment {

    TextView textview;
    FileInput fileInput;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_syseval, container, false);
        textview = view.findViewById(R.id.textView3);

        fileInput = new FileInput();
        try {
            textview.setText(fileInput.FileInputText(view.getContext(), "button4Content"));


        } catch (IOException e) {
            e.printStackTrace();
        }
        textview.setMovementMethod(new ScrollingMovementMethod());
        return view;
    }
    public void onResume(){
        super.onResume();

        // Set title bar
        ((MainActivity) getActivity())
                .setActionBarTitle("Systematic Tracing Evaluation");

    }

}
