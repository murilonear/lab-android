package caracoroa.cursoandroid.com.caraoucoroa;

import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class DetalheActivity extends AppCompatActivity {
    public ImageView moeda;
    public ImageView botaoVoltar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe);
        getSupportActionBar().hide();

        moeda = findViewById(R.id.moedaId);
        botaoVoltar = findViewById(R.id.botaoVoltarId);

        Bundle extra = getIntent().getExtras();
        if(extra != null){
            String opcaoEscolhida = extra.getString("escolhido");
            if(opcaoEscolhida.equals("cara")){
                // exibi cara
                moeda.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.moeda_cara));

            }else{
                // exibi coroa
                moeda.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.moeda_coroa));

            }
        }


        botaoVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }
}
