package com.example.rgbviewer

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.SeekBar
import android.widget.TextView

class MainActivity : AppCompatActivity(), SeekBar.OnSeekBarChangeListener {

    lateinit var viewColor: View
    lateinit var seekBarOpacity: SeekBar
    lateinit var seekBarRed: SeekBar
    lateinit var seekBarGreen: SeekBar
    lateinit var seekBarBlue: SeekBar
    lateinit var textViewOpacity: TextView
    lateinit var textViewRed: TextView
    lateinit var textViewGreen: TextView
    lateinit var textViewBlue: TextView
    lateinit var textViewHexa: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewColor = findViewById(R.id.view_Color)
        seekBarOpacity = findViewById(R.id.seekBar_Opacity)
        seekBarRed = findViewById(R.id.seekBar_Red)
        seekBarGreen = findViewById(R.id.seekBar_Green)
        seekBarBlue = findViewById(R.id.seekBar_Blue)
        textViewOpacity = findViewById(R.id.textView_Opacity)
        textViewRed = findViewById(R.id.textView_Red)
        textViewGreen = findViewById(R.id.textView_Green)
        textViewBlue = findViewById(R.id.textView_Blue)
        textViewHexa = findViewById(R.id.textView_Hexa)

        seekBarOpacity.setOnSeekBarChangeListener(this)
        seekBarRed.setOnSeekBarChangeListener(this)
        seekBarGreen.setOnSeekBarChangeListener(this)
        seekBarBlue.setOnSeekBarChangeListener(this)
    }

    fun hexaGenerator() {
        var red = (seekBarRed.progress.toInt()).toString(16)
        var green = (seekBarGreen.progress.toInt()).toString(16)
        var blue = (seekBarBlue.progress.toInt()).toString(16)

        red = if (red.length > 1) red else red + "0"
        green = if (green.length > 1) green else green + "0"
        blue = if (blue.length > 1) blue else blue + "0"

        textViewHexa.text = (red + green + blue).toUpperCase()
    }

    override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
        when(seekBar.id){
            R.id.seekBar_Opacity ->{
                textViewOpacity.text = seekBarOpacity.progress.toString()
            }

            R.id.seekBar_Red ->{
                textViewRed.text = seekBarRed.progress.toString()
                hexaGenerator()
            }

            R.id.seekBar_Green ->{
                textViewGreen.text = seekBarGreen.progress.toString()
                hexaGenerator()
            }

            R.id.seekBar_Blue ->{
                textViewBlue.text = seekBarBlue.progress.toString()
                hexaGenerator()
            }

        }

        viewColor.setBackgroundColor(Color.argb(seekBarOpacity.progress.toInt(),
            seekBarRed.progress.toInt(),
            seekBarGreen.progress.toInt(),
            seekBarBlue.progress.toInt()))
    }

    override fun onStartTrackingTouch(seekBar: SeekBar?) {

    }

    override fun onStopTrackingTouch(seekBar: SeekBar?) {

    }
}
