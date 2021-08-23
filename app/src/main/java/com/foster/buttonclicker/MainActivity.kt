package com.foster.buttonclicker

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import kotlin.concurrent.timer

open class color

class MainActivity : AppCompatActivity() {

    // private Button button;    on java
    // var or val : variable vs constant
    // var varName : DataType
    // lateinit is a promis to initialize the variable later before using it
    lateinit var buttonClicker: Button
    lateinit var background: ConstraintLayout
    lateinit var fire: ImageView
    lateinit var count: TextView
    var timesClicked = 0
    var trans = 0
    var butb = 255
    var butr = 145
    var butg = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // wire widgets -- link the xml widgets to our kotlin code

        background = findViewById(R.id.ConstraintLayout_main_background)
        fire = findViewById(R.id.fire_main_image)
        fire.alpha = 0f
        buttonClicker = findViewById(R.id.button_main_clicker)
        buttonClicker.text = "CLICK ME!"

        // repeat to a click to increase the timesClicked variable
        buttonClicker.setOnClickListener {
            // in between the braces, put code that should happen after a click
            timesClicked++
            // buttonClicker.text = "Times Clicked: " + timesClicked;   on java
            count.text = "Times Clicked: $timesClicked"
            // buttonClicker.alpha -= .01f

            if (timesClicked >= 20) {
                fire.alpha += .05F
            }

            if (timesClicked >= 30) {
                if(trans < 255) {
                    background.setBackgroundColor(Color.argb(trans, 255, 68, 0))
                    trans += 5
                }
            }

            if (timesClicked >= 60) {
                buttonClicker.setBackgroundColor(Color.argb(255, butr, 0, butb))
                if(butr < 255){
                    butr+=5
                }
                //if(butg < 196){
                //}
                if(butb > 0){
                    butb-=5
                }
            }

            /* if(timesClicked >= 1){
                 val blip1 = System.currentTimeMillis()
                 val count1 = timesClicked
                 if(blip1 + )
             } */

            // toast user when they've clicked 10 times
            if (timesClicked == 10) {
                // context in android is the activity that you are currently in
                // usually the keyword is this
                // sometimes may need to specifiy this@MainActivity
                Toast.makeText(this, "Keep Going!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}