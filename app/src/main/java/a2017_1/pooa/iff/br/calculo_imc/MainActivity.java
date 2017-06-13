package a2017_1.pooa.iff.br.calculo_imc;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {


    private Button bt_calcular;
    private EditText peso, altura;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt_calcular = (Button) findViewById(R.id.btCalcular);
        peso = (EditText) findViewById(R.id.edtPeso);
        altura = (EditText) findViewById(R.id.edtAltura);

        bt_calcular.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                float iPeso = Float.parseFloat(peso.getText().toString());
                float iAltura = Float.parseFloat(altura.getText().toString());
                float resultado =  iPeso/(iAltura*iAltura);

                String msg = null;

                if (resultado < 17){
                    msg = "Muito abaixo do Peso";
                }
                if (resultado >= 17 && resultado <= 18.49){
                    msg = "Abaixo do Peso";
                }
                if (resultado > 18.49 && resultado <= 24.99){
                    msg = "Peso normal";
                }
                if (resultado > 24.99 && resultado <= 29.99){
                    msg = "Acima do Peso";
                }
                if (resultado > 30 && resultado <= 34.99){
                    msg = "Obesidade I";
                }
                if (resultado > 35 && resultado <= 39.99){
                    msg = "Obesidade II (severa)";
                }
                if (resultado > 40 ){
                    msg = "Obesidade III (mórbida)";
                }
                AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
                alert.setMessage(msg);
                alert.setNeutralButton("OK", null);
                alert.show();
            }
        });
    }
}
