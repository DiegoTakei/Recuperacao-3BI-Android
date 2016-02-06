package com.example.diegotakei.recuperacao_3bi_android.asyncTask;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;

import com.example.diegotakei.recuperacao_3bi_android.activity.MainActivity;
import com.example.diegotakei.recuperacao_3bi_android.util.HttpService;
import com.example.diegotakei.recuperacao_3bi_android.util.Response;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

/**
 * Created by Diego Takei on 05/02/2016.
 */
public class StatusServer extends AsyncTask<JSONObject, Void, Response> {

    private Activity activity;

    public StatusServer(Activity activity) {
        this.activity = activity;
    }


    @Override
    protected Response doInBackground(JSONObject... params) {

        Response response = null;

        try {

            response = HttpService.sendGetRequest("statusServer");

        } catch (IOException e) {
            e.printStackTrace();
        }

        return response;
    }
    @Override
     protected void onPostExecute(Response response) {

        try {

            int status1;
            status1 = response.getStatusCodeHttp();

            if (status1 == 201) {

                JSONObject json = new JSONObject(response.getContentValue());

                Boolean statusServer = json.getBoolean("online");

                if(statusServer){
                    Intent intent = new Intent(activity, MainActivity.class);
                    activity.startActivity(intent);
                    activity.finish();
                }
                else{
                    activity.finish();
                }
            }

        } catch (JSONException e) {

            Log.e("Rec App", "JSONException: " + e);
        }
    }
}
