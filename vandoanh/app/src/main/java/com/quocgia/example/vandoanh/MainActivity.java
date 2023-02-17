package com.quocgia.example.vandoanh;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    public static ArrayList<String> arrayImg;
    EditText input;
    TextView output,txt1,txt2;
    Button seach, reset,doi;
    ImageView img;
    int av = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        img = (ImageView) findViewById(R.id.imageView2);
        input= (EditText) findViewById(R.id.editTextTextPersonName);
        txt1 = (TextView) findViewById(R.id.textView);
        txt2 = (TextView) findViewById(R.id.textView2);
        output= (TextView) findViewById(R.id.textView4);
        doi= (Button) findViewById(R.id.button);
        seach= (Button) findViewById(R.id.button2);
        reset= (Button) findViewById(R.id.button3);

        String [] mangTen = getResources().getStringArray(R.array.list_EN);

        String [] mangNghia = getResources().getStringArray(R.array.list_VN);

        String [] mangAnh = getResources().getStringArray(R.array.list_IMG);

        arrayImg = new ArrayList<>(Arrays.asList(mangAnh));

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                input.setText("");
                output.setText("");
            }
        });
        doi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(av == 1){
                    av = 0;
                    txt1.setText("Việt");
                    txt2.setText("Anh");
                }else{
                    av = 1;
                    txt1.setText("Anh");
                    txt2.setText("Việt");
                }
            }
        });

        seach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(av == 1){
                    for(int i = 0; i< mangTen.length; i++){

                        if( input.getText().toString().equalsIgnoreCase(mangTen[i]) ){
                            output.setText(mangNghia[i]);
                            int image = getResources().getIdentifier(MainActivity.arrayImg.get(i), "drawable", getPackageName());
                            img.setImageResource(image);
                            return;
                        }
                    }
                    output.setText("");
                    Toast.makeText(MainActivity.this, "từ khóa chưa được câp nhật", Toast.LENGTH_SHORT).show();
                }else{
                    for(int i = 0; i< mangTen.length; i++){

                        if( input.getText().toString().equalsIgnoreCase(mangNghia[i]) ){
                            output.setText(mangTen[i]);
                            int image = getResources().getIdentifier(MainActivity.arrayImg.get(i), "drawable", getPackageName());
                            img.setImageResource(image);
                            return ;
                        }

                    }
                    output.setText("");
                    Toast.makeText(MainActivity.this, "từ khóa chưa được câp nhật", Toast.LENGTH_SHORT).show();
                }



            }
        });
    }
}