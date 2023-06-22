package com.sevvalekinci.kelimekart

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var wordTextView: TextView
    private lateinit var translateButton: Button
    private lateinit var changeButton: Button

    private val words: Array<String> = arrayOf(
        "apple", "banana", "cat", "dog", "elephant" // İngilizce kelimeleri buraya ekleyin
        // ...
    )

    private val translations: Array<String> = arrayOf(
        "elma", "muz", "kedi", "köpek", "fil" // Türkçe anlamları buraya ekleyin
        // ...
    )

    private var currentIndex = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        wordTextView = findViewById(R.id.wordTextView)
        translateButton = findViewById(R.id.translateButton)
        changeButton = findViewById(R.id.changeButton)

        showWord(currentIndex)

        translateButton.setOnClickListener {
            showTranslation()
        }

        changeButton.setOnClickListener {
            showNextWord()
        }
    }

    private fun showWord(index: Int) {
        val word = words[index]
        wordTextView.text = word
    }

    private fun showTranslation() {
        val translation = translations[currentIndex]
        wordTextView.text = translation
    }

    private fun showNextWord() {
        currentIndex = (currentIndex + 1) % words.size
        showWord(currentIndex)
    }
}
