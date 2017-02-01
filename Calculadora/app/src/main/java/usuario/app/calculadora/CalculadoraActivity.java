package usuario.app.calculadora;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CalculadoraActivity extends AppCompatActivity {

    EditText ednumero1, ednumero2;
    Button btsomar, btsubtrair, btmultiplicar, btdividir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora);
        ednumero1 = (EditText) findViewById(R.id.ednumero1);
        ednumero2 = (EditText) findViewById(R.id.ednumero2);
        btsomar = (Button) findViewById(R.id.btsomar);
        btsubtrair = (Button) findViewById(R.id.btsubtrair);
        btmultiplicar = (Button) findViewById(R.id.btmultiplicar);
        btdividir = (Button) findViewById(R.id.btdividir);

        btsomar.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                double num1 = Double.parseDouble(ednumero1.getText().toString());
                double num2 = Double.parseDouble(ednumero2.getText().toString());
                double soma = num1 + num2;

                AlertDialog.Builder dialogo = new AlertDialog.Builder(CalculadoraActivity.this);
//                String formatted = String.format("A soma é %.2f", soma);  para formatar a string

                dialogo.setTitle("Resultado Da Soma");
                dialogo.setMessage("A soma é " + soma);
                dialogo.setNeutralButton("OK", null);
                dialogo.show();
            }
        });

        btsubtrair.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                double num1 = Double.parseDouble(ednumero1.getText().toString());
                double num2 = Double.parseDouble(ednumero2.getText().toString());
                double subtracao = num1 - num2;

                AlertDialog.Builder dialogo = new AlertDialog.Builder(CalculadoraActivity.this);

                dialogo.setTitle("Resultado Da Substração");
                dialogo.setMessage("A subtração é " + subtracao);
                dialogo.setNeutralButton("OK", null);
                dialogo.show();
            }
        });

        btmultiplicar.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                double num1 = Double.parseDouble(ednumero1.getText().toString());
                double num2 = Double.parseDouble(ednumero2.getText().toString());
                double multiplicacao = num1 * num2;

                AlertDialog.Builder dialogo = new AlertDialog.Builder(CalculadoraActivity.this);

                dialogo.setTitle("Resultado Da Multiplicação");
                dialogo.setMessage("A multiplicação é " + multiplicacao);
                dialogo.setNeutralButton("OK", null);
                dialogo.show();
            }
        });

        btdividir.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                double num1 = Double.parseDouble(ednumero1.getText().toString());
                double num2 = Double.parseDouble(ednumero2.getText().toString());
                double divisao = num1 / num2;

                AlertDialog.Builder dialogo = new AlertDialog.Builder(CalculadoraActivity.this);

                dialogo.setTitle("Resultado Da Divisão");
                dialogo.setMessage("A divisão é " + divisao);
                dialogo.setNeutralButton("OK", null);
                dialogo.show();
            }
        });

    }
}
