//when function was referenced from the generation app we did in class with Kincade Garanganga//
//initalising the buttons we learned from mr Kincade//
//finding a function by its id was also learnt in class with mr Kincade
package vcmsa.ci.mealapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class  MainActivity : AppCompatActivity() {
    //this is where i declared my buttons and different text views//
    private lateinit var display: TextView
    private lateinit var inputTime: EditText
    private lateinit var btnSuggestion: Button
    private lateinit var btnClear: Button
    private lateinit var btnExit: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        //here i had to find everything declared by their id's//
        display = findViewById(R.id.displayText)
        inputTime = findViewById(R.id.inputDate)
        btnSuggestion = findViewById(R.id.suggBtn)
        btnClear = findViewById(R.id.clearBtn)
        btnExit = findViewById(R.id.exitBtn)


        //here we giving the buttons functions and for them to work//
        btnSuggestion.setOnClickListener {
            suggestMeal()
        }

        btnClear.setOnClickListener {
            inputTime.text.clear()
            display.text = ""
        }

        btnExit.setOnClickListener {
            finish()
        }
    }
    //This is a private function that produce results from the input//
    private fun suggestMeal() {
        val timeOfDay = inputTime.text.toString().trim().lowercase()
        val mealSuggestion = when (timeOfDay) {
            "morning" -> "Eggs, Toast, Bacon, Juice"
            "mid-morning" -> "Fruits: Banana, Apple"
            "afternoon" -> "Sandwiches"
            "mid-afternoon" -> "Snacks"
            "dinner" -> "Rice and Chicken"
            "after dinner" -> "Chocolate Sundae with Cherry"
            else -> "Please enter a valid time of day (e.g., morning, afternoon, dinner)."
        }
        display.text = mealSuggestion
    }
}
