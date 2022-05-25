package com.carlosquispe.tiendageek1145.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.carlosquispe.tiendageek1145.R;

import java.util.ArrayList;
import java.util.HashMap;

public class VideojuegoAdapter extends RecyclerView.Adapter<VideojuegoAdapter.ViewHolder>{
    ArrayList<HashMap<String,String>> arrayList;
    public VideojuegoAdapter(ArrayList<HashMap<String,String>> arrayList) {
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_videojuego, parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        HashMap<String,String> map = arrayList.get(position);
        holder.mtvVideojuegoNombre.setText(map.get("nombre"));
        holder.mtvVideojuegoDescripcion.setText(map.get("descripcion"));
        holder.mtvVideojuegoPlataforma.setText(map.get("plataforma"));
        holder.mtvVideojuegoGenero.setText(map.get("genero"));
        holder.mtvVideojuegoPrecio.setText(map.get("precio"));
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView mtvVideojuegoNombre,mtvVideojuegoDescripcion,mtvVideojuegoPlataforma,
                mtvVideojuegoGenero,mtvVideojuegoPrecio;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            mtvVideojuegoNombre = itemView.findViewById(R.id.tvVideojuegoNombre);
            mtvVideojuegoDescripcion = itemView.findViewById(R.id.tvVideojuegoDescripcion);
            mtvVideojuegoPlataforma = itemView.findViewById(R.id.tvVideojuegoPlataforma);
            mtvVideojuegoGenero = itemView.findViewById(R.id.tvVideojuegoGenero);
            mtvVideojuegoPrecio = itemView.findViewById(R.id.tvVideojuegoPrecio);
        }
    }
}
