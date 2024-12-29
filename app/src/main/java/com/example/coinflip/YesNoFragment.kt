package com.example.coinflip

import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import kotlin.random.Random

class YesNoFragment : Fragment(R.layout.yes_no_fragment) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val resultText: TextView = view.findViewById(R.id.resultText)
        val flipButton: Button = view.findViewById(R.id.flipButton)

        // Animation from resources
        val fadeAnimation = AnimationUtils.loadAnimation(context, R.anim.fade_in_out)

        flipButton.setOnClickListener {
            // Start animation
            resultText.startAnimation(fadeAnimation)

            // Change text after animation
            resultText.postDelayed({
                val randomResult = if (Random.nextBoolean()) getString(R.string.Yes) else getString(
                    R.string.No
                )
                resultText.text = randomResult
            }, 150) // Change text after 150 ms
        }
    }
}