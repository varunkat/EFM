package com.example.efm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

public class SYSEVAL extends AppCompatActivity {

    TextView textview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_syseval);

        textview = (TextView)findViewById(R.id.textView3);

        String Para = "The AAFP's Advanced Life Support in Obstetrics (ALSO) course has a useful mnemonic for systematic evaluation of EFM tracings, 'DR. C. BRAVADO'\n" +
                "\n" +
                "                D - determine\n" +
                "                R - risk\n" +
                "\n" +
                "                C - contractions\n" +
                "\n" +
                "                B - baseline\n" +
                "                R - rate\n" +
                "                A\n" +
                "                V - variability\n" +
                "                A - accelerations\n" +
                "                D - decelerations\n" +
                "                O - overall impression\n" +
                "\n" +
                "ACOG recommends the same evaluation approach:\n" +
                "- elements of EFM evaluation necessary for interpretation are contraction pattern, baseline FHR, baseline variability, accelerations, decelerations, and changes or trends of FHR patterns over time\n" +
                "- tracing should be interpreted within context of the clinical circumstances\n" +
                "- patterns change over time, FHR must be regularly re-evaluated.\n";

        textview.setText(Para);
        textview.setMovementMethod(new ScrollingMovementMethod());
    }
}
