package com.example.hellokids;
//ANIMAL OPTIONS
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity3 extends AppCompatActivity {
    VideoView v1, v2, v3;
    String v1path, v2path, v3path;
    ImageButton v11, v22, v33;
    MediaController mediaController, mediaController1, mediaController2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        //FIND IDS
        v11 = findViewById(R.id.v11);
        v22 = findViewById(R.id.v22);
        v33 = findViewById(R.id.v33);
        v1 = findViewById(R.id.v1);
        v2 = findViewById(R.id.v2);
        v3 = findViewById(R.id.v3);

        //SET CONTROLLER TO VEDIO
        mediaController = new MediaController(this);
        mediaController1 = new MediaController(this);
        mediaController2 = new MediaController(this);

        //PLAY FIRST VEDIO
        v11.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                v11.setVisibility(v.INVISIBLE);
                v1.setVisibility(v.VISIBLE);

                v22.setVisibility(v.VISIBLE);
                v33.setVisibility(v.VISIBLE);
                v2.setVisibility(v.INVISIBLE);
                v3.setVisibility(v.INVISIBLE);

                v1path = "android.resource://" + getPackageName() + "/" + R.raw.mammals;
                Uri uri = Uri.parse(v1path);
                v1.setVideoURI(uri);
                v1.setMediaController(mediaController);
                mediaController.setAnchorView(v1);

                v1.start();
            }
        });

        //PLAY SECOND VEDIO
        v22.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                v22.setVisibility(v.INVISIBLE);
                v2.setVisibility(v.VISIBLE);

                v11.setVisibility(v.VISIBLE);
                v33.setVisibility(v.VISIBLE);
                v1.setVisibility(v.INVISIBLE);
                v3.setVisibility(v.INVISIBLE);

                v2path = "android.resource://" + getPackageName() + "/" + R.raw.bird;
                Uri uri1 = Uri.parse(v2path);
                v2.setVideoURI(uri1);
                v2.setMediaController(mediaController1);
                mediaController.setAnchorView(v2);


                v2.start();
            }
        });

        //PLAY THIRD VEDIO
        v33.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                v33.setVisibility(v.INVISIBLE);
                v3.setVisibility(v.VISIBLE);

                v11.setVisibility(v.VISIBLE);
                v22.setVisibility(v.VISIBLE);
                v1.setVisibility(v.INVISIBLE);
                v2.setVisibility(v.INVISIBLE);

                v3path = "android.resource://" + getPackageName() + "/" + R.raw.fish;
                Uri uri2 = Uri.parse(v3path);
                v3.setVideoURI(uri2);
                v3.setMediaController(mediaController2);
                mediaController.setAnchorView(v3);

                v3.start();
            }
        });


    }
}