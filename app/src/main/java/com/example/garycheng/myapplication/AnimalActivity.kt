package com.example.garycheng.myapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_animal.*

class AnimalActivity : AppCompatActivity() {

    companion object {
        const val TYPE_ONLY = "animal_type_only"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animal)
        showType()
    }

    private fun showType() {
        val type = intent.getStringExtra(TYPE_ONLY)

        animal_type_only.text = type.toString()
    }
}
