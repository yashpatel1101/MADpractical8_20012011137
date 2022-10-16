package com.example.madpractical8_20012011137

import android.content.Intent
import android.graphics.drawable.AnimationDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView

class SplashActivity : AppCompatActivity(), Animation.AnimationListener {
    lateinit var guni_image : ImageView
    lateinit var logo_frameByFrameAnimation : AnimationDrawable
    lateinit var twinAnimation : Animation
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        guni_image = findViewById(R.id.guniImage)
        guni_image.setBackgroundResource(R.drawable.uvpce_logo_list)

        logo_frameByFrameAnimation = guni_image.background as AnimationDrawable

        twinAnimation = AnimationUtils.loadAnimation(this, R.anim.twin_animation)
        twinAnimation.setAnimationListener(this)
    }

    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)

        if(hasFocus){
            logo_frameByFrameAnimation.start()
            guni_image.startAnimation(twinAnimation)
        }
        else{
            logo_frameByFrameAnimation.stop()
        }
    }

    override fun onAnimationStart(p0: Animation?) {

    }

    override fun onAnimationEnd(p0: Animation?) {
        Intent(this, MainActivity::class.java).also {
            startActivity(it)
            overridePendingTransition(R.anim.scale_center_in, R.anim.scale_center_out)
            finish()
        }
    }

    override fun onAnimationRepeat(p0: Animation?) {

    }
}