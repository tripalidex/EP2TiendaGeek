package com.carlosquispe.tiendageek1145;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class RegistrateActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrate);

        Button mbtnTerminos = findViewById(R.id.btnTerminos);
        Button mbtnSiguiente = findViewById(R.id.btnSiguiente);
        mbtnTerminos.setOnClickListener(this);
        mbtnSiguiente.setOnClickListener(this);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnTerminos:
                startActivity(new Intent(this, TerminosActivity.class));
                break;
            case R.id.btnSiguiente:
                startActivity(new Intent(this, PrincipalActivity.class));
                break;
        }
    }
}