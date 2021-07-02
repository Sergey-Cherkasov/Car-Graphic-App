package com.example.cargraphicapp

import android.os.Bundle
import android.transition.ArcMotion
import android.transition.ChangeBounds
import android.transition.TransitionManager
import android.view.Gravity
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private var toRightAnimation = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        car_view.setOnClickListener {
            val changeBounds = ChangeBounds()
            changeBounds.pathMotion = ArcMotion()
            changeBounds.duration = 5000
            TransitionManager.beginDelayedTransition(
                transition_container,
                changeBounds
            )
            toRightAnimation = !toRightAnimation
            val params = car_view.layoutParams as FrameLayout.LayoutParams
            params.gravity =
                if (toRightAnimation) {
                    Gravity.END or Gravity.BOTTOM
                } else {
                    Gravity.START or Gravity.TOP
                }
            car_view.layoutParams = params
        }
    }
}