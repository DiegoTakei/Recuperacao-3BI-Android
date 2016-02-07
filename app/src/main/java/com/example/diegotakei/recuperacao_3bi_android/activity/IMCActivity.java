package com.example.diegotakei.recuperacao_3bi_android.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import com.example.diegotakei.recuperacao_3bi_android.R;
import com.example.diegotakei.recuperacao_3bi_android.listener.IMCListener;

/**
 * Created by Diego Takei on 05/02/2016.
 */
public class IMCActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_imc);

        Button enviar = (Button) findViewById(R.id.btn_imc_enviar);

        enviar.setOnClickListener(new IMCListener());

    }

}
