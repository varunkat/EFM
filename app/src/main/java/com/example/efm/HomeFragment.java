package com.example.efm;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class HomeFragment extends Fragment {


    Button b1;
    Fragment descFragment, sysevalFrag;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home_fragment, container, false);



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
                descFragment = new HomeFirstDefinationFragment();
                replaceFragment(descFragment);


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
