package toast.cursoandroid.com.mensagenstoast;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button cliqueAqui;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cliqueAqui = findViewById(R.id.botaoId);
        cliqueAqui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // O makeText tem 3 parâmetros que são: contexto, texto e duracao
                // o contexto é onde será exibida a mensagem, qual o contexto de exibição
                // o texto é a mensagem que queremos passar


                Toast.makeText(getApplicationContext(), "Mensagem Toast Teste", Toast.LENGTH_SHORT).show();
            }
        });


    }
}
