package com.example.diegotakei.recuperacao_3bi_android.asyncTask;

import android.os.AsyncTask;
import android.util.Log;

import com.example.diegotakei.recuperacao_3bi_android.util.HttpService;
import com.example.diegotakei.recuperacao_3bi_android.util.Response;
import com.example.diegotakei.recuperacao_3bi_android.util.Server;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.HttpURLConnection;

/**
 * Created by Diego Takei on 05/02/2016.
 */
public class StatusServer extends AsyncTask<JSONObject, Void, Response> {

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

        Server server = new Server();
        String statusServer = null;

        try {

            int status = response.getStatusCodeHttp();

            if (status == HttpURLConnection.HTTP_OK) {

                JSONObject json = new JSONObject(response.getContentValue());

                statusServer = json.getString("online");
            }

        } catch (JSONException e) {

            Log.e("Rec App", "JSONException: " + e);
        }

        if (statusServer.equals("true")){
            server.setStatusServer(true);
        }
        else
            server.setStatusServer(false);
    }
}
