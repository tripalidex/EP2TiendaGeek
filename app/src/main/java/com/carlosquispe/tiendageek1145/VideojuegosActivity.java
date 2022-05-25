package com.carlosquispe.tiendageek1145;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListAdapter;
import android.widget.SimpleAdapter;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.carlosquispe.tiendageek1145.adapters.VideojuegoAdapter;
import com.carlosquispe.tiendageek1145.databinding.ActivityPrincipalBinding;
import com.carlosquispe.tiendageek1145.databinding.ActivityVideojuegosBinding;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.HashMap;

public class VideojuegosActivity extends AppCompatActivity {
    private ActivityVideojuegosBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityVideojuegosBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        leerServicio();
    }

    private void leerServicio() {
        // Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "https://serviciotiendageek.000webhostapp.com/videojuegos.php";

        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d("DATOS_TIENDA", response);
                        llenarLista(response);
                    }
                }, new Response.ErrorListener(){
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("DATOS_TIENDA",error.getMessage());
            }
        });
        // Add the request to the RequestQueue.
        queue.add(stringRequest);
    }

    private void llenarLista(String response) {
        ArrayList arrayList = new ArrayList<HashMap<String,String>>();
        try {
            JSONArray jsonArray = new JSONArray(response);
            for(int i=0; i<jsonArray.length(); i++){
                String idVideojuego = jsonArray.getJSONObject(i).getString("idVideojuego");
                String nombre = jsonArray.getJSONObject(i).getString("nombre");
                String descripcion = jsonArray.getJSONObject(i).getString("descripcion");
                String plataforma = jsonArray.getJSONObject(i).getString("plataforma");
                String precio = "Precio: S/." + jsonArray.getJSONObject(i).getString("precio");
                HashMap<String,String> map = new HashMap<>();
                map.put("idVideojuego", idVideojuego);
                map.put("nombre", nombre);
                map.put("descripcion", descripcion);
                map.put("plataforma", plataforma);
                map.put("precio", precio);
                arrayList.add(map);
            }

            VideojuegoAdapter videojuegoAdapter = new VideojuegoAdapter(arrayList);
            binding.rvVideojuegos.setAdapter(videojuegoAdapter);
            binding.rvVideojuegos.setLayoutManager(new LinearLayoutManager(this));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}