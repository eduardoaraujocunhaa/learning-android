package usuario.app.visualizadordeimagens;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import static android.R.attr.onClick;

public class VisualizadorImagensActivity extends AppCompatActivity {

    Button btfoto1, btfoto2;
    TextView txtinformacao;
    ImageView imgfoto;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visualizador_imagens);

        btfoto1 = (Button) findViewById(R.id.btfoto1);
        btfoto2 = (Button) findViewById(R.id.btfoto2);
        txtinformacao = (TextView) findViewById(R.id.Txtinformacao);
        imgfoto = (ImageView) findViewById(R.id.imgfoto);

        btfoto1.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){
                imgfoto.setImageResource(R.drawable.selfie);
                txtinformacao.setText("Foto 1");
            }
        });

        btfoto2.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){
                imgfoto.setImageResource(R.drawable.selfie_virada);
                txtinformacao.setText("Foto 2");
            }
        });
    }
}
