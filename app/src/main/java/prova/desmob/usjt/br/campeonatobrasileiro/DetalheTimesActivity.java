package prova.desmob.usjt.br.campeonatobrasileiro;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DetalheTimesActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe_times);
        TextView txtCamp = (TextView)findViewById(R.id.txtCamp);
        Intent intent = getIntent();
        Campeonato campeonato = (Campeonato) intent.getSerializableExtra(ListaTimesActivity.CAMPEONATO);
        txtCamp.setText(campeonato.toString());
    }
    }
}
