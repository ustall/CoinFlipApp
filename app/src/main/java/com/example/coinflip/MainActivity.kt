package com.example.coinflip

import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Показать YesNoFragment при старте
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, YesNoFragment())
            .commit()

        val bottomNavigationView: BottomNavigationView = findViewById(R.id.bottomNavigationView)
        bottomNavigationView.selectedItemId = R.id.nav_coin_flip
        bottomNavigationView.setOnItemSelectedListener { menuItem ->
            val fragmentManager = supportFragmentManager
            val transaction = fragmentManager.beginTransaction()

            // Задаем анимации в зависимости от направления
            when (menuItem.itemId) {
                R.id.nav_coin_flip -> {
                    transaction.setCustomAnimations(
                        R.anim.slide_in_right_fast,
                        R.anim.slide_out_to_left_fast
                    )
                    transaction.replace(R.id.fragmentContainer, YesNoFragment())
                }

                R.id.nav_random_number -> {
                    transaction.setCustomAnimations(
                        R.anim.slide_in_right_fast,
                        R.anim.slide_out_to_left_fast
                    )
                    transaction.replace(R.id.fragmentContainer, RandomNumberFragment())
                }

                R.id.nav_magic_ball -> {
                    transaction.setCustomAnimations(
                        R.anim.slide_in_left_fast,
                        R.anim.slide_out_to_right_fast
                    )
                    transaction.replace(R.id.fragmentContainer, MagicBallFragment())
                }

                else -> return@setOnItemSelectedListener false
            }

            transaction.commit()
            true
        }
        // Инициализируем LanguageManager
        var languageManager = LanguageManager(this)

        val languageButton: ImageButton = findViewById(R.id.languageButton)
        languageButton.setOnClickListener {
            // Показываем меню выбора языка
            languageManager.showLanguageMenu(it)
        }

    }
}
