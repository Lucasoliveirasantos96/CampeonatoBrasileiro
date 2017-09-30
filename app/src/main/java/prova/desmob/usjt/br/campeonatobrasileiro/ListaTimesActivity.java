package prova.desmob.usjt.br.campeonatobrasileiro;

import android.app.Activity;
import android.content.Intent;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class ListaTimesActivity extends Activity {
    public static final String PAIS = "br.usjt.desmob.prova.campeonatobrasileiro";
    Activity atividade;
    Campeonato[] campeonatos;
    ArrayList<String> nomes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_times);
        atividade = this;
        Intent intent = getIntent();
        String continente = intent.getStringExtra(MainActivity.CHAVE);
        campeonatos = Data.listarcampeonato(Campeonato);
        nomes = Data.listarNomes(campeonatos);

        ListView listView = (ListView) findViewById(R.id.lista_camp);
        CampeonatoAdapter adapter = new CampeonatoAdapter(campeonatos, this);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                // manda para a tela de detalhe
                Intent intent = new Intent(atividade, DetalheTimesActivity.class);
                intent.putExtra(Campeonato, campeonatos[position]);

                startActivity(intent);

            }


        });
    }
}
