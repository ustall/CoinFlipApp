package com.example.coinflip

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import kotlin.random.Random

class RandomNumberFragment : Fragment(R.layout.random_number_fragment) {
    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val minValueInput: EditText = view.findViewById(R.id.minValueInput)
        val maxValueInput: EditText = view.findViewById(R.id.maxValueInput)
        val generateButton: Button = view.findViewById(R.id.generateButton)
        val resultText: TextView = view.findViewById(R.id.resultText)
        val fadeAnimation = AnimationUtils.loadAnimation(context, R.anim.simple_fade_anim)

        generateButton.setOnClickListener {
            var minValue = minValueInput.text.toString().toIntOrNull() ?: 0
            var maxValue = maxValueInput.text.toString().toIntOrNull() ?: 100
            resultText.startAnimation(fadeAnimation)
            if (maxValue >= 1000000) {
                maxValue = 1000000
                maxValueInput.setText(maxValue.toString())
            }
            if (minValue <= -1000000) {
                maxValue = -1000000
                maxValueInput.setText(maxValue.toString())
            }
            if (minValue <= maxValue) {
                val randomValue = Random.nextInt(minValue, maxValue + 1)
                resultText.postDelayed({
                    resultText.text = randomValue.toString()
                }, 150)
            } else {
                resultText.text = getString(R.string.invalid_range)
            }
        }
    }
}