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
                if(desc[i] == "Categoery 1 Management"){
                    ((MainActivity) getActivity())
                            .setActionBarTitle("Categoery 1 Management");

                }
                else if(desc[i] == "Categoery 2 Management"){
                    ((MainActivity) getActivity())
                            .setActionBarTitle("Categoery 2 Management");

                }
                else if(desc[i] == "Categoery 3 Management"){
                    ((MainActivity) getActivity())
                            .setActionBarTitle("Categoery 3 Management");

                }
                else if(desc[i] == "Tachysystole"){
                    ((MainActivity) getActivity())
                            .setActionBarTitle("Tachysystole");

                }
                else if(desc[i] == "Minimal Variability"){
                    ((MainActivity) getActivity())
                            .setActionBarTitle("Minimal Variability");

                }
                else if(desc[i] == "Intermittent Variables"){
                    ((MainActivity) getActivity())
                            .setActionBarTitle("Intermittent Variables");

                }
                else if(desc[i] == "Recurrent Variable Decels"){
                    ((MainActivity) getActivity())
                            .setActionBarTitle("Recurrent Variable Decels");

                }
                else if(desc[i] == "Recurrent Late Decels"){
                    ((MainActivity) getActivity())
                            .setActionBarTitle("Recurrent Late Decels");

                }
                else if(desc[i] == "Fetal Tachy Cardia"){
                    ((MainActivity) getActivity())
                            .setActionBarTitle("Fetal Tachy Cardia");

                }
                else if(desc[i] == "Prolonged decel Brady Cardia"){
                    ((MainActivity) getActivity())
                            .setActionBarTitle("Prolonged decel Brady Cardia");

                }

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
    public void onResume(){
        super.onResume();

        // Set title bar
        ((MainActivity) getActivity())
                .setActionBarTitle("Tracing Intrpartum Management");

    }
}


