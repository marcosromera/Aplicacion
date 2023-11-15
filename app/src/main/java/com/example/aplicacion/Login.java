package com.example.aplicacion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;

/**
 * @author marcos
 */
    public class Login extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ImageView mGirl=findViewById(R.id.girl);

        Glide.with(this)
                //.load(aqui se introduce la url)
                .load(R.drawable.girl)
                .transition(DrawableTransitionOptions.withCrossFade(2000))  //muestra la imagen lentamente
                .centerCrop()
                //.circleCrop()
                //.placeholder(new ColorDrawable(this.getResources().getColor(R.color.teal_200)))
                .into(mGirl);
    }

    public void openMain(View v){
        Intent intent=new Intent(Login.this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }

    public void openSignup(View v){
        Intent intent=new Intent(Login.this, Signup.class);
        startActivity(intent);
    }
    

}