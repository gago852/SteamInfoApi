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
        holder.tvAppId.setText("App Id: " + listaJuegos.get(position).getAppid());
        holder.tvNombre.setText("Nombre: " + listaJuegos.get(position).getNombre());
        holder.tvTiempoJuego.setText("Tiempo de juego: " + String.valueOf(listaJuegos.get(position).getTiempoJuego()));
        holder.tvTiempoJuegotoSemana.setText("Tiempo de juego hace 2 semanas: " + String.valueOf(listaJuegos.get(position).getTiempoJuegotoSemanas()));
        holder.tvUrlIconoJuego.setText("Url icono del juego: " + listaJuegos.get(position).getUrlIconoJuego());
        holder.tvUrlLogoJuego.setText("Url logo del juego: " + listaJuegos.get(position).getUrlLogoJuego());
        holder.tvStatsVisibles.setText("Estadisticas visibles: " + listaJuegos.get(position).getTieneEstadisticasVisibles());
        holder.tvTiempoJuegoWindows.setText("Tiempo de juego en Windows: " + String.valueOf(listaJuegos.get(position).getTiempoJuegoWindows()));
        holder.tvTiempoJuegoMac.setText("Tiempo de juego en Mac: " + String.valueOf(listaJuegos.get(position).getTiempoJuegoMac()));
        holder.tvTiempoJuegoLinux.setText("Tiempo de juego en Linux:" + String.valueOf(listaJuegos.get(position).getTiempoJuegoLinux()));
    }

    @Override
    public int getItemCount() {
        return listaJuegos.size();
    }

    public class ViewHolderJuegos extends RecyclerView.ViewHolder {

        TextView tvAppId, tvNombre, tvTiempoJuego, tvTiempoJuegotoSemana, tvUrlIconoJuego, tvUrlLogoJuego, tvStatsVisibles, tvTiempoJuegoWindows, tvTiempoJuegoMac, tvTiempoJuegoLinux;

        public ViewHolderJuegos(@NonNull View itemView) {
            super(itemView);
            tvAppId = itemView.findViewById(R.id.tvAppId);
            tvNombre = itemView.findViewById(R.id.tvNombre);
            tvTiempoJuego = itemView.findViewById(R.id.tvTiempoJuego);
            tvTiempoJuegotoSemana = itemView.findViewById(R.id.tvTiempoJuegotoSemana);
            tvUrlIconoJuego = itemView.findViewById(R.id.tvUrlIconoJuego);
            tvUrlLogoJuego = itemView.findViewById(R.id.tvUrlLogoJuego);
            tvStatsVisibles = itemView.findViewById(R.id.tvStatsVisibles);
            tvTiempoJuegoWindows = itemView.findViewById(R.id.tvTiempoJuegoWindows);
            tvTiempoJuegoMac = itemView.findViewById(R.id.tvTiempoJuegoMac);
            tvTiempoJuegoLinux = itemView.findViewById(R.id.tvTiempoJuegoLinux);
        }
    }
}
