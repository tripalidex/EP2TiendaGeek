package com.carlosquispe.tiendageek1145;

import androidx.appcompat.app.AppCompatActivity;

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
import com.carlosquispe.tiendageek1145.databinding.ActivityAudifonosBinding;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.HashMap;

public class AudifonosActivity extends AppCompatActivity {
    private ActivityAudifonosBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAudifonosBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        leerServicio();
    }

    private void leerServicio() {
        // Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "https://serviciotiendageek.000webhostapp.com/audifonos.php";

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
                String nombre = jsonArray.getJSONObject(i).getString("nombre");
                String marca = jsonArray.getJSONObject(i).getString("marca");
                String descripcion = jsonArray.getJSONObject(i).getString("descripcion");
                String peso = "Peso: " + jsonArray.getJSONObject(i).getString("peso") + " g";
                String precio = "Precio: S/." + jsonArray.getJSONObject(i).getString("precio");
                HashMap<String,String> map = new HashMap<>();
                map.put("nombre", nombre);
                map.put("marca", marca);
                map.put("descripcion", descripcion);
                map.put("peso", peso);
                map.put("precio", precio);
                arrayList.add(map);
            }

            String[] origen = {"nombre","marca","descripcion","peso","precio"};
            int[] destino = {R.id.tvAudifonoNombre,R.id.tvAudifonoMarca,R.id.tvAudifonoDescripcion,
                            R.id.tvAudifonoPeso,R.id.tvAudifonoPrecio};
            //console.log para saber el numero de ID de los objectos
            ListAdapter listAdapter = new SimpleAdapter(
                    this,
                    arrayList,
                    R.layout.item_audifono,
                    origen,
                    destino
            );

            binding.lvAudifonos.setAdapter(listAdapter);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}