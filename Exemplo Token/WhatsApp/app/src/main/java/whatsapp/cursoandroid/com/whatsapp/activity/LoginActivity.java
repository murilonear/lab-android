package whatsapp.cursoandroid.com.whatsapp.activity;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.github.rtoshiro.util.format.SimpleMaskFormatter;
import com.github.rtoshiro.util.format.text.MaskTextWatcher;

import java.util.HashMap;
import java.util.Random;

import whatsapp.cursoandroid.com.whatsapp.R;
import whatsapp.cursoandroid.com.whatsapp.helper.Permissao;
import whatsapp.cursoandroid.com.whatsapp.helper.Preferencias;

public class LoginActivity extends AppCompatActivity {
    private EditText nome;
    private EditText telefone;
    private EditText codPais;
    private EditText codArea;
    private Button cadastrar;
    private String [] permissoesNecessarias = new String[]{
      Manifest.permission.SEND_SMS,
            Manifest.permission.INTERNET
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Permissao.validaPermissões(1,this,permissoesNecessarias);
        telefone = findViewById(R.id.edit_telefone);
        nome = findViewById(R.id.edit_nome);
        codArea = findViewById(R.id.edit_cod_area);
        codPais = findViewById(R.id.edit_cod_pais);
        cadastrar = findViewById(R.id.bt_cadastrar);

        // Definir as mascaras
        SimpleMaskFormatter simpleMaskCodPais = new SimpleMaskFormatter("+NN");
        SimpleMaskFormatter simpleMaskCodArea = new SimpleMaskFormatter("NN");
        SimpleMaskFormatter simpleMaskTelefone = new SimpleMaskFormatter("NNNNN-NNNN");

        MaskTextWatcher maskTelefone = new MaskTextWatcher(telefone, simpleMaskTelefone);
        MaskTextWatcher maskCodPais = new MaskTextWatcher(codPais, simpleMaskCodPais);
        MaskTextWatcher maskCodArea = new MaskTextWatcher(codArea, simpleMaskCodArea);

        telefone.addTextChangedListener(maskTelefone);
        codPais.addTextChangedListener(maskCodPais);
        codArea.addTextChangedListener(maskCodArea);

        cadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nomeUsuario = nome.getText().toString();
                String telefoneCompleto = codPais.getText().toString() +
                        codArea.getText().toString() +
                        telefone.getText().toString();
                // Remover a formatação, usando replace
                String telefoneSemFormatacao = telefoneCompleto.replace("+", "");
                telefoneSemFormatacao = telefoneSemFormatacao.replace("-", "");
                // Log.i("TELEFONE","T:"+telefoneSemFormatacao);


                /* Gerar token // Por ser apenas um teste, o token será gerado no proprio app,
                 o correto seria ser gerado dentro de um servidor web*/
                Random randomico = new Random();
                int numeroRandomico = randomico.nextInt(9999 - 1000) + 1000;
                String token = String.valueOf(numeroRandomico);
                String mensagemEnvio = "Whatsapp Código de Confirmação: "+token;
                // Log.i("TOKEN", "T:" + token);


                // Salvar os dados para validação
                Preferencias preferencias = new Preferencias(getApplicationContext());
                preferencias.salvarUsuarioPreferencias(nomeUsuario, telefoneSemFormatacao, token);

                // Envio do SMS
                //telefoneSemFormatacao = "5554";
                boolean enviadoSMS = enviaSMS("+"+telefoneSemFormatacao, mensagemEnvio );
                if( enviadoSMS ){
                    Intent intent = new Intent(LoginActivity.this, ValidadorActivity.class);
                    startActivity(intent);
                    finish();
                }else{
                    Toast.makeText(LoginActivity.this, "Problema ao enviar o SMS, tente novamente!", Toast.LENGTH_LONG).show();
                }

               /*
                HashMap<String, String> usuario = preferencias.getDadosUsuario();
                Log.i("TOKEN","T:" +usuario.get("token"));  */

            }
        });

    }

    // Envio do SMS
    private boolean enviaSMS(String telefone, String mensagem){
        try {
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(telefone, null, mensagem, null, null);
            return  true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
    public void onRequestPermissionsResult(int requestCode, String [] permissions, int[] grantResults){
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        for (int resultado: grantResults){
            if(resultado == PackageManager.PERMISSION_DENIED){
                alertaValidacaoPermissao();
            }

        }
    }
    private void alertaValidacaoPermissao(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Permissões negadas");
        builder.setMessage("Para utilizar esse app, é necessário aceitar as permissões");
        builder.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}
