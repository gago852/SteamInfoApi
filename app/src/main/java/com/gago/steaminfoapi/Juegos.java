package com.gago.steaminfoapi;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class Juegos implements Parcelable {
    private String appid;

    @SerializedName("name")
    private String nombre;

    @SerializedName("playtime_forever")
    private int tiempoJuego;

    @SerializedName("img_icon_url")
    private String urlIconoJuego;

    @SerializedName("img_logo_url")
    private String urlLogoJuego;

    @SerializedName("has_community_visible_stats")
    private String tieneEstadisticasVisibles;

    @SerializedName("playtime_windows_forever")
    private int tiempoJuegoWindows;

    @SerializedName("playtime_windows_forever")
    private int tiempoJuegoMac;

    @SerializedName("playtime_windows_forever")
    private int tiempoJuegoLinux;

    public Juegos(String appid, String nombre, int tiempoJuego, String urlIconoJuego, String urlLogoJuego, String tieneEstadisticasVisibles, int tiempoJuegoWindows, int tiempoJuegoMac, int tiempoJuegoLinux) {
        this.appid = appid;
        this.nombre = nombre;
        this.tiempoJuego = tiempoJuego;
        this.urlIconoJuego = urlIconoJuego;
        this.urlLogoJuego = urlLogoJuego;
        this.tieneEstadisticasVisibles = tieneEstadisticasVisibles;
        this.tiempoJuegoWindows = tiempoJuegoWindows;
        this.tiempoJuegoMac = tiempoJuegoMac;
        this.tiempoJuegoLinux = tiempoJuegoLinux;
    }

    protected Juegos(Parcel in) {
        appid = in.readString();
        nombre = in.readString();
        tiempoJuego = in.readInt();
        urlIconoJuego = in.readString();
        urlLogoJuego = in.readString();
        tieneEstadisticasVisibles = in.readString();
        tiempoJuegoWindows = in.readInt();
        tiempoJuegoMac = in.readInt();
        tiempoJuegoLinux = in.readInt();
    }

    public static final Creator<Juegos> CREATOR = new Creator<Juegos>() {
        @Override
        public Juegos createFromParcel(Parcel in) {
            return new Juegos(in);
        }

        @Override
        public Juegos[] newArray(int size) {
            return new Juegos[size];
        }
    };

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTiempoJuego() {
        return tiempoJuego;
    }

    public void setTiempoJuego(int tiempoJuego) {
        this.tiempoJuego = tiempoJuego;
    }

    public String getUrlIconoJuego() {
        return urlIconoJuego;
    }

    public void setUrlIconoJuego(String urlIconoJuego) {
        this.urlIconoJuego = urlIconoJuego;
    }

    public String getUrlLogoJuego() {
        return urlLogoJuego;
    }

    public void setUrlLogoJuego(String urlLogoJuego) {
        this.urlLogoJuego = urlLogoJuego;
    }

    public String isTieneEstadisticasVisibles() {
        return tieneEstadisticasVisibles;
    }

    public void setTieneEstadisticasVisibles(String tieneEstadisticasVisibles) {
        this.tieneEstadisticasVisibles = tieneEstadisticasVisibles;
    }

    public int getTiempoJuegoWindows() {
        return tiempoJuegoWindows;
    }

    public void setTiempoJuegoWindows(int tiempoJuegoWindows) {
        this.tiempoJuegoWindows = tiempoJuegoWindows;
    }

    public int getTiempoJuegoMac() {
        return tiempoJuegoMac;
    }

    public void setTiempoJuegoMac(int tiempoJuegoMac) {
        this.tiempoJuegoMac = tiempoJuegoMac;
    }

    public int getTiempoJuegoLinux() {
        return tiempoJuegoLinux;
    }

    public void setTiempoJuegoLinux(int tiempoJuegoLinux) {
        this.tiempoJuegoLinux = tiempoJuegoLinux;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(appid);
        dest.writeString(nombre);
        dest.writeInt(tiempoJuego);
        dest.writeString(urlIconoJuego);
        dest.writeString(urlLogoJuego);
        dest.writeString(tieneEstadisticasVisibles);
        dest.writeInt(tiempoJuegoWindows);
        dest.writeInt(tiempoJuegoMac);
        dest.writeInt(tiempoJuegoLinux);
    }
}
