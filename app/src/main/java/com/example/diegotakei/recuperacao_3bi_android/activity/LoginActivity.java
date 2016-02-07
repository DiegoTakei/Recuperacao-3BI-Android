package com.example.diegotakei.recuperacao_3bi_android.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.diegotakei.recuperacao_3bi_android.R;
import com.example.diegotakei.recuperacao_3bi_android.asyncTask.LoginAsyncTask;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Diego Takei on 07/02/2016.
 */
public class LoginActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button enviar = (Button) findViewById(R.id.buttonLogin);

        enviar.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        JSONObject geral = new JSONObject();

                        try {

                            EditText loginEditText = (EditText) findViewById(R.id.editTextLogin);
                            String login = loginEditText.getText().toString();
                            geral.put("login", login);


                            EditText senhaEditText = (EditText) findViewById(R.id.editTextSenha);
                            String senha = senhaEditText.getText().toString();
                            geral.put("senha", senha);


                            LoginAsyncTask loginAsyncTask = new LoginAsyncTask(LoginActivity.this);
                            loginAsyncTask.execute(geral);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }
        );
    }
}
