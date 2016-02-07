package com.example.diegotakei.recuperacao_3bi_android.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.diegotakei.recuperacao_3bi_android.R;
import com.example.diegotakei.recuperacao_3bi_android.asyncTask.IMCAsyncTask;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Diego Takei on 05/02/2016.
 */
public class IMCActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_imc);

        Button enviar = (Button) findViewById(R.id.btn_imc_enviar);

        enviar.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        JSONObject geral = new JSONObject();

                        try {

                            // Altura
                            EditText alturaEditText = (EditText) findViewById(R.id.edt_imc_altura);
                            String altura = alturaEditText.getText().toString();
                            geral.put("altura", altura);

                            // Peso
                            EditText pesoEditText = (EditText) findViewById(R.id.edt_imc_peso);
                            String peso = pesoEditText.getText().toString();
                            geral.put("peso", peso);

                            IMCAsyncTask calcularIMCAsyncTask = new IMCAsyncTask(v.getContext());
                            calcularIMCAsyncTask.execute(geral);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }
        );

    }

}
