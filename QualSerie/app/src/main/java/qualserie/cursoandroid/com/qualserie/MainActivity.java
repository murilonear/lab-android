package qualserie.cursoandroid.com.qualserie;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {
    private SeekBar seekBarMedidor;
    private ImageView imagemDinamica;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        seekBarMedidor = findViewById(R.id.seekBarMedidorId);
        imagemDinamica = findViewById(R.id.imageDinamicId);

        seekBarMedidor.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int valorProgresso = progress;
                if(valorProgresso ==1){
                    imagemDinamica.setImageResource(R.drawable.pouco);
                }else if(valorProgresso ==2){
                    imagemDinamica.setImageResource(R.drawable.medio);
                }else if(valorProgresso == 3){
                    imagemDinamica.setImageResource(R.drawable.muito);
                }else if(valorProgresso ==4 ){
                    imagemDinamica.setImageResource(R.drawable.susto);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}
