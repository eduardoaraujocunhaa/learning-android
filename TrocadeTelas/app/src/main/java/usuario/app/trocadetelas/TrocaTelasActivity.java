package usuario.app.trocadetelas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TrocaTelasActivity extends AppCompatActivity {

    Button bttelaprincipal, bttela2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        CarregarTelaPrincipal();
    }

    public void CarregarTelaPrincipal(){

        setContentView(R.layout.activity_troca_telas);
        bttela2 = (Button) findViewById(R.id.bttela2);

        bttela2.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){
                CarregarTela2();
            }
        });
    }

    public void CarregarTela2(){

        setContentView(R.layout.tela2);
        bttelaprincipal = (Button) findViewById(R.id.bttelaprincipal);

        bttelaprincipal.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                CarregarTelaPrincipal();
            }

        });
    }
}
