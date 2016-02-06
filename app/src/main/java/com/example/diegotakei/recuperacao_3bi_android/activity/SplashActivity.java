package com.example.diegotakei.recuperacao_3bi_android.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import com.example.diegotakei.recuperacao_3bi_android.R;
import com.example.diegotakei.recuperacao_3bi_android.asyncTask.StatusServer;
import com.example.diegotakei.recuperacao_3bi_android.util.Response;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.concurrent.ExecutionException;

/**
 * Created by Diego Takei on 05/02/2016.
 */
public class SplashActivity extends Activity implements Runnable {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Handler SplashScreen = new Handler();
        SplashScreen.postDelayed(SplashActivity.this, 3000);
    }
    @Override
    public void run() {

        String statusServer = null;
        Response response = null;

        StatusServer status = new StatusServer();
        status.execute();

        try {
            response = status.get();

            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }

        try {

            int status1;
            status1 = response.getStatusCodeHttp();

            if (status1 == 201) {

                JSONObject json = new JSONObject(response.getContentValue());

                statusServer = json.getString("online");
            }

        } catch (JSONException e) {

            Log.e("Rec App", "JSONException: " + e);
        }

        if (statusServer.equals("true")) {
            startActivity(new Intent(SplashActivity.this, MainActivity.class));
        }
        Log.e("valor", "server "+ statusServer);
        finish();

    }
}
