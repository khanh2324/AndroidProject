package com.example.translateeng_vni;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class eng_vni extends AppCompatActivity {
    Button home, tra;
    ImageView hinhanh;
    TextView phatam, vni;
    EditText input;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.eng_vni);
        Anhxa();
        String[] mangENG = getResources().getStringArray(R.array.list_EN);
        String[] mangVNI = getResources().getStringArray(R.array.list_VN);
        String[] mangIMG = getResources().getStringArray(R.array.list_IMG);
        String[] mangAm = getResources().getStringArray(R.array.list_AM);
        home.setOnClickListener(view -> {
            Intent intent = new Intent(eng_vni.this, MainActivity.class);
            startActivity(intent);
        });
        tra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (int i = 0; i < mangENG.length; i++) {
                    if (input.getText().toString().trim().equals(mangENG[i])) {
                        phatam.setText(mangAm[i]);
                        vni.setText(mangVNI[i]);
                        int idHinh = getResources().getIdentifier(mangIMG[i], "drawable", getPackageName());
                        hinhanh.setImageResource(idHinh);
                        break;

                    }
                }
            }
        });

    }

    public void Anhxa() {
        home = (Button) findViewById(R.id.home);
        tra = (Button) findViewById(R.id.tra);
        phatam = (TextView) findViewById(R.id.phatam);
        vni = (TextView) findViewById(R.id.vni);
        hinhanh = (ImageView) findViewById(R.id.imageView);
        input = (EditText) findViewById(R.id.input);
    }
}