package com.example.diegotakei.recuperacao_3bi_android.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.diegotakei.recuperacao_3bi_android.R;

public class VCTActivity extends AppCompatActivity {

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

    }
}
