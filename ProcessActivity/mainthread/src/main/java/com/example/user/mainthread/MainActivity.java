package com.example.user.mainthread;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 0:
                    updateTextView(msg.arg1);
                    break;
                default:
                    break;
            }
        }
    };

    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            TextView text = (TextView) MainActivity.this.findViewById(R.id.posttxt);
            text.setText("Start Runnable");
        }
    };

    private class CountThread extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 1000000; i++) {
                Log.d("SeungMin", "TEST");
            }

            Message msg = handler.obtainMessage();
            msg.what = 0;
            msg.arg1 = 941116;
            handler.sendMessage(msg);
            handler.post(runnable);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CountThread thread = new CountThread();
        thread.start();
    }

    private void updateTextView(int myBirth) {
        TextView myBirthText = (TextView) MainActivity.this.findViewById(R.id.my_birth);
        myBirthText.setText("나의 생일은: " + String.valueOf(myBirth));
    }
}
