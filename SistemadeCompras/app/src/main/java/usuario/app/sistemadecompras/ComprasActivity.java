package usuario.app.sistemadecompras;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

public class ComprasActivity extends AppCompatActivity {

    CheckBox chkarroz, chkleite, chkcarne, chkfeijao;
    Button bttotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compras);

        chkarroz = (CheckBox) findViewById(R.id.chkarroz);
        chkleite = (CheckBox) findViewById(R.id.chkleite);
        chkcarne = (CheckBox) findViewById(R.id.chkcarne);
        chkfeijao = (CheckBox) findViewById(R.id.chkfeijao);
        bttotal = (Button) findViewById(R.id.bttotal);

        bttotal.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){

                double total = 0;

                if (chkarroz.isChecked()){
                    total += 2.69;
                }

                if (chkcarne.isChecked()){
                    total += 9.70;
                }

                if (chkleite.isChecked()){
                    total += 5.00;
                }

                if (chkfeijao.isChecked()){
                    total += 2.30;
                }

                AlertDialog.Builder dialogo = new AlertDialog.Builder(ComprasActivity.this);

                dialogo.setTitle("Aviso");
                dialogo.setMessage("Valor Total da Compra: " + String.valueOf(total));
                dialogo.setNeutralButton("OK", null);
                dialogo.show();


            }
        });
    }
}
