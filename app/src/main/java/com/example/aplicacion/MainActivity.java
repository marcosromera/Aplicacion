package com.example.aplicacion;

import androidx.appcompat.app.AppCompatActivity;
import android.content.res.Configuration;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Locale;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView alienMain = findViewById(R.id.alienMain);

        Glide.with(this)
                .load(R.drawable.alien)
                .transition(DrawableTransitionOptions.withCrossFade(50))
                .centerCrop()
                .placeholder(new ColorDrawable(this.getResources().getColor(R.color.purple_200)))
                .into(alienMain);
    }



}
