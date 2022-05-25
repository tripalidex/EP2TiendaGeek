package com.carlosquispe.tiendageek1145;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import com.carlosquispe.tiendageek1145.databinding.ActivityPrincipalBinding;

public class PrincipalActivity extends AppCompatActivity implements View.OnClickListener {
    private ActivityPrincipalBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPrincipalBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnFavoritos.setOnClickListener(this);
        binding.btnTienda.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_iniciar, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.nav_informacion:
                mostrarInformacion();
                return true;
            case R.id.nav_ayuda:
                mostrarAyuda();
                return true;
            case R.id.nav_colaboradores:
                mostrarColaboradores();
                return true;
            case R.id.nav_oficinas:
                mostrarOficinas();
                return true;
            case R.id.nav_calendario:
                mostrarCalendario();
                return true;
            case R.id.nav_contactos:
                mostrarContactos();
                return true;
            case R.id.nav_noticias:
                mostrarNoticias();
                return true;
//            case R.id.nav_proveedores:
//                mostrarProveedores();
//                return true;
//            case R.id.nav_clientes:
//                mostrarClientes();
//                return true;
           default:
              return super.onOptionsItemSelected(item);
        }
    }

    private void mostrarNoticias() {
        startActivity(new Intent(this, NoticiasActivity.class));
    }

    private void mostrarInformacion() {
        startActivity(new Intent(this, InformacionActivity.class));
    }

    private void mostrarAyuda() {
        startActivity(new Intent(this, AyudaActivity.class));
    }

    private void mostrarColaboradores() {
        startActivity(new Intent(this, ColaboradoresActivity.class));
    }

    private void mostrarOficinas() {
        startActivity(new Intent(this, OficinasActivity.class));
    }


    private void mostrarCalendario() {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_APP_CALENDAR);
        startActivity(intent);
    }

    private void mostrarContactos() {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_APP_CONTACTS);
        startActivity(intent);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnFavoritos:
                mostrarFavoritos();
                break;
            case R.id.btnTienda:
                mostrarTienda();
                break;
        }
    }

    private void mostrarTienda() {
        startActivity(new Intent(this, VideojuegosActivity.class));
    }

    private void mostrarFavoritos() {
        startActivity(new Intent(this, AudifonosActivity.class));
    }
}