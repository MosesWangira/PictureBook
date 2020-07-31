package com.example.picturebook

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    lateinit var imageDisplayed: ImageView
    lateinit var textDisplayed: TextView

    lateinit var buttonNext: Button
    lateinit var buttonBack: Button

    private var itemIndex: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imageDisplayed = findViewById(R.id.imageDisplayed)
        textDisplayed = findViewById(R.id.animalName)
        buttonNext = findViewById(R.id.next)
        buttonBack = findViewById(R.id.back)

        val listOfImages = mutableListOf(
            R.drawable.lion,
            R.drawable.cheetah,
            R.drawable.hyena
        )

        val listOfString = mutableListOf(
            "Lion",
            "Cheetah",
            "Hyena"
        )

        val length = listOfImages.size


        buttonBack.setOnClickListener {
            itemIndex--
            if(itemIndex < 0){
                itemIndex = 0
                Toast.makeText(this, "This is the first image", Toast.LENGTH_SHORT).show()
            }else{
                imageDisplayed.setImageResource(listOfImages[itemIndex])
                textDisplayed.text = listOfString[itemIndex]
            }
        }

        buttonNext.setOnClickListener {
            if(itemIndex >= length - 1){
                Toast.makeText(this, "This is the last image", Toast.LENGTH_SHORT).show()
            }else{
                itemIndex++
                imageDisplayed.setImageResource(listOfImages[itemIndex])
                textDisplayed.text = listOfString[itemIndex]
            }
        }
    }
}
