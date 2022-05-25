package com.carlosquispe.tiendageek1145;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.carlosquispe.tiendageek1145.databinding.ActivityNoticiasBinding;
import com.carlosquispe.tiendageek1145.fragments.Noticia1Fragment;
import com.carlosquispe.tiendageek1145.fragments.Noticia2Fragment;
import com.carlosquispe.tiendageek1145.fragments.Noticia3Fragment;
import com.carlosquispe.tiendageek1145.fragments.Noticia4Fragment;

public class NoticiasActivity extends AppCompatActivity implements View.OnClickListener {
    private ActivityNoticiasBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityNoticiasBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.rbNoticia1.setOnClickListener(this);
        binding.rbNoticia2.setOnClickListener(this);
        binding.rbNoticia3.setOnClickListener(this);
        binding.rbNoticia4.setOnClickListener(this);

        binding.rbNoticia1.setChecked(true);
        mostrarNoticia1();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.rbNoticia1:
                mostrarNoticia1();
                break;
            case R.id.rbNoticia2:
                mostrarNoticia2();
                break;
            case R.id.rbNoticia3:
                mostrarNoticia3();
                break;
            case R.id.rbNoticia4:
                mostrarNoticia4();
                break;
        }
    }

    private void mostrarNoticia1() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.contenedor, new Noticia1Fragment())
                .commit();
    }

    private void mostrarNoticia2() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.contenedor, new Noticia2Fragment())
                .commit();
    }

    private void mostrarNoticia3() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.contenedor, new Noticia3Fragment())
                .commit();
    }

    private void mostrarNoticia4() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.contenedor, new Noticia4Fragment())
                .commit();
    }
}