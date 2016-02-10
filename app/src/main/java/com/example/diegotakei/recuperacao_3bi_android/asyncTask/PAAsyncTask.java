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
 * Created by Henique on 09/02/2016.
 */
public class PAAsyncTask extends AsyncTask<JSONObject, Void, Response>{

        Context context;

        public PAAsyncTask(Context context) {
        this.context = context;
         }

        @Override
        protected Response doInBackground(JSONObject... valores) {

            Response response = null;

            try {

                response = HttpService.sendJSONPostResquest("calcularPerfilAntropometrico", valores[0]);

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

                    JSONObject jsonImc = json.getJSONObject("imc");

                    String valor = jsonImc.getString("valor");
                    String diagnostico = json.getString("diagnostico");

                    Toast.makeText(context, "Seu IMC é: " + valor + ". " + diagnostico, Toast.LENGTH_LONG).show();
                }

            } catch (JSONException e) {

                Log.e("Rec App", "JSONException: " + e);
        }
    }
}
