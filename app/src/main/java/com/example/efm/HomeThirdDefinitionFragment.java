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
    Fragment listContentFrag1;
    String [] desc = {"Categoery 1 Management", "Categoery 2 Management", "Categoery 3 Management", "Tachysystole","Minimal Variability","Intermittent Variables","Recurrent Variable Decels",
            "Recurrent Late Decels","Fetal Tachy Cardia","Prolonged decel Brady Cardia"};
    int image[] = {R.drawable.ic_camera_alt_black_24dp};
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home_third_definition_fra, container, false);

        listView = view.findViewById(R.id.listViewDef3);
        descAdapter = new DescAdapter(view.getContext(),image,desc);
        listView.setAdapter(descAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                listContentFrag1 = new listContentFragment(desc[i]);
                replaceFragment(listContentFrag1);

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


