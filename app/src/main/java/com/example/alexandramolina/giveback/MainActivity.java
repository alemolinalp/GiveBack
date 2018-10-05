package com.example.alexandramolina.giveback;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void abrirPrincipalActivity(View v){
        Intent intent = new Intent(this, TabActivity.class);
        startActivity(intent);
    }
    public void abrirRegistrarseActivity(View v){
        Intent intent = new Intent(this, RegistrarseActivity.class);
        startActivity(intent);
    }
}
