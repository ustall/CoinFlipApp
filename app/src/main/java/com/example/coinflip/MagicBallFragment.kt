package com.example.coinflip

import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment


class MagicBallFragment : Fragment(R.layout.magic_ball_fragment) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val resultText: TextView = view.findViewById(R.id.resultText)
        val flipButton: Button = view.findViewById(R.id.flipButton)

        // Загрузка массива предсказаний из ресурсов
        val predictions = resources.getStringArray(R.array.predictions)

        // Анимация из ресурсов
        val fadeAnimation = AnimationUtils.loadAnimation(context, R.anim.simple_fade_anim)

        flipButton.setOnClickListener {
            // Запуск анимации
            resultText.startAnimation(fadeAnimation)

            // Изменение текста после анимации
            resultText.postDelayed({
                val randomPrediction = predictions.random()
                resultText.text = randomPrediction
            }, 150) // Изменение текста через 150 мс
        }
    }
}