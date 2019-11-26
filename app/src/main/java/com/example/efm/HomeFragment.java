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

public class HomeFragment extends Fragment {


    Button b1, b3, b2;
    Fragment descFragment, sysevalFrag, thirdfrag, secondfrag;
    String hometext;
    FileInput fileinput;
    TextView hometextview;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.home_fragment, container, false);
        hometextview = view.findViewById(R.id.textView4);
        fileinput = new FileInput();
        try {
            hometext = fileinput.FileInputText(view.getContext(), "homescreentext");
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            hometextview.setText(Html.fromHtml(hometext));
        } else {
            hometextview.setText(Html.fromHtml( hometext));
        }



        Button B4 = (Button) view.findViewById(R.id.B4);
        b1 = view.findViewById(R.id.B1);
        B4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sysevalFrag = new SysevalFragment();
                replaceFragment(sysevalFrag);

            }
        });

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                descFragment = new HomeFirstButtonFragment();
                replaceFragment(descFragment);


            }
        });

        b3 = view.findViewById(R.id.B3);
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                thirdfrag = new HomeThirdDefinitionFragment();
                replaceFragment(thirdfrag);

            }
        });

        b2 = view.findViewById(R.id.B2);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                secondfrag = new HomeSecondButtonFragment();
                replaceFragment(secondfrag);

            }
        });

        return view;

    }

    public void replaceFragment(Fragment someFragment) {
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, someFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
