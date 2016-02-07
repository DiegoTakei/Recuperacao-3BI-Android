package com.example.diegotakei.recuperacao_3bi_android.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import com.example.diegotakei.recuperacao_3bi_android.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // BUTTON IMC
        Button IMCButton = (Button) findViewById(R.id.imc_button);
        IMCButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent imcIntent = new Intent(MainActivity.this, IMCActivity.class);
                startActivity(imcIntent);

            }
        });

        // BUTTON VCT
        Button VCTButton = (Button) findViewById(R.id.vct_button);
        VCTButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent vctIntent = new Intent(MainActivity.this, VCTActivity.class);
                startActivity(vctIntent);

            }
        });

        // BUTTON PA
        Button PAButton = (Button) findViewById(R.id.pa_button);
        PAButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent paIntent = new Intent(MainActivity.this, PAActivity.class);
                startActivity(paIntent);

            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
