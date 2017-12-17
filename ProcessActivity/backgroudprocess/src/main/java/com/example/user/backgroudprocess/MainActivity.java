package com.example.user.backgroudprocess;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState != null) {
            String state = savedInstanceState.getString("STATE");
            Toast.makeText(this, "STATE = " + state, Toast.LENGTH_LONG).show();
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        Toast.makeText(this, "Saved state", Toast.LENGTH_LONG).show();
        outState.putString("STATE", "FORCE STOP");
    }
}
