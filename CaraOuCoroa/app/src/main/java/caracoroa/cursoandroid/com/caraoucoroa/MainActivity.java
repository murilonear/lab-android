package caracoroa.cursoandroid.com.caraoucoroa;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private ImageView botaoJogar;
    private String [] opcao = {"cara", "coroa"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        botaoJogar = findViewById(R.id.botaoJogarId);
        botaoJogar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random randomico = new Random();
                int numeroAleatorio = randomico.nextInt(opcao.length);

                //opcao[numeroAleatorio]
                Intent intent = new Intent(MainActivity.this, DetalheActivity.class);
                intent.putExtra("escolhido",opcao[numeroAleatorio]);
                // Essa função putExtra permite enviar dados para outras activitys
                startActivity(intent);

            }
        });

    }
}
