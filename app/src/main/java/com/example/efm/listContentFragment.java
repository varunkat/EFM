package com.example.efm;

import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import java.io.IOException;

public class listContentFragment extends Fragment {

private String fileName;
String contentList;
TextView contentTV;
FileInput fileInput;
Button managementBut;
    listContentFragment(String fileName) {
        this.fileName = fileName;

    }

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.text_firstbutton_list, container, false);
        contentTV = view.findViewById(R.id.listTextView);
        managementBut = view.findViewById(R.id.managementButton);


        managementBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HomeThirdDefinitionFragment thirdList = new HomeThirdDefinitionFragment();
                replaceFragment(thirdList);
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
