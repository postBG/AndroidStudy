package com.example.user.mainthread;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    private class CountThread extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 1000000; i++) {
                Log.d("SeungMin", "TEST");
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CountThread thread = new CountThread();
        thread.start();
    }
}
