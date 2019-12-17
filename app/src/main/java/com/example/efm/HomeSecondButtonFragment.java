package com.example.efm;

import android.app.ActionBar;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class HomeSecondButtonFragment extends Fragment {



    ListView listView;
    DescAdapter descAdapter;
    Fragment listContentFrag;
    Context c;
    ActionBar actionBar;
    String [] desc = {"Categoery I", "Categoery II", "Categoery III"};
    int [] image = {R.drawable.cat1,R.drawable.cat2,R.drawable.cat3};
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home_first_defination_fra, container, false);
        c = view.getContext();

        listView = view.findViewById(R.id.listViewDef);
        descAdapter = new DescAdapter(view.getContext(),image,desc);
        listView.setAdapter(descAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                listContentFrag = new listContentFragment(desc[i],image[i],desc[i]);
                replaceFragment(listContentFrag);

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
