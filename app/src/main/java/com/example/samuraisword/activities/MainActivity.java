package com.example.samuraisword.activities;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.samuraisword.Models.Cards;
import com.example.samuraisword.Models.Jugador;
import com.example.samuraisword.Models.Equipo;
import com.example.samuraisword.Models.Personaje;

import com.example.samuraisword.R;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    //List<Personaje> poderes = getAllPersonajes();

    //List<Equipo> equipo = getAllEquipos();

    List<Jugador> jugadores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        jugadores = (List<Jugador>) getIntent().getSerializableExtra("players");

        ConstraintLayout bgElement = findViewById(R.id.container);

        Button nextButton = (Button) findViewById(R.id.nextButton);
        Button cardButton = (Button) findViewById(R.id.cardButton);

        TextView tvVida1 = findViewById(R.id.vidaP1);
        TextView tvVida2 = findViewById(R.id.vidaP2);
        TextView tvVida3 = findViewById(R.id.vidaP3);
        TextView tvVida4 = findViewById(R.id.vidaP4);
        TextView tvVida5 = findViewById(R.id.vidaP5);

        TextView tvHonor1 = findViewById(R.id.honorP1);
        TextView tvHonor2 = findViewById(R.id.honorP2);
        TextView tvHonor3 = findViewById(R.id.honorP3);
        TextView tvHonor4 = findViewById(R.id.honorP4);
        TextView tvHonor5 = findViewById(R.id.honorP5);

        TextView tvPoder1 = findViewById(R.id.poderP1);
        TextView tvPoder2 = findViewById(R.id.poderP2);
        TextView tvPoder3 = findViewById(R.id.poderP3);
        TextView tvPoder4 = findViewById(R.id.poderP4);
        TextView tvPoder5 = findViewById(R.id.poderP5);



/*        for (int i = 0; i<5; i++){
            jugadores.add(new Jugador(equipo.get(i), poderes.get(i)));
        }*/

/*        Jugador jugador1 = new Jugador(equipo.get(0), poderes.get(0));
        Jugador jugador2 = new Jugador(equipo.get(1), poderes.get(1));
        Jugador jugador3 = new Jugador(equipo.get(2), poderes.get(2));
        Jugador jugador4 = new Jugador(equipo.get(3), poderes.get(3));
        Jugador jugador5 = new Jugador(equipo.get(4), poderes.get(4));*/

        switch (jugadores.get(0).getTeam()) {
            case SHOGUN:
            case SAMURAI:
                bgElement.setBackgroundColor(Color.YELLOW);
                break;
            case NINJA:
                bgElement.setBackgroundColor(Color.BLUE);
                break;
            case RONIN:
                bgElement.setBackgroundColor(Color.RED);
                break;
            default:
                break;
        }

//Cambiar a algo mas bonito, ya que probablemente se puede hacer mejor con array y/o funcion

        tvVida1.setText(String.valueOf(jugadores.get(0).getVida()));
        tvVida2.setText(String.valueOf(jugadores.get(1).getVida()));
        tvVida3.setText(String.valueOf(jugadores.get(2).getVida()));
        tvVida4.setText(String.valueOf(jugadores.get(3).getVida()));
        tvVida5.setText(String.valueOf(jugadores.get(4).getVida()));


        tvHonor1.setText(String.valueOf(jugadores.get(0).getHonor()));
        tvHonor2.setText(String.valueOf(jugadores.get(1).getHonor()));
        tvHonor3.setText(String.valueOf(jugadores.get(2).getHonor()));
        tvHonor4.setText(String.valueOf(jugadores.get(3).getHonor()));
        tvHonor5.setText(String.valueOf(jugadores.get(4).getHonor()));


        tvPoder1.setText(jugadores.get(0).getPoder().getNombre());
        tvPoder2.setText(jugadores.get(1).getPoder().getNombre());
        tvPoder3.setText(jugadores.get(2).getPoder().getNombre());
        tvPoder4.setText(jugadores.get(3).getPoder().getNombre());
        tvPoder5.setText(jugadores.get(4).getPoder().getNombre());


        cardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, CardActivity.class);
                intent.putExtra("jugadores", (Serializable) jugadores);
                MainActivity.this.startActivity(intent);
            }

        });

        /*
        @Override
        protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
            super.onActivityResult(requestCode, resultCode, data);
            if(requestCode == 123){
                if(resultCode == RESULT_OK);
                jugadores = (List<Jugador>) data.getSerializableExtra("jugadores");
            }
        }
         */


        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Collections.rotate(jugadores, -1);
                finish();
                startActivity(getIntent());
            }
        });

    }


/*
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
        cartas = getAllCartas();
        Collections.shuffle(cartas);
        for (int i = 0; i < 5; i++) {
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

 */
}