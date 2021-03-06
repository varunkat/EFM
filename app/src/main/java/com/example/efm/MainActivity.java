package com.example.efm;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    Context context;
    FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar actionBar = getSupportActionBar();


        BottomNavigationView bottomNavigationView =  findViewById(R.id.bottom_nav);
        bottomNavigationView.setOnNavigationItemSelectedListener(navigationItemSelectedListener);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                new HomeFragment()
                ).commit();



    }


    private BottomNavigationView.OnNavigationItemSelectedListener navigationItemSelectedListener =

            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                    Fragment selectedFragment = null;


                    switch (menuItem.getItemId()){

                        case R.id.nav_home:
                            selectedFragment = new HomeFragment();
                            break;
                        case R.id.nav_disclaimer:
                            selectedFragment = new DisclaimerFragment();
                            break;
                        case R.id.nav_info:
                            selectedFragment = new InformationFragment();
                            break;
                        case R.id.nav_ref:
                            selectedFragment = new ReferencesFragment();
                            break;



                    }
                   // getFragmentManager().beginTransaction().remove(selectedFragment).commitAllowingStateLoss();
                   // getSupportFragmentManager().beginTransaction().remove(selectedFragment).commitAllowingStateLoss();


                    fragmentManager = getSupportFragmentManager();
                    fragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);


                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,

                            selectedFragment).commit();













                    return true;

                }
            };

    public void setActionBarTitle(String title) {
        getSupportActionBar().setTitle(title);
    }
}
