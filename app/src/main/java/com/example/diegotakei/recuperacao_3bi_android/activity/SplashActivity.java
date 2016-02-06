package com.example.diegotakei.recuperacao_3bi_android.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import com.example.diegotakei.recuperacao_3bi_android.R;
import com.example.diegotakei.recuperacao_3bi_android.asyncTask.StatusServer;
import com.example.diegotakei.recuperacao_3bi_android.util.Server;

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

        Boolean statusServer;

        StatusServer status = new StatusServer();
        status.execute();

        Server server = new Server();
        statusServer = server.isStatusServer();

        if (statusServer == true) {
            startActivity(new Intent(SplashActivity.this, MainActivity.class));
        }
        Log.e("valor", "server "+ statusServer);
        finish();

    }
}
