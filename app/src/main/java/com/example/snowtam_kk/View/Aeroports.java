package com.example.snowtam_kk.View;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.snowtam_kk.R;

public class Aeroports extends AppCompatActivity {

    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aeroports);

        mTextView = (TextView) findViewById(R.id.text);

        // Enables Always-on
    }
}