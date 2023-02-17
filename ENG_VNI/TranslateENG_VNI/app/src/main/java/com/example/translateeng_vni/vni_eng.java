package com.example.translateeng_vni;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

public class vni_eng extends AppCompatActivity {
    Button home, tra;
    ImageView hinhanh;
    TextView phatam, eng;
    EditText input;
    public static ArrayList<String> arrayhinh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vni_eng);
        Anhxa();
        String[] mangANH = getResources().getStringArray(R.array.list_EN);

        String[] mangVIET = getResources().getStringArray(R.array.list_VN);

        String[] mangHINH = getResources().getStringArray(R.array.list_IMG);
        String[] mangNGU = getResources().getStringArray(R.array.list_AM);
        arrayhinh = new ArrayList<>(Arrays.asList(mangHINH));
        home.setOnClickListener(view -> {
            Intent intent = new Intent(vni_eng.this, MainActivity.class);
            startActivity(intent);
        });
        tra.setOnClickListener(view -> {
            for (int i = 0; i < mangVIET.length - 1; i++) {
                if (input.getText().toString().equals(mangVIET[i])) {
                    phatam.setText(mangNGU[i]);
                    eng.setText(mangANH[i]);
                    int idHinh = getResources().getIdentifier(vni_eng.arrayhinh.get(i), "drawable", getPackageName());
                    hinhanh.setImageResource(idHinh);
                    break;

                }
            }
        });
    }

    public void Anhxa() {
        home = (Button) findViewById(R.id.home);
        tra = (Button) findViewById(R.id.tra);
        phatam = (TextView) findViewById(R.id.phatam);
        eng = (TextView) findViewById(R.id.eng);
        hinhanh = (ImageView) findViewById(R.id.imageView);
        input = (EditText) findViewById(R.id.input);
    }
}