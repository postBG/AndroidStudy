package com.example.user.asynctask;

import android.app.ProgressDialog;
import android.content.IntentFilter;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SimpleAsyncTask simpleAsyncTask = new SimpleAsyncTask();
        simpleAsyncTask.execute(1);
    }

    private class SimpleAsyncTask extends AsyncTask<Integer, Integer, Integer> {

        private ProgressDialog mProgressDialog = null;

        @Override
        protected void onPreExecute() {
            mProgressDialog = new ProgressDialog(MainActivity.this);
            mProgressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
            mProgressDialog.setMessage("Hi! Just before start");
            mProgressDialog.setMax(100);
            mProgressDialog.show();
        }

        @Override
        protected Integer doInBackground(Integer... params) {
            int sum = 0;
            for(int i = params[0]; i < 100; i++){
                sum += i;

                this.publishProgress(i, sum);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            return sum;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            Integer publishedValueOfI = values[0];
            Integer publishedValueOfSum = values[1];
            mProgressDialog.setMessage("i = " + publishedValueOfI + " sum = " + publishedValueOfSum);
            mProgressDialog.setProgress(publishedValueOfI);
        }

        @Override
        protected void onPostExecute(Integer integer) {
            mProgressDialog.dismiss();
        }
    }
}
