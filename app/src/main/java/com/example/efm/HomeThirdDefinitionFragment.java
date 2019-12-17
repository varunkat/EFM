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
import androidx.fragment.app.FragmentTransaction;

public class HomeThirdDefinitionFragment extends Fragment {

    ListView listView;
    DescAdapter descAdapter;
    Fragment listContentFrag;
    String [] desc = {"Categoery 1 Management", "Categoery 2 Management", "Categoery 3 Management", "Tachysystole","Minimal Variability","Intermittent Variables","Recurrent Variable Decels",
            "Recurrent Late Decels","Fetal Tachy Cardia","Prolonged decel Brady Cardia"};
    int image[] = {};
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

                listContentFrag = new listContentFragment(desc[i],0,desc[i]);
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


