package signos.cursoandroid.com.signos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ListView listaSignos;
    private String[] signos = {"Áries", "Touro", "Gêmeos", "Câncer", "Leão", "Virgem", "Libra", "Escorpião", "Sagitário", "Capricórnio", "Aquário", "Peixes"};
    private String[] perfis = {"Ousadia e criatividade são suas principais virtudes. Você é confiante e costuma tomar a frente das situações e luta com unhas e dentes pelo o que quer.",
            "Você busca segurança e empenha-se para conquistar suas metas. É inteligente e possui raciocínio rápido, se destacando no trabalho.",
            "Tem facilidade para expressar suas opiniões e se adaptar a qualquer tipo de situação. Possui raciocínio rápido e procura sempre inovar.",
            "Você não costuma agir por impulso, pois prefere esperar o momento certo. É ambiciosa, busca o que deseja e tem pulso firme.",
            "Você é confiante e sabe demonstrar seus talentos. Faz de tudo para ser o centro das atenções e tem personalidade marcante.",
            "É disciplinado e se apega até aos mínimos detalhes. Insiste em seus planos para que eles sejam realizados como planejou e age de maneira prática.",
            "Se dar bem com todos à sua volta é essencial para você. Evita se envolver em intrigas para manter a harmonia e prefere ambientes tranquilos.",
            "É entusiasmada e dedicada em tudo o que faz. Precisa estar motivada para manter a produtividade. É uma mulher intensa e bastante compreensiva.",
            "Você é atraente e gosta de criar jeitos de sair da rotina. Costuma passar por cima dos problemas sem deixar que eles ganhem grandes proporções.",
            "Eficiência e dedicação são características marcantes em sua personalidade. Você sabe muito bem onde quer chegar e leva a sério seus compromissos.",
            "Você é criativa, vive à procura de ideias diferentes e gosta de inovar. Não tem medo de expressar suas opiniões e contestar regras.",
            "Você costuma oferecer ajuda a quem precisa e todos a enxergam como uma mulher companheira. É sonhadora, amorosa, dedicada e carinhosa."};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        listaSignos = findViewById(R.id.listViewId);

        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(
                getApplicationContext(),
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                signos
        );
        listaSignos.setAdapter(adaptador);
        listaSignos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int codigoPosicao = position;
                Toast.makeText(getApplicationContext(),perfis[codigoPosicao],Toast.LENGTH_SHORT).show();
            }
        });


    }
}
