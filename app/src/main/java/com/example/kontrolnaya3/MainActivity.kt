package com.example.kontrolnaya3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    private val registrationsList = mutableListOf<Registration>()
    private lateinit var editTextCountChild: EditText
    private lateinit var editTextCountAdult: EditText
    private lateinit var editTextFlight: EditText
    private lateinit var editTextFirstName: EditText
    private lateinit var editTextLastName: EditText
    private lateinit var editTextPrice: EditText
    private lateinit var buttonReg: Button
    private lateinit var buttonCheck: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editTextCountChild = findViewById<EditText>(R.id.editTextCountChild)
        editTextCountAdult = findViewById<EditText>(R.id.editTextCountAdult)
        editTextFlight = findViewById<EditText>(R.id.editTextFlight)
        editTextFirstName = findViewById<EditText>(R.id.editTextFirstName)
        editTextLastName = findViewById<EditText>(R.id.editTextLastName)
        editTextPrice = findViewById<EditText>(R.id.editTextPrice)
        buttonReg = findViewById<Button>(R.id.buttonReg)
        buttonCheck = findViewById<Button>(R.id.buttonCheck)

        buttonReg.setOnClickListener{
            val registration = Registration(
                countChild = editTextCountChild.text.toString().toInt(),
                countAdult = editTextCountAdult.text.toString().toInt(),
                flight = editTextFlight.text.toString(),
                firstName = editTextFirstName.text.toString(),
                lastName = editTextLastName.text.toString(),
                price = editTextPrice.text.toString().toDouble(),
            )
            registrationsList.add(registration)

            editTextCountChild.text.clear()
            editTextCountAdult.text.clear()
            editTextFlight.text.clear()
            editTextFirstName.text.clear()
            editTextLastName.text.clear()
            editTextPrice.text.clear()
        }

        buttonCheck.setOnClickListener {
            val intent = Intent(this, DisplayRegistrationActivity::class.java)
            intent.putExtra("registrationList", ArrayList(registrationsList))
            startActivity(intent)
        }
    }
}