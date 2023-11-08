package com.example.kontrolnaya3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import android.widget.ArrayAdapter

class DisplayRegistrationActivity : AppCompatActivity() {
    private lateinit var listViewRegs: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display_registration)

        listViewRegs = findViewById<ListView>(R.id.listViewRegs)
        val registrationList = ArrayList<String>()
        val regsList = intent.getSerializableExtra("registrationList") as? ArrayList<Registration>
        if (regsList != null) {
            regsList.forEach {
                val regInfo =
                    "Общая стоимость: ${(it.countChild+it.countAdult)*it.price}\n" +
                            "Кол-во детских: ${it.countChild}\n" +
                            "Кол-во взрослых: ${it.countAdult}\n"
                registrationList.add(regInfo)
            }
            val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, registrationList)
            listViewRegs.adapter = adapter
        }
    }
}
