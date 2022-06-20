package com.example.samuraisword.Models;

import java.io.Serializable;

public class Cards implements Serializable {

    private String nombre;
    private int danio;
    private int imgBackground;

    public Cards(String nombre, int danio, int imgBackground) {
        this.nombre = nombre;
        this.danio = danio;
        this.imgBackground = imgBackground;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDanio() {
        return danio;
    }

    public void setDanio(int danio) {
        this.danio = danio;
    }

    public int getImgBackground() {
        return imgBackground;
    }

    public void setImgBackground(int imgBackground) {
        this.imgBackground = imgBackground;
    }
}
