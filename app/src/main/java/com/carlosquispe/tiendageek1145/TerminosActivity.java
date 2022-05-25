package com.carlosquispe.tiendageek1145;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TerminosActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_terminos);

        Button mbtnCerrarTerminos = findViewById(R.id.btnCerrarTerminos);
        mbtnCerrarTerminos.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        finish();
    }
}