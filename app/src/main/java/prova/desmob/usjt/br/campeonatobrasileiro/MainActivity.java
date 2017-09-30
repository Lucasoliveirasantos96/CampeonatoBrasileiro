package prova.desmob.usjt.br.campeonatobrasileiro;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

public class MainActivity extends Activity {
    Spinner spinnerCampeonato;
    public static final String CHAVE = "br.usjt.desmob.prova.txtCamp";
    String camp = "Todos";


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinnerCampeonato = (Spinner) findViewById(R.id.spinnerCampeonato);
        spinnerCampeonato.setOnItemSelectedListener(new TimeSelecionado());
    }


    public void listarCamp(View view) {
        Intent intent = new Intent(this, ListaTimesActivity.class);

        intent.putExtra(CHAVE, camp);
        startActivity(intent);
    }

    private class TimeSelecionado implements AdapterView.OnItemSelectedListener {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            camp = (String) parent.getItemAtPosition(position);
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    }
}
