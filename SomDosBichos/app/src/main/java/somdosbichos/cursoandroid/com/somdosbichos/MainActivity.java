package somdosbichos.cursoandroid.com.somdosbichos;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView cao;
    private ImageView gato;
    private ImageView ovelha;
    private ImageView leao;
    private ImageView macaco;
    private ImageView vaca;
    private MediaPlayer mediaPlayer;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        cao = findViewById(R.id.caoId);
        gato = findViewById(R.id.gatoId);
        ovelha = findViewById(R.id.ovelhaId);
        leao = findViewById(R.id.leaoId);
        macaco = findViewById(R.id.macacoId);
        vaca = findViewById(R.id.vacaId);

        cao.setOnClickListener(this);
        gato.setOnClickListener(this);
        ovelha.setOnClickListener(this);
        leao.setOnClickListener(this);
        macaco.setOnClickListener(this);
        vaca.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
       switch (v.getId()){
           case R.id.caoId:
               mediaPlayer = MediaPlayer.create(MainActivity.this,R.raw.cao);
               tocarSom();
               break;
           case R.id.gatoId:
               mediaPlayer = MediaPlayer.create(MainActivity.this,R.raw.gato);
               tocarSom();
               break;
           case R.id.ovelhaId:
               mediaPlayer = MediaPlayer.create(MainActivity.this,R.raw.ovelha);
               tocarSom();
               break;
           case R.id.leaoId:
               mediaPlayer = MediaPlayer.create(MainActivity.this,R.raw.leao);
               tocarSom();
               break;
           case R.id.macacoId:
               mediaPlayer = MediaPlayer.create(MainActivity.this,R.raw.macaco);
               tocarSom();
               break;
           case R.id.vacaId:
               mediaPlayer = MediaPlayer.create(MainActivity.this,R.raw.vaca);
               tocarSom();
               break;

       }
    }
    public void tocarSom(){
        if(mediaPlayer !=null){
            mediaPlayer.start();
        }
    }
    @Override
    protected void onDestroy() {
        if(mediaPlayer != null){
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer = null;
        }
        super.onDestroy();
    }
}
