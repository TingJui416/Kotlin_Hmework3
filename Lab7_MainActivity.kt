package com.example.lab7

import android.os.Bundle
import android.widget.Button
import android.widget.SeekBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private var progressRabbit = 0
    private var progressTurtle = 0
    private lateinit var btnStart: Button
    private lateinit var sbRabbit: SeekBar
    private lateinit var sbTurtle: SeekBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnStart = findViewById(R.id.btnStart)
        sbRabbit = findViewById(R.id.sbRabbit)
        sbTurtle = findViewById(R.id.sbTurtle)

        btnStart.setOnClickListener {
            btnStart.isEnabled = false
            progressRabbit = 0
            progressTurtle = 0
            sbRabbit.progress = 0
            sbTurtle.progress = 0

            lifecycleScope.launch { runRabbit() }
            lifecycleScope.launch { runTurtle() }
        }
    }

    private suspend fun runRabbit() {
        val sleepProbability = arrayOf(true, true, false)
        while (progressRabbit < 100 && progressTurtle < 100) {
            delay(100)
            if (sleepProbability.random()) {
                delay(300)
            }
            progressRabbit += 3
            if (progressRabbit > 100) progressRabbit = 100
            sbRabbit.progress = progressRabbit

            if (progressRabbit >= 100 && progressTurtle < 100) {
                Toast.makeText(this@MainActivity, "兔子勝", Toast.LENGTH_SHORT).show()
                btnStart.isEnabled = true
                break
            }
        }
    }

    private suspend fun runTurtle() {
        while (progressTurtle < 100 && progressRabbit < 100) {
            delay(100)
            progressTurtle += 1
            if (progressTurtle > 100) progressTurtle = 100
            sbTurtle.progress = progressTurtle

            if (progressTurtle >= 100 && progressRabbit < 100) {
                Toast.makeText(this@MainActivity, "烏龜勝", Toast.LENGTH_SHORT).show()
                btnStart.isEnabled = true
                break
            }
        }
    }
}
