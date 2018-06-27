package frasesdodia.cursoandroid.com.frasedodia;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView textoNovaFrase;
    private Button botaoNovaFrase;
    private String[] frases = {"Não deixe que as pessoas te façam desistir daquilo que você mais quer na vida. Acredite. Lute. Conquiste. E acima de tudo, seja feliz!",
            "Se a sua vida for a melhor coisa que já te aconteceu, acredite, você tem mais sorte do que pode imaginar.",
            "Confie em si mesmo, ninguém é forte o bastante para derrubar um coração destemido.",
            "Sorrir é a é melhor maneira de animar, seduzir ou fazer amigos. Sorria. Garanto que a vida vai saber sorrir de volta.",
            "Simplesmente acredite em seu sonhos, lute muito e uma dia de alguma forma você chegará onde sempre desejou.",
            "Vá em busca dos seus sonhos, lute pelo pelos seus ideais. Você não precisa que ninguém acredite em você, confie em si mesmo, siga em frente de cabeça erguida e seja um vencedor.",
            "Sua luta não termina quando sentir cansaço, mas sim quando atingir o sucesso tão merecido.",
            "Você não só tem o direito de ser feliz como também tem a obrigação de lutar para alcançar a felicidade.",
            "Não perca a motivação só porque as coisas não estão correndo como o previsto. Adversidade gera sabedoria e é isso que levará você ao sucesso."};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textoNovaFrase = findViewById(R.id.textoNovaFraseId);
        botaoNovaFrase = findViewById(R.id.botaoNovaFraseId);

        //textoNovaFrase.setText(frases[0]);

        botaoNovaFrase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random randomico = new Random();
                int numeroAleatorio = randomico.nextInt(frases.length);
                textoNovaFrase.setText(frases[numeroAleatorio]);
            }
        });
    }
}
