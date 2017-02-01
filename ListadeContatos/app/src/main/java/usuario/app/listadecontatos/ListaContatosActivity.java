package usuario.app.listadecontatos;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ListViewCompat;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

public class ListaContatosActivity extends AppCompatActivity {

    ListView lista_contatos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_contatos);

        lista_contatos = (ListView) findViewById(R.id.lista_contatos);

        lista_contatos.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String nome = ((TextView) view).getText().toString();
                AlertDialog.Builder dialog = new AlertDialog.Builder(ListaContatosActivity.this);

                dialog.setTitle("Contato");
                dialog.setMessage("Contato Selecionado: " + nome);
                dialog.setNeutralButton("OK", null);
                dialog.show();
            }
        });
    }
}
