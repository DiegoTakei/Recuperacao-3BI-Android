package com.example.diegotakei.recuperacao_3bi_android.asyncTask;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import com.example.diegotakei.recuperacao_3bi_android.util.HttpService;
import com.example.diegotakei.recuperacao_3bi_android.util.Response;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.HttpURLConnection;

/**
 * Created by Diego Takei on 05/02/2016.
 */
public class IMCAsyncTask extends AsyncTask<JSONObject, Void, Response> {

    Context context;

    public IMCAsyncTask(Context context) {
        this.context = context;
    }

    @Override
    protected Response doInBackground(JSONObject... valores) {

        Response response = null;

        try {

            response = HttpService.sendJSONPostResquest("calcularIMC", valores[0]);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return response;
    }

    @Override
    protected void onPostExecute(Response response) {

        try {

            int status = response.getStatusCodeHttp();

            if (status == HttpURLConnection.HTTP_OK) {

                JSONObject json = new JSONObject(response.getContentValue());

                String valor = json.getString("valor");
                Toast.makeText(context, valor, Toast.LENGTH_LONG).show();
            }

        } catch (JSONException e) {

            Log.e("Rec App", "JSONException: " + e);
        }
    }
}
