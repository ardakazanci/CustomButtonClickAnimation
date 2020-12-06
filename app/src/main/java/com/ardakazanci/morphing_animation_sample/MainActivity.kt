package com.ardakazanci.morphing_animation_sample

import android.graphics.drawable.AnimatedVectorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.core.content.res.ResourcesCompat
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat

class MainActivity : AppCompatActivity() {

    private lateinit var animatedVectorDrawable: AnimatedVectorDrawable
    private lateinit var animatedVectorDrawableCompat: AnimatedVectorDrawableCompat

    private var imageContainerPosition = 0

    private lateinit var imgContainer: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imgContainer = findViewById(R.id.imageContainer)

        imgContainer.setOnClickListener {

            if (imageContainerPosition == 0) {
                imgContainer.setImageDrawable(
                    ResourcesCompat.getDrawable(
                        resources,
                        R.drawable.avd_plus_to_minus,
                        null
                    )
                )

                val containerDrawable = imgContainer.drawable

                if (containerDrawable is AnimatedVectorDrawableCompat) {
                    animatedVectorDrawableCompat = containerDrawable
                    animatedVectorDrawableCompat.start()
                } else if (containerDrawable is AnimatedVectorDrawable) {
                    animatedVectorDrawable = containerDrawable
                    animatedVectorDrawable.start()
                }

                imageContainerPosition++

            } else {

                imgContainer.setImageDrawable(
                    ResourcesCompat.getDrawable(
                        resources,
                        R.drawable.avd_minus_to_plus,
                        null
                    )
                )

                val containerDrawable = imgContainer.drawable

                if (containerDrawable is AnimatedVectorDrawableCompat) {
                    animatedVectorDrawableCompat = containerDrawable
                    animatedVectorDrawableCompat.start()
                } else if (containerDrawable is AnimatedVectorDrawable) {
                    animatedVectorDrawable = containerDrawable
                    animatedVectorDrawable.start()
                }

                imageContainerPosition--

            }

        }


    }
}