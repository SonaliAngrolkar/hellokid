package com.example.hellokids;
//OPTION PAGE BACKEND (ANIMAL OR HUMAN BODY)
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class MainActivity2 extends AppCompatActivity {
    LinearLayout animal, humanbody;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        //FIND IDS
        animal = findViewById(R.id.animal);
        humanbody = findViewById(R.id.humanbody);

        //GO TO ANIMAL OPTION
        animal.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity2.this, MainActivity3.class);
                startActivity(i);
            }
        });

        //GO TO HUMANBODY OPTION
        humanbody.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity2.this, MainActivity4.class);
                startActivity(i);
            }
        });
    }
}