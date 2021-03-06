package com.example.diegotakei.recuperacao_3bi_android.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.diegotakei.recuperacao_3bi_android.R;
import com.example.diegotakei.recuperacao_3bi_android.asyncTask.VCTAsyncTask;

import org.json.JSONException;
import org.json.JSONObject;

public class VCTActivity extends Activity {

    private Spinner spnSexo;
    private ArrayAdapter<String> spnAdapter;
    private EditText edtPeso;
    private EditText edt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vct);

        spnAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item);
        spnAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spnSexo = (Spinner) findViewById(R.id.spn_vct_sexo);
        spnSexo.setAdapter(spnAdapter);

        spnAdapter.add("Masculino");
        spnAdapter.add("Feminino");


        Button enviar = (Button) findViewById(R.id.btn_vct_enviar);

        enviar.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        JSONObject geral = new JSONObject();
                        JSONObject entrevistado = new JSONObject();

                        try {

                            // Altura
                            EditText alturaEditText = (EditText) findViewById(R.id.edt_vct_altura);
                            String altura = alturaEditText.getText().toString();
                            geral.put("altura", altura);

                            // Peso
                            EditText pesoEditText = (EditText) findViewById(R.id.edt_vct_peso);
                            String peso = pesoEditText.getText().toString();
                            geral.put("peso", peso);

                            //Nível Esporte
                            EditText nivelEsporteEditText = (EditText) findViewById(R.id.edt_vct_esporte);
                            String nivelEsporte = nivelEsporteEditText.getText().toString();
                            geral.put("nivelEsporte", nivelEsporte);

                            //Sexo
                            String sexo = spnSexo.getSelectedItem().toString();
                            if(sexo.equals("Masculino")){
                                entrevistado.put("sexo","M");
                            } else {
                                entrevistado.put("sexo","F");
                            }

                            //Data de Nascimento
                            EditText nascimentoEditText = (EditText) findViewById(R.id.edt_vct_data_nascimento);
                            String nascimento = nascimentoEditText.getText().toString();

                            entrevistado.put("nascimento", nascimento);

                            geral.put("entrevistado", entrevistado);

                            VCTAsyncTask vctAsyncTask = new VCTAsyncTask(v.getContext());
                            vctAsyncTask.execute(geral);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }
        );

    }
}
