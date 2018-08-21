package com.example.rebecadivina.challenge;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements View.OnClickListener{

    Button btnVoltar;
    Intent intent;
    TextView lbRespEmail;
    TextView lbRespSenha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnVoltar = findViewById(R.id.btnVoltar);
        btnVoltar.setOnClickListener(this);

        lbRespEmail = (TextView) findViewById(R.id.lbRespEmail);
        lbRespSenha = (TextView) findViewById(R.id.lbRespSenha);

         /*
            Inicializar com os valores
         */

        Intent intent = getIntent();
        String email = intent.getStringExtra("email");
        String senha = intent.getStringExtra("senha");
        lbRespEmail.setText(email);
        lbRespSenha.setText(senha);

        /*
            ----------------------------
         */


    }

    @Override
    public void onClick(View v) {
        Button btn = findViewById(v.getId());


        if(btn != null){
            intent = new Intent(this, MainChallenge.class);
            startActivity(intent);
        }
    }
}
