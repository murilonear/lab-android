package idadedecachorro.cursoandroid.com.idadedecachorro;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText caixaTexto;
    private Button botaoIdade;
    private TextView resultadoIdade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        caixaTexto = findViewById(R.id.caixaTextoId);
        botaoIdade = findViewById(R.id.botaoIdadeId);
        resultadoIdade = findViewById(R.id.resultadoIdadeId);

        botaoIdade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String textoDigitado = caixaTexto.getText().toString();
                if (textoDigitado.isEmpty()) {
                    resultadoIdade.setText("Nenhum número digitado !!");
                } else {
                    int valorDigitado = Integer.parseInt(textoDigitado);
                    int ValorResultadoFinal = valorDigitado * 7;
                    resultadoIdade.setText("A idade do cachorro em anos humanos é: " + ValorResultadoFinal + " anos ");

                }
            }
        });
    }
}
