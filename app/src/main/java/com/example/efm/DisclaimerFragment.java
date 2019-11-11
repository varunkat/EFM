package com.example.efm;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class DisclaimerFragment extends Fragment {


    TextView titleTv,textTv;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

       View v = inflater.inflate(R.layout.disclaimer_fragment, container, false);

        textTv = v.findViewById(R.id.disclaimerMessageTv);

        String text = "\n" +
                "Dear Colleague,\n" +
                "\n" +
                "  This guide provides NICHD Sept. 2008 definitions for FHR tracing characteristics and interpretations plus management for intrapartum FHR patterns from ACOG's Nov. 2010 Practice Bulletin.\n" +
                "\n" +
                "  But this guide does NOT...\n" +
                "- advise which patients to monitor with which method (EFM vs. intermittent auscultation), and\n" +
                "- offer judgment or suggestions for management aside from ACOG's explicit recommendations; this guide tries to faithfully aggregate information from major authorities and does not introduce or substitute the app authors' judgment.\n" +
                "\n" +
                "  You, the clinician, still have to rely upon your knowledge of the patient, your understanding of labor management," +
                " your institution's resources, and all other usual sources of guidance to decide when and how to apply EFM while managing labor. " +
                " Those sources might include your local standards of care, your local colleagues and consultants, and guidance from ACOG, other organizations, and " +
                "the medical literature.\n";

        textTv.setText(text);

        return v;



    }
}
