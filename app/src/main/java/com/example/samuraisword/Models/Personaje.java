package com.example.samuraisword.Models;

import java.io.Serializable;

public class Personaje implements Serializable {
    private String nombre;
    private final int vidamax;
    private int fuerza;
    private int defensa;

    public Personaje(String nombre, int vidamax, int fuerza, int defensa) {
        this.nombre = nombre;
        this.vidamax = vidamax;
        this.fuerza = fuerza;
        this.defensa = defensa;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getFuerza() {
        return fuerza;
    }

    public void setFuerza(int fuerza) {
        this.fuerza = fuerza;
    }

    public int getDefensa() {
        return defensa;
    }

    public void setDefensa(int defensa) {
        this.defensa = defensa;
    }

    public int getVidamax() {
        return vidamax;
    }

    @Override
    public String toString() {
        return nombre;
    }
}
