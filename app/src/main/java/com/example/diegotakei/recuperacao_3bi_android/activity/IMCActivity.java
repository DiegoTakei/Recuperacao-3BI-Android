package com.example.diegotakei.recuperacao_3bi_android.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;

import com.example.diegotakei.recuperacao_3bi_android.R;
import com.example.diegotakei.recuperacao_3bi_android.listener.IMCListener;

/**
 * Created by Diego Takei on 05/02/2016.
 */
public class IMCActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_imc);

        Button enviar = (Button) findViewById(R.id.buttonEnviarIMC);

        enviar.setOnClickListener(new IMCListener());

    }

}
