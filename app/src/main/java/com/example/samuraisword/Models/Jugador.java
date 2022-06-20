package com.example.samuraisword.Models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Jugador implements Serializable {

    private Equipo team;
    private final Personaje poder;
    private int honor;
    private int vida;
    private int rojas;
    List<Cards> mano;

    public Jugador(Equipo team, Personaje poder, List<Cards> mano) {
        this.team = team;
        this.poder = poder;
        this.vida = poder.getVidamax();
        this.mano = mano;
        if (this.team == Equipo.SHOGUN)
            this.honor = 5;
        else
            this.honor = 4;
    }

    public Equipo getTeam() {
        return team;
    }

    public void setTeam(Equipo team) {
        this.team = team;
    }

    public Personaje getPoder() {
        return poder;
    }

    public int getHonor() {
        return honor;
    }

    public void setHonor(int honor) {this.honor = honor;}

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        if (vida > 0){
            this.setHonor(--this.honor);
            this.vida = poder.getVidamax();
        } else {
            this.vida = vida;
        }
    }

    public List<Cards> getMano() {
        return mano;
    }

    public void setMano(ArrayList<Cards> mano) {
        this.mano = mano;
    }

    public int calcDano(int danio, int fuerza){
        int dolor = danio + fuerza + poder.getDefensa();
        return dolor;
    }

    public void decHonor() {
        this.setHonor(--this.honor);
        this.vida = poder.getVidamax();
    }

    @Override
    public String toString() {
        return "Rol: " + team + ", Personaje: " + poder + ", Honor: " + honor + ", Vida: " + vida;
    }

    public String toSecretString() {
        return "Personaje: " + poder + ", Honor: " + honor + ", Vida: " + vida;
    }
}
