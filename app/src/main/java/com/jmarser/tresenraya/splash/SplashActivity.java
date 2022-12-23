package com.jmarser.tresenraya.splash;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.jmarser.tresenraya.R;
import com.jmarser.tresenraya.addPlayers.AddPlayersActivity;
import com.jmarser.tresenraya.databinding.ActivitySplashBinding;

public class SplashActivity extends AppCompatActivity {

    private ActivitySplashBinding binding;

    //Variables de las animaciones
    private Animation topAnim;
    private Animation leftAnim;
    private Animation rightAnim;
    private Animation bottomAnim;
    private Animation authorAnim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySplashBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //Quitamos la barra de notificaciones del sistema.
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        //Asignamos los layouts de las animaciones a las variables
        topAnim = AnimationUtils.loadAnimation(this, R.anim.splash_top_animation);
        leftAnim = AnimationUtils.loadAnimation(this, R.anim.splash_left_animation);
        rightAnim = AnimationUtils.loadAnimation(this, R.anim.splash_right_animation);
        bottomAnim = AnimationUtils.loadAnimation(this, R.anim.splash_bottom_animation);
        authorAnim = AnimationUtils.loadAnimation(this, R.anim.splash_author_animation);

        //Asignamos las animaciones a los elementos de la vista
        binding.tvTic.setAnimation(leftAnim);
        binding.tvTac.setAnimation(topAnim);
        binding.tvToe.setAnimation(rightAnim);
        binding.imgFondo.setAnimation(bottomAnim);
        binding.author.setAnimation(authorAnim);

        //Programamos que pasados 4 segundos salgamos de esta activity y vayyamos a la activiti de agregar jugadores
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(SplashActivity.this, AddPlayersActivity.class));
                finish(); //Terminamos esta actividad para que no podamos volver a ella con el botón de atrás.
            }
        }, 4000);
    }
}