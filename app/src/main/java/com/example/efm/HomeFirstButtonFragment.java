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

public class HomeFirstButtonFragment extends Fragment {



    ListView listView;
    DescAdapter descAdapter;
    Fragment listContentFrag;
    Context c;
    ActionBar actionBar;
    String [] desc = {"Uterine Contractions", "BaseLine FHR", "Baseline Variability", "Accelerations",
            "Early Decelerations", "Variable Decelerations", "Late Decelerations", "Prolonged Decelerations", "Decels in general", "Sinusoidal"};
    int [] image = {R.drawable.ic_camera_alt_black_24dp,R.drawable.baseline_fhr,R.drawable.baseline_variability
            ,R.drawable.accelerations,R.drawable.early_decelerations,R.drawable.variable_decelerations,
            R.drawable.late_decelerations,R.drawable.prolonged_decelerations,R.drawable.ic_camera_alt_black_24dp,R.drawable.sinusoidal};
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

                listContentFrag = new listContentFragment("buttonOneList/"+desc[i], image[i], desc[i]);
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
