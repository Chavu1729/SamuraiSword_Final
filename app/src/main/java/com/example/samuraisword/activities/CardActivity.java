package com.example.samuraisword.activities;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.samuraisword.Adapter.CardAdapter;
import com.example.samuraisword.Models.Cards;
import com.example.samuraisword.Models.Jugador;
import com.example.samuraisword.R;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CardActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private CardAdapter adapter;

    private List<Jugador> jugadors;
    private List<Cards> cartas;
    private CharSequence[] enemigos = {"uno", "dos", "tres", "cuatro"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cards);
        jugadors = (List<Jugador>) getIntent().getSerializableExtra("jugadores");
        for(int i = 1; i<jugadors.size(); i++){
            enemigos[i-1] = jugadors.get(i).getPoder().toString();
        }
        cartas = jugadors.get(0).getMano();
        recyclerView = findViewById(R.id.recyclerView);
        layoutManager = new LinearLayoutManager(this);
        adapter = new CardAdapter(cartas, R.layout.recycle_view_cards_item, this, new CardAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Cards cartas, int position) {
                int cartaDaño = cartas.getDanio();
                AlertDialog.Builder builder = new AlertDialog.Builder(CardActivity.this);
                builder.setTitle("A quien atacas?");
                builder.setItems(enemigos, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        int daño = jugadors.get(i+1).calcDano(cartaDaño, jugadors.get(i).getPoder().getFuerza());
                        jugadors.get(i+1).setVida(jugadors.get(i+1).getVida() - daño);
                        Intent mintent = new Intent();
                        mintent.putExtra("jugadores", (Serializable) jugadors);
                        setResult(RESULT_OK, mintent);
                        CardActivity.this.finish();
                    }
                });
                AlertDialog dialog = builder.create();
                dialog.show();

                adapter.notifyItemChanged(position);
            }
        });
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

    }


    }


