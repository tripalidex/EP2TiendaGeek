package com.carlosquispe.tiendageek1145;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class EmpezarActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_empezar);

        Button mbtnRegistrate = findViewById(R.id.btnRegistrate);
        Button mbtnLogin = findViewById(R.id.btnLogin);
        mbtnRegistrate.setOnClickListener(this);
        mbtnLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnRegistrate:
                startActivity(new Intent(this, RegistrateActivity.class));
                break;
            case R.id.btnLogin:
                startActivity(new Intent(this, LoginActivity.class));
                break;
        }
    }
}