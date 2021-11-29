package jjsebastianfuertes.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import jjsebastianfuertes.diceroller.databinding.ActivityMainBinding
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var diceNumber: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        diceNumber = 0
        val button = binding.rollButton
        button.text =  "Let's roll!"
        button.setOnClickListener {
            rollDice()
        }
    }

    private fun rollDice() {

        val newDiceNumber = Random().nextInt(6) + 1
        if(diceNumber == newDiceNumber)
          Toast.makeText(this , getString(R.string.dice_rolled),Toast.LENGTH_SHORT).show()
        diceNumber = newDiceNumber

        val image = when(diceNumber){
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            6 -> R.drawable.dice_6
            else -> R.drawable.empty_dice
        }
        binding.dice.setImageResource(image)
    }
}