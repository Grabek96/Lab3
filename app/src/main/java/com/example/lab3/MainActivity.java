package com.example.lab3;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;

import com.example.lab3.ui.login.LoginActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.provider.MediaStore;
import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    static final int REQUEST_IMAGE_CAPTURE = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intencja= new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intencja, REQUEST_IMAGE_CAPTURE);

                Toast.makeText(getApplicationContext(), "Kliknięto przycisk fab", Toast.LENGTH_SHORT).show();
               // Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                     //   .setAction("Action", null).show();
            }

        });

    }

    public void Kliknij(View view){
        Toast.makeText(getApplicationContext(),"Kliknięto przycisk Logowania",Toast.LENGTH_SHORT).show();
        Intent intencja= new Intent(getApplicationContext(), LoginActivity.class);
        startActivity(intencja);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Bundle extras = data.getExtras();
        Bitmap imageBitmap = (Bitmap) extras.get("data");
        ConstraintLayout lay = (ConstraintLayout)findViewById(R.id.cont);
        lay.setBackground(new BitmapDrawable(getResources(),imageBitmap));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        switch (id) {
            case R.id.action_settings:
                Toast.makeText(getApplicationContext(), "Kliknięto przycisk settings", Toast.LENGTH_SHORT).show();
                    break;
            case R.id.item1:
                Toast.makeText(getApplicationContext(), "Kliknięto przycisk item1", Toast.LENGTH_SHORT).show();
                break;
            case R.id.Item2:
                Toast.makeText(getApplicationContext(), "Kliknięto przycisk item2", Toast.LENGTH_SHORT).show();
                break;



        }

        return super.onOptionsItemSelected(item);
    }
    public void wylosujIkone (View view) {
        int rand = new Random().nextInt() % 5;

        ImageButton ikona = (ImageButton) view;

        if (rand == 0) {
            ikona.setImageDrawable(getResources().getDrawable(android.R.drawable.ic_menu_camera, getTheme()));
        } else if (rand == 1) {
            ikona.setImageDrawable(getResources().getDrawable(android.R.drawable.ic_media_rew, getTheme()));
        } else if (rand == 2) {
            ikona.setImageDrawable(getResources().getDrawable(android.R.drawable.ic_media_previous, getTheme()));
        } else if (rand == 3) {
            ikona.setImageDrawable(getResources().getDrawable(android.R.drawable.ic_menu_call, getTheme()));
        } else if (rand == 4) {
            ikona.setImageDrawable(getResources().getDrawable(android.R.drawable.ic_btn_speak_now, getTheme()));
        }
    }
}