package com.example.samuraisword.activities;

import android.app.Application;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.samuraisword.Models.Cards;
import com.example.samuraisword.Models.Equipo;
import com.example.samuraisword.Models.Jugador;
import com.example.samuraisword.Models.Personaje;
import com.example.samuraisword.R;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import android.view.View;
import android.widget.Button;

public class StartActivity extends AppCompatActivity implements Serializable{

    List<Personaje> poderes = getAllPersonajes();

    List<Equipo> equipo = getAllEquipos();

    public List<Jugador> jugadores = getJugadores(equipo, poderes);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);


        Button startButton = (Button) findViewById(R.id.startButton);

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mintent = new Intent(StartActivity.this, MainActivity.class);
                mintent.putExtra("players", (Serializable) jugadores);
                startActivity(mintent);
            }
    });
    }

    private List<Personaje> getAllPersonajes() {
        ArrayList<Personaje> characterino = new ArrayList<>() {{
            add(new Personaje("Ginchiyo", 4, 0, -1));
            add(new Personaje("Hideyoshi", 4, 0, 0));
            add(new Personaje("Musashi", 5, 1, 0));
            add(new Personaje("Goemon", 5, 0, 0));
            add(new Personaje("Gracia", 4, 0, 0));
            add(new Personaje("Yoshihiro", 8, 0, 1));
        }};
        Collections.shuffle(characterino);
        return characterino;
    }

    private List<Equipo> getAllEquipos() {
        ArrayList<Equipo> timu = new ArrayList<>() {{
            add(Equipo.NINJA);
            add(Equipo.NINJA);
            add(Equipo.RONIN);
            add(Equipo.SAMURAI);
            add(Equipo.SHOGUN);
        }};
        Collections.shuffle(timu);
        return timu;
    }

    private List<Jugador> getJugadores(List<Equipo> timu, List<Personaje> characterino) {
        ArrayList<Jugador> playerino = new ArrayList<Jugador>();
        List<Cards> cartas;
        for (int i = 0; i < 5; i++) {
            cartas = getAllCartas();
            Collections.shuffle(cartas);
            playerino.add(new Jugador(timu.get(i), characterino.get(i), cartas));

        }
        return playerino;
    }

    private List<Cards> getAllCartas() {
        return new ArrayList<Cards>() {{
            add(new Cards("Bokken", 1, R.drawable.weapons));
            add(new Cards("Kusarigama", 2, R.drawable.weapons));
            add(new Cards("Katana", 3, R.drawable.weapons));
            add(new Cards("Jujitsu", 0, R.drawable.cherry_bg));
            add(new Cards("Recuperacion", 0, R.drawable.cherry_bg));
            add(new Cards("Daimio", 0, R.drawable.cherry_bg));
        }};
    }
}

