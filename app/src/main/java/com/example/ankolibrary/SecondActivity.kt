package com.example.ankolibrary

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import org.jetbrains.anko.dip
import org.jetbrains.anko.padding
import org.jetbrains.anko.textView
import org.jetbrains.anko.verticalLayout

class SecondActivity : AppCompatActivity() {

    private var name: String = ""
    lateinit var nameTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        // make angko layout
        verticalLayout {
            padding = dip(16)
            nameTextView = textView()
        }
        val intent = intent
        // mengambil data yang di kirim melalui intent
        name = intent.getStringExtra("name")
        nameTextView.text = name
    }
}
