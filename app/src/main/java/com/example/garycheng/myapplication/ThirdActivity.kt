package com.example.garycheng.myapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_third.*

class ThirdActivity : AppCompatActivity() {

    companion object {
        const val TYPE = "animal_type"
        const val POSITION = "animal_position"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)
        showAnimal()
    }

    private fun showAnimal() {

        val type = intent.getStringExtra(TYPE)
        val position = intent.getIntExtra(POSITION, 0)

        animal_type.text = type.toString()
        animal_position.text = position.toString()



//        // Get the count from the intent extras
//        val count = intent.getIntExtra(TOTAL_COUNT, 0)
//
//        // Generate the random number
//        val random = Random()
//        var randomInt = 0
//
//        if (count > 0) {
//            // Add one because the bound is exclusive
//            randomInt = random.nextInt(count + 1)
//        }
//
//        // Display the random number.
//        animal_type.text = randomInt.toString()
//
//        // Substitute the max value into the string resource
//        // for the heading, and update the heading
//        textview_label.text = getString(R.string.random_heading, count)
    }
}
