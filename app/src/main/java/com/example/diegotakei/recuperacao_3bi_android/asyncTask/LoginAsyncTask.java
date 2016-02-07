package com.example.diegotakei.recuperacao_3bi_android.asyncTask;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import com.example.diegotakei.recuperacao_3bi_android.activity.MainActivity;
import com.example.diegotakei.recuperacao_3bi_android.util.HttpService;
import com.example.diegotakei.recuperacao_3bi_android.util.Response;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

/**
 * Created by Diego Takei on 07/02/2016.
 */
public class LoginAsyncTask extends AsyncTask<JSONObject, Void, Response> {

    private Activity activity;

    public LoginAsyncTask(Activity activity) {
        this.activity = activity;
    }


    @Override
    protected Response doInBackground(JSONObject... valores) {

        Response response = null;

        try {

            response = HttpService.sendJSONPostResquest("verificarLogin",valores[0]);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return response;
    }
    @Override
    protected void onPostExecute(Response response) {

        try {

            int status;
            status = response.getStatusCodeHttp();

            if (status == 202) {

                JSONObject json = new JSONObject(response.getContentValue());
                String codigo = json.getString("codigo");
                String nome = json.getString("nome");
                String apikey = json.getString("apikey");

                Toast.makeText(activity,nome+" está logado no sistema", Toast.LENGTH_LONG).show();

                Intent intent = new Intent(activity, MainActivity.class);
                activity.startActivity(intent);
                activity.finish();

            }else{
                Toast.makeText(activity,"Usuario ou Senha incorreta", Toast.LENGTH_LONG).show();
            }

        } catch (JSONException e) {

            Log.e("Rec App", "JSONException: " + e);
        }
    }
}
