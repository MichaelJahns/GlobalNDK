package com.leyline.global

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var digitOne: EditText
    private lateinit var digitTwo: EditText
    private lateinit var addition: TextView
    private lateinit var subtraction: TextView
    private lateinit var multiplication: TextView
    private lateinit var division: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bindOnClickListeners()
        doMath()
    }

    private fun bindOnClickListeners() {
        digitOne = findViewById(R.id.etNumber1)
        digitTwo = findViewById(R.id.etNumber2)
        addition = findViewById(R.id.tvAdditionOperation)
        subtraction = findViewById(R.id.tvSubtractionOperation)
        multiplication = findViewById(R.id.tvMultiplicationOperation)
        division = findViewById(R.id.tvDivisionOperation)
        digitOne.setOnFocusChangeListener(View.OnFocusChangeListener { _, _ -> doMath() })
        digitTwo.setOnFocusChangeListener(View.OnFocusChangeListener { _, _ -> doMath() })
    }

    private fun doMath() {
        val numberOne = digitOne.text.toString().toInt()
        val numberTwo = digitTwo.text.toString().toInt()
        val additionString =
            "$numberOne + $numberTwo is equal to ${additionFromJNI(numberOne, numberTwo)}"
        val subtractionString =
            "$numberOne - $numberTwo is equal to ${subtractFromJNI(numberTwo, numberOne)}"
        val multiplicationString =
            "$numberOne * $numberTwo is ${multiplyFromJNI(numberOne, numberTwo)}"
        val divisionString =
            "$numberOne / $numberTwo rounded, is ${Math.round(divideFromJNI(numberTwo, numberOne))}"
        addition.text = additionString
        subtraction.text = subtractionString
        multiplication.text = multiplicationString
        division.text = divisionString
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    external fun additionFromJNI(numberOne: Int, numberTwo: Int): Int
    external fun subtractFromJNI(numberTwo: Int, numberOne: Int): Int
    external fun multiplyFromJNI(numberTwo: Int, numberOne: Int): Int
    external fun divideFromJNI(numberTwo: Int, numberOne: Int): Double

    companion object {
        // Used to load the 'native-lib' library on application startup.
        init {
            System.loadLibrary("native-lib")
        }
    }
}