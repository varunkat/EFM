package com.example.efm;

import android.content.Context;
import android.content.res.AssetManager;
import android.view.View;

import java.io.IOException;
import java.io.InputStream;

public class FileInput  {


    Context context;
    String tex;

    public FileInput() {

    }


    public String FileInputText(Context context, String fileName) throws IOException {

    this.context = context;

        AssetManager assetManager = context.getAssets();
        // To load text file
        InputStream input;

            input = assetManager.open(fileName);

            int size = input.available();
            byte[] buffer = new byte[size];
            input.read(buffer);
            input.close();

            // byte buffer into a string
            tex = new String(buffer);




        return tex;
    }
}
