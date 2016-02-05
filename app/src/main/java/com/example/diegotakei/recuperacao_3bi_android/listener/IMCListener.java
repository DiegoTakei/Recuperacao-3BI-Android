package com.example.diegotakei.recuperacao_3bi_android.listener;

import android.view.View;
import android.widget.EditText;

import com.example.diegotakei.recuperacao_3bi_android.R;
import com.example.diegotakei.recuperacao_3bi_android.asyncTask.IMCAsyncTask;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Diego Takei on 05/02/2016.
 */
public class IMCListener implements View.OnClickListener {

    @Override
    public void onClick(View v) {

        JSONObject geral = new JSONObject();

        try {
            // Peso
            EditText pesoEditText = (EditText) v.findViewById(R.id.editTextPeso);
            String peso = pesoEditText.getText().toString();
            geral.put("peso", peso);

            // Altura
            EditText alturaEditText = (EditText) v.findViewById(R.id.editTextAltura);
            String altura = alturaEditText.getText().toString();
            geral.put("altura", altura);

            IMCAsyncTask calcularIMCAsyncTask = new IMCAsyncTask(v.getContext());
            calcularIMCAsyncTask.execute(geral);

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
