package com.example.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rollButton: Button =findViewById(R.id.button);
        rollButton.setOnClickListener{
            rollDice()
        }
        rollDice()
    }

    private fun rollDice() {
        val dice=Dice(6)
        val diceImage: ImageView =findViewById(R.id.imageView)
       val r=dice.roll()
        when(r)
        {
            1->diceImage.setImageResource(R.drawable.dice_1)
            2->diceImage.setImageResource(R.drawable.dice_2)
            3->diceImage.setImageResource(R.drawable.dice_3)
            4->diceImage.setImageResource(R.drawable.dice_4)
            5->diceImage.setImageResource(R.drawable.dice_5)
            6->diceImage.setImageResource(R.drawable.dice_6)
        }
    }
}
class  Dice(private val numSides:Int){

    fun roll():Int{
        return (1..numSides).random()
    }
}