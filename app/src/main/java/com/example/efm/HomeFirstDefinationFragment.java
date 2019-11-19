package com.example.efm;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class HomeFirstDefinationFragment extends Fragment {



    ListView listView;
    DescAdapter descAdapter;
    String [] desc = {"Uterine Contractions","BaseLine FHR","Baseline Variability","Accelerations",
            "Early decelerations","Variable Decelerations","Late Decelerations","Prolonged Decelerations","Decels in general","Sinusoidal"};
    int image = R.drawable.ic_camera_alt_black_24dp;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home_first_defination_fra, container, false);

        listView = view.findViewById(R.id.listViewDef);
        descAdapter = new DescAdapter(view.getContext(),image,desc);
        listView.setAdapter(descAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 0){
                    Toast.makeText(view.getContext(),"first",Toast.LENGTH_SHORT).show();

                }
            }
        });


        return view;

    }
}
