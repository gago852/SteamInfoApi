package com.gago.steaminfoapi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;

public class ListadoActivity extends AppCompatActivity {

    ArrayList<Juegos> listaJuegos;
    RecyclerView rvJuegos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado);

        listaJuegos = new ArrayList<>();
        rvJuegos = findViewById(R.id.rvJuegos);
        rvJuegos.setLayoutManager(new LinearLayoutManager(this));
        Intent i = getIntent();
        listaJuegos = i.getParcelableArrayListExtra("juegos");

        ListaAdapter listaAdapter = new ListaAdapter(listaJuegos);
        rvJuegos.setAdapter(listaAdapter);
    }
}
