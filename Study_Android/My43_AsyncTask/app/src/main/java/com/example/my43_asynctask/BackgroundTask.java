package com.example.my43_asynctask;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.ProgressBar;

public class BackgroundTask extends AsyncTask<Void, Integer, String> {
    private static final String TAG = "main:BackgroundTask";

    ProgressBar progressBar;
    int value;

    public BackgroundTask(ProgressBar progressBar, int value) {
        this.progressBar = progressBar;
        this.value = value;
    }

    @Override
    protected void onPreExecute() { //초기화, 정의
        super.onPreExecute();

        value = 0;
        progressBar.setProgress(value);
    }

    @Override
    protected String doInBackground(Void... voids) {
        while (isCancelled() == false) {
            value++;
            if (value >= 100) {
                break;
            } else {
                publishProgress(value);
                //publishProgress(value, value+1, value+2, ...);
            }

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        return "100% 완료";
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);

        progressBar.setProgress(values[0].intValue());
    }

    @Override
    protected void onPostExecute(String result) {  //실행되고 난 이후
        super.onPostExecute(result);

        Log.d(TAG, "onPostExecute: result => " + result);
        progressBar.setProgress(0);
    }

    @Override
    protected void onCancelled() {
        super.onCancelled();

        Log.d(TAG, "onCancelled: 실행 취소");
    }
}
