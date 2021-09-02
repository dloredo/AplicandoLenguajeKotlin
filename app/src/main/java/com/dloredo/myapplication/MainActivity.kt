package com.dloredo.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var etName: EditText
    private lateinit var etAge: EditText
    private lateinit var btnGo: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etName = findViewById(R.id.etName)
        etAge = findViewById(R.id.etAge)
        btnGo = findViewById(R.id.btnGo)

        btnGo.setOnClickListener {

            val name = etName.text.toString()
            val age = etAge.text.toString()

            when {
                name.isEmpty() or age.isEmpty() -> {
                    Toast.makeText(this,"You may fill all inputs!", Toast.LENGTH_LONG).show()
                }
                age.toIntOrNull() == null -> {
                    Toast.makeText(this,"The age input must be an Int", Toast.LENGTH_LONG).show()
                }
                else -> {
                    val luckyNumber: String = getLuckyNumber(age)
                    Toast.makeText(this, "Hi $name, your lucky number is: $luckyNumber", Toast.LENGTH_LONG).show()
                }
            }

        }

    }

    private fun getLuckyNumber(age: String): String{
        var luckyNumber: Int = if (age.length == 1) age.toInt() * 7 else age.toInt()

        while (luckyNumber.toString().length > 1){
            val numbers: List<Char> = luckyNumber.toString().toList()
            luckyNumber = numbers[0].toString().toInt() + numbers[1].toString().toInt()
        }


        return luckyNumber.toString()
    }
}