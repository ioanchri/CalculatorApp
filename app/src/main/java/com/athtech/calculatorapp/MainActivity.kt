package com.athtech.calculatorapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)


        /* ******** Numbers ********** */

        var button0 = findViewById<Button>(R.id.button0)
        button0.setOnClickListener {
            evaluateExpression("0", clear = true)
            Log.d("App", "The user pressed a button")
            Toast.makeText(this, "button 0 clicked", Toast.LENGTH_SHORT).show()
        }


        var button1 = findViewById<Button>(R.id.button1)
        button1.setOnClickListener {
            evaluateExpression("1", clear = true)
        }


        var button2 = findViewById<Button>(R.id.button2)
        button2.setOnClickListener {
            evaluateExpression("2", clear = true)
        }

        var button3 = findViewById<Button>(R.id.button3)
        button3.setOnClickListener {
            evaluateExpression("3", clear = true)
        }

        var button4 = findViewById<Button>(R.id.button4)
        button4.setOnClickListener {
            evaluateExpression("4", clear = true)
        }

        var button5 = findViewById<Button>(R.id.button5)
        button5.setOnClickListener {
            evaluateExpression("5", clear = true)
        }

        var button6 = findViewById<Button>(R.id.button6)
        button6.setOnClickListener {
            evaluateExpression("6", clear = true)
        }

        var button7 = findViewById<Button>(R.id.button7)
        button7.setOnClickListener {
            evaluateExpression("7", clear = true)
        }

        var button8 = findViewById<Button>(R.id.button8)
        button8.setOnClickListener {
            evaluateExpression("8", clear = true)
        }

        var button9 = findViewById<Button>(R.id.button9)
        button9.setOnClickListener {
            evaluateExpression("9", clear = true)
        }

        var decimal = findViewById<Button>(R.id.buttonDecimal)
        decimal.setOnClickListener {
           evaluateExpression(".", clear = true)

        }

        /* ******** Operators ********** */

        var buttonPlus = findViewById<Button>(R.id.buttonPlus)
        buttonPlus.setOnClickListener {
            evaluateExpression("+", clear = true)
        }

        var buttonMinus = findViewById<Button>(R.id.buttonMinus)
        buttonMinus.setOnClickListener {
            evaluateExpression("-", clear = true)
        }
        var buttonMultiply = findViewById<Button>(R.id.buttonMultiply)
        buttonMultiply.setOnClickListener {
            evaluateExpression("*", clear = true)
        }
        var buttonDevide = findViewById<Button>(R.id.buttonDevide)
        buttonDevide.setOnClickListener {
            evaluateExpression("/", clear = true)
        }

        var buttonEqual = findViewById<Button>(R.id.buttonEqual)
        buttonEqual.setOnClickListener {
            val text = tvExpression.text.toString()
            val expression = ExpressionBuilder(text).build()
            val result = expression.evaluate()
            val longResult = result.toLong()
            if (result == longResult.toDouble()) {
                tvResult.text = longResult.toString()
            } else {
                tvResult.text = result.toString()
            }
        }

        var delete = findViewById<Button>(R.id.buttonDelete)
        delete.setOnClickListener {
            val text = tvExpression.text.toString()
            if(text.isNotEmpty()) {
                tvExpression.text = text.dropLast(1)
            }
            tvResult.text = ""
        }

    }

    /* ******** Functions ********** */

    private fun evaluateExpression(string: String, clear: Boolean) {
        if (clear) {
            tvResult.text = ""
            tvExpression.append(string)
        } else {
            tvExpression.append(tvResult.text)
            tvExpression.append(string)
            tvResult.text = ""
        }
    }



    fun allClear(view: View) {
        tvResult.text = ""
        tvExpression.text = ""
    }


}