package com.example.ankolibrary

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import org.jetbrains.anko.*
import org.jetbrains.anko.design.snackbar

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        MainActivityUI().setContentView(this);

    }

    class MainActivityUI : AnkoComponent<MainActivity> {
        override fun createView(ui: AnkoContext<MainActivity>) = with(ui) {
            verticalLayout {
                padding = dip(16)
                // enter name
                val name = editText {
                    hint = "What your name?"
                }
                // button with toast
                button("Say Hello") {
                    //backgroundColor = ContextCompat.getColor(context, colorAccent)
                    textColor = Color.WHITE
                    setOnClickListener { toast("Hello, ${name.text}") }
                }.lparams(width = matchParent) {
                    topMargin = dip(5)
                }
                // make toast select
                button("Show Selector") {
                    //backgroundColor = ContextCompat.getColor(context, colorAccent)
                    textColor = Color.WHITE
                    setOnClickListener {
                        val club = listOf("Barcelona", "RealMadrid", "Bayern Munchen", "Liverpool")
                        selector(
                            "Hello, ${name.text}! what footbal club you love?  ",
                            club
                        ) { _, i ->
                            toast("So you love ${club[i]}, right?")
                        }
                    }
                }.lparams(width = matchParent) {
                    topMargin = dip(5)
                }
                // intent to another activity
                button("Go to Second Activity") {
                    //backgroundColor = ContextCompat.getColor(context, colorAccent)
                    textColor = Color.WHITE
                    setOnClickListener {
                        startActivity<SecondActivity>("name" to "${name.text}")
                    }
                }.lparams(width = matchParent) {
                    topMargin = dip(5)
                }
                // make snackbar
                button("Show Snackbar") {
                    //backgroundColor = ContextCompat.getColor(context, colorAccent)
                    textColor = Color.WHITE
                    setOnClickListener {
                        snackbar("Hello, ${name.text}")
                    }
                }.lparams(width = matchParent) {
                    topMargin = dip(5)
                }

            }
        }
    }
}
