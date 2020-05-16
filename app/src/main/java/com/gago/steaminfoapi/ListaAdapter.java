package com.gago.steaminfoapi;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ListaAdapter extends RecyclerView.Adapter<ListaAdapter.ViewHolderJuegos> {

    private ArrayList<Juegos> listaJuegos;

    public ListaAdapter(ArrayList<Juegos> listaJuegos) {
        this.listaJuegos = listaJuegos;
    }

    @NonNull
    @Override
    public ListaAdapter.ViewHolderJuegos onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_lista, null, false);
        return new ViewHolderJuegos(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListaAdapter.ViewHolderJuegos holder, int position) {

    }

    @Override
    public int getItemCount() {
        return listaJuegos.size();
    }

    public class ViewHolderJuegos extends RecyclerView.ViewHolder {

        TextView tvAppId, tvNombre, tvTiempoJuego, tvUrlIconoJuego, tvUrlLogoJuego, tvStatsVisibles, tvTiempoJuegoWindows, tvTiempoJuegoMac, tvTiempoJuegoLinux;

        public ViewHolderJuegos(@NonNull View itemView) {
            super(itemView);
            tvAppId = itemView.findViewById(R.id.tvAppId);
            tvNombre = itemView.findViewById(R.id.tvNombre);
            tvTiempoJuego = itemView.findViewById(R.id.tvTiempoJuego);
            tvUrlIconoJuego = itemView.findViewById(R.id.tvUrlIconoJuego);
            tvUrlLogoJuego = itemView.findViewById(R.id.tvUrlLogoJuego);
            tvStatsVisibles = itemView.findViewById(R.id.tvStatsVisibles);
            tvTiempoJuegoWindows = itemView.findViewById(R.id.tvTiempoJuegoWindows);
            tvTiempoJuegoMac = itemView.findViewById(R.id.tvTiempoJuegoMac);
            tvTiempoJuegoLinux = itemView.findViewById(R.id.tvTiempoJuegoLinux);
        }
    }
}
