package com.example.diegotakei.recuperacao_3bi_android.asyncTask;

import android.os.AsyncTask;

import com.example.diegotakei.recuperacao_3bi_android.util.HttpService;
import com.example.diegotakei.recuperacao_3bi_android.util.Response;

import org.json.JSONObject;

import java.io.IOException;

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

}
