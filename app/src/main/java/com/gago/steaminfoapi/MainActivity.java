package com.gago.steaminfoapi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TextView tvLista;
    Button btCargar, btListar;

    String url = "https://api.steampowered.com/IPlayerService/GetOwnedGames/v0001/?";
    String key = "KEY";
    String steamid = "STEAMID";

    ArrayList<Juegos> listaJuegos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvLista = findViewById(R.id.tvLista);
        btCargar = findViewById(R.id.btCargar);
        btListar = findViewById(R.id.btListar);

        btCargar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cargarWebService();
            }
        });

        btListar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listaJuegos!=null) {
                    Intent i = new Intent(getApplicationContext(), ListadoActivity.class);
                    i.putParcelableArrayListExtra("juegos", listaJuegos);
                    startActivity(i);
                } else {
                    Toast.makeText(getApplicationContext(), "no ha cargado el servicio web", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    private void cargarWebService() {
        String urlApi = url + "key=" + key + "&steamid=" + steamid + "&include_appinfo=1&include_played_free_games=1";
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, urlApi, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Type tipoListaJuegos = new TypeToken<ArrayList<Juegos>>() {
                }.getType();
                Gson gson = new Gson();
                try {
                    JSONObject respuesta = response.getJSONObject("response");
                    listaJuegos = gson.fromJson(respuesta.getJSONArray("games").toString(), tipoListaJuegos);
                    mostrar();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), "error de conexion", Toast.LENGTH_SHORT).show();
            }
        });
        requestQueue.add(jsonObjectRequest);
    }

    private void mostrar() {
        String texto = "";
        for (Juegos juego : listaJuegos) {
            texto = texto + juego.getAppid() + juego.getNombre() + juego.getTiempoJuego() + juego.getTiempoJuegotoSemanas() + juego.getUrlIconoJuego()
                    + juego.getUrlLogoJuego() + juego.getTieneEstadisticasVisibles()
                    + juego.getTiempoJuegoWindows() + juego.getTiempoJuegoMac() + juego.getTiempoJuegoLinux() + "\n";
        }
        tvLista.setText(texto);
    }
}
