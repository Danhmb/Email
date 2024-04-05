package haddad.maia.barbosa.email;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

//imports
public class MainActivity extends AppCompatActivity {
    //Classe da tela principal

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Cria elementos de interface

        Button btnEnviar = findViewById(R.id.btnEnviar);
        //Pega o botão principal pelo id
        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            //Define um evento quando o botão é clicado
            public void onClick(View v) {
                EditText etEmail = findViewById(R.id.etEmail);
                //Pega o campo de texto do email pelo id

                String email = etEmail.getText().toString();
                //Pega o texto dentro do email e converte para string

                EditText etTexto = findViewById(R.id.etTexto);
                //Pega o campo de texto do email pelo id

                String texto = etTexto.getText().toString();
                //Pega o texto dentro do email e converte para string

                EditText etAssunto = findViewById(R.id.etAssunto);
                //Pega o campo de texto do email pelo id

                String assunto = etAssunto.getText().toString();
                //Pega o texto dentro do email e converte para string

                Intent i = new Intent(Intent.ACTION_SENDTO);
                //cria a intenção sem destino especificado

                i.setData(Uri.parse("mailto:"));
                //A intenção diz que queremos somente os apps tipo email


                String[] emails = new String[]{email};
                //Cria lista de string de emails

                i.putExtra(Intent.EXTRA_EMAIL, emails);
                i.putExtra(Intent.EXTRA_SUBJECT, assunto);
                i.putExtra(Intent.EXTRA_TEXT, texto);
                //Guarda os dados no intent para envia-los

                try {
                    startActivity(Intent.createChooser(i, "Escolha o app"));
                }catch (ActivityNotFoundException e){
                    Toast.makeText(MainActivity.this, "Não há nenhum app que possa realizar essa operação", Toast.LENGTH_LONG).show();
                }
                /*

                tenta abrir uma aba de opções para o usuário escolher entre os apps,
                caso não tenha um  o sistema ira dizer "Não há nenhum app que possa realizar essa operação"

                 */



            }
        });
    }
}