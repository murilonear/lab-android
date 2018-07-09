package sqlite.cursoandroid.com.sqlite;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        try {
            SQLiteDatabase bancoDados = openOrCreateDatabase("app", MODE_PRIVATE, null);

            // tabela
            bancoDados.execSQL("CREATE TABLE IF NOT EXISTS pessoas(id INTEGER PRIMARY KEY AUTOINCREMENT,nome VARCHAR, idade INT(3))");
            //bancoDados.execSQL("DROP TABLE pessoas");
            // inserir dados na tabela
           /*bancoDados.execSQL("INSERT INTO pessoas (nome, idade) VALUES ('Marcos', 30)");// Inserir dados
            bancoDados.execSQL("INSERT INTO pessoas (nome,idade) VALUES ('Ana', 20)");
            bancoDados.execSQL("INSERT INTO pessoas (nome,idade) VALUES ('Kayo', 19)");
            bancoDados.execSQL("INSERT INTO pessoas (nome,idade)VALUES ('Kauê', 10)");
            bancoDados.execSQL("INSERT INTO pessoas (nome,idade)VALUES('Jhon',60)");*/
          // bancoDados.execSQL("UPDATE pessoas SET nome = 'Mariana' WHERE id = 3"); //Atualizar dados
            //bancoDados.execSQL("DELETE FROM pessoas WHERE nome ='Ana'"); // Apagar pessoas

            // Para recuperar estes dados
            Cursor cursor = bancoDados.rawQuery("SELECT * FROM pessoas ", null);
            // Recuperar indices das colunas
            int indiceColunaNome = cursor.getColumnIndex("nome");
            int indiceColunaIdade = cursor.getColumnIndex("idade");
            int indiceColunaId = cursor.getColumnIndex("id");
            cursor.moveToFirst();

            while (cursor != null) {
                // Para fazer a exibicao

                Log.i("RESULTADO - nome: ", cursor.getString(indiceColunaNome));
                Log.i("RESULTADO - idade: ", cursor.getString(indiceColunaIdade));
                Log.i("Resultado - ID: ",cursor.getString(indiceColunaId));
                //cursor.getString(indiceColunaNome);
                //cursor.getString(indiceColunaIdade);
                cursor.moveToNext();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
