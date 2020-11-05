package com.example.catchpokemon

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide

class CatchPokemon : AppCompatActivity() {
    private var point: HashSet<Int> = HashSet()
    private var startingPositionX = 0
    private var startingPositionY = 0
    private lateinit var textviewResult: TextView
    private var finalResult: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.button).setOnClickListener {

            val userInput = findViewById<EditText>(R.id.editTextPath).text
            finalResult = catchPokemon(userInput.toString())
            showResult(finalResult)
            hideKeyboard(it)
            reset()
        }
        addGif()
    }

    private fun reset() {
        point.clear()
        finalResult = 0
    }

    private fun addGif() {
        val imageView: ImageView = findViewById(R.id.imageView)
        Glide
            .with(this)
            .load(R.drawable.pokemons)
            .into(imageView)
    }

    fun catchPokemon(input: String?): Int {
        point.add(0)

        if (input == null) return point.size
        input.let {
            for (i in input.trim()) {
                when (i.toUpperCase()) {
                    'N' -> startingPositionY++
                    'S' -> startingPositionY--
                    'E' -> startingPositionX++
                    'O' -> startingPositionX--
                }
                point.add(startingPositionX + startingPositionY)
            }
            return point.size
        }
    }

    @SuppressLint("SetTextI18n")
    private fun showResult(result: Int) {
        textviewResult = findViewById(R.id.textView2)
        textviewResult.visibility = View.VISIBLE
        textviewResult.text = "Captured Pokémons: $result"
    }

    private fun hideKeyboard(view: View) {
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}