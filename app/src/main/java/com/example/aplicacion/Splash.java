package com.example.aplicacion;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        openApp();


        //animacion logo
        ImageView thunder = findViewById(R.id.logosplash);
        Animation myanim = AnimationUtils.loadAnimation(this, R.anim.blink);
        thunder.startAnimation(myanim);



        ImageView fondo=findViewById(R.id.fondo);
        Glide.with(this)
                .load("https://img3.wallspic.com/previews/2/4/1/1/7/171142/171142-la_vida_extraterrestre-el_minimalismo-arte-ambiente-edificio-500x.jpg")
                .transition(DrawableTransitionOptions.withCrossFade(50))
                .centerCrop()
                //.diskCacheStrategy(DiskCacheStrategy.ALL)
                .placeholder(new ColorDrawable(this.getResources().getColor(R.color.teal_200)))
                .into(fondo);

    }


    private void openApp(){
        Handler handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(Splash
                        .this, Login.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
            }
        },5000);
    }
}
