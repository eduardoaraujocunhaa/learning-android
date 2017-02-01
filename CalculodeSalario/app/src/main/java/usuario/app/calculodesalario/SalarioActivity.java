package usuario.app.calculodesalario;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

public class SalarioActivity extends AppCompatActivity {

    EditText edsalario;
    Button btcalcular;
    RadioGroup rgopcoes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_salario);

        edsalario = (EditText) findViewById(R.id.edsalario);
        btcalcular = (Button) findViewById(R.id.button);
        rgopcoes = (RadioGroup) findViewById(R.id.rgopcoes);

        btcalcular.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Double salario = Double.parseDouble(edsalario.getText().toString());
                double novo_salario = 0;
                int op = rgopcoes.getCheckedRadioButtonId();

                if (op == R.id.rb40){
                    novo_salario = salario + (salario * 0.4);
                }
                else if (op == R.id.rb45){
                    novo_salario = salario + (salario * 0.45);
                }
                else{
                    novo_salario = salario + (salario * 0.5);
                }

                AlertDialog.Builder dialog = new AlertDialog.Builder(SalarioActivity.this);

                dialog.setTitle("Novo Salario");
                dialog.setMessage("Seu novo salário é : R$" + String.valueOf(novo_salario));
                dialog.setNeutralButton("OK", null);
                dialog.show();
            }
        });
    }
}
