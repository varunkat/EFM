package com.example.efm;

import android.content.Context;
import android.content.res.AssetManager;
import android.view.View;

import java.io.IOException;
import java.io.InputStream;

public class FileInput  {


    Context context;



    public FileInput(Context context) throws IOException {

    this.context = context;

        AssetManager assetManager = context.getAssets();
        // To load text file
        InputStream input;
        try {
            input = assetManager.open("Disclaimer");

            int size = input.available();
            byte[] buffer = new byte[size];
            input.read(buffer);
            input.close();

            // byte buffer into a string
            String tex = new String(buffer);


        } catch (
                IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
