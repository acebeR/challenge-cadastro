package com.example.rebecadivina.challenge;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/*

O desafio é escrever uma aplicação android que terá duas atividades - Atividade A e B.

A Atividade A conterá dois widgets EditText para e-mail e senha e um widget de botão.

Quando um usuário insere e-mail e senha e clica no botão, o que quer que o usuário tenha inserido
ser exibido na Atividade B em um widget TextView.

 */
public class MainChallenge extends Activity implements View.OnClickListener{

    Button btnResp;
    Intent intent;
    EditText txtEmail;
    EditText txtSenha;
    TextView txtErro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_challenge);

        btnResp = findViewById(R.id.btnResp);
        btnResp.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        Button btn = findViewById(v.getId());
        String valida = "false";

        if(btn != null){

            txtEmail = (EditText) findViewById(R.id.txtEmail);
            txtErro = (TextView) findViewById(R.id.txtErro);
            txtSenha = (EditText) findViewById(R.id.txtSenha);
            valida = validateEmailFormat(txtEmail.getText().toString());

            if((!txtEmail.getText().toString().equals("")) && (!txtSenha.getText().toString().equals(""))){
                if(valida.equals("false")){
                    txtErro.setText("Email Incorreto!");
                }else {

                    intent = new Intent(MainChallenge.this, MainActivity.class);
                    intent = new Intent(this, MainActivity.class);

                    intent.putExtra("email",txtEmail.getText().toString());
                    intent.putExtra("senha",txtSenha.getText().toString());

                    startActivity(intent);
                }
            }else{
                txtErro.setText("Complete os campos");
            }



        }

    }
    private String validateEmailFormat(final String email) {
        if (android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            return "true";
        }
        return "false";
    }
}
