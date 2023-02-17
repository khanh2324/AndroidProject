package com.example.translateeng_vni;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button eng, vni, exit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Anhxa();
        exit.setOnClickListener(view -> System.exit(0));
        eng.setOnClickListener(view -> {
            Intent intent1 = new Intent(MainActivity.this, eng_vni.class);
            startActivity(intent1);

        });
        vni.setOnClickListener(view -> {
            Intent intent2 = new Intent(MainActivity.this, vni_eng.class);
            startActivity(intent2);

        });

    }

    public void Anhxa(){
        eng = (Button) findViewById(R.id.ENG);
        vni = (Button) findViewById(R.id.VNI);
        exit = (Button) findViewById(R.id.Close);
    }
}