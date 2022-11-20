package com.athtech.calculatorapp

import android.nfc.Tag
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


        var results = findViewById<TextView>(R.id.tvResult)
        var expressions = findViewById<TextView>(R.id.tvExpression)

        /* ******** Numbers ********** */

        var button0 = findViewById<Button>(R.id.button0)
        button0.setOnClickListener {
            evaluateExpression("0", true)
        }

        var button1 = findViewById<Button>(R.id.button1)
        button1.setOnClickListener {
            evaluateExpression("1", true)
            enableOperations(true)
        }


        var button2 = findViewById<Button>(R.id.button2)
        button2.setOnClickListener {
            evaluateExpression("2", true)
        }

        var button3 = findViewById<Button>(R.id.button3)
        button3.setOnClickListener {
            evaluateExpression("3", true)
        }

        var button4 = findViewById<Button>(R.id.button4)
        button4.setOnClickListener {
            evaluateExpression("4", true)
        }

        var button5 = findViewById<Button>(R.id.button5)
        button5.setOnClickListener {
            evaluateExpression("5", true)
        }

        var button6 = findViewById<Button>(R.id.button6)
        button6.setOnClickListener {
            evaluateExpression("6", true)
        }

        var button7 = findViewById<Button>(R.id.button7)
        button7.setOnClickListener {
            evaluateExpression("7", true)
        }

        var button8 = findViewById<Button>(R.id.button8)
        button8.setOnClickListener {
            evaluateExpression("8", true)
        }

        var button9 = findViewById<Button>(R.id.button9)
        button9.setOnClickListener {
            evaluateExpression("9", true)
        }

        var decimal = findViewById<Button>(R.id.buttonDecimal)
        decimal.setOnClickListener {
            evaluateExpression(".", false)

        }

        /* ******** Operators ********** */

        var buttonPlus = findViewById<Button>(R.id.buttonPlus)
        buttonPlus.setOnClickListener {
            evaluateExpression("+", false)
        }

        var buttonMinus = findViewById<Button>(R.id.buttonMinus)
        buttonMinus.setOnClickListener {
            evaluateExpression("-", false)
        }
        var buttonMultiply = findViewById<Button>(R.id.buttonMultiply)
        buttonMultiply.setOnClickListener {
            evaluateExpression("*", false)
        }
        var buttonDevide = findViewById<Button>(R.id.buttonDevide)
        buttonDevide.setOnClickListener {
            evaluateExpression("/", false)
        }

        var buttonEqual = findViewById<Button>(R.id.buttonEqual)
        buttonEqual.setOnClickListener {
            val text = tvExpression.text.toString()
            val expression = ExpressionBuilder(text).build()
            val result = expression.evaluate()
            val longResult = result.toLong()
            if (result == longResult.toDouble()) {
                results.text = longResult.toString()
            } else {
                results.text = result.toString()
            }

            enableOperations(true)
        }


        var delete = findViewById<Button>(R.id.buttonDelete)
        delete.setOnClickListener {
            val text = expressions.text.toString()
            if (text.isNotEmpty()) {
                println(text.last())
                expressions.text = text.dropLast(1)
                if ((expressions.text.last() === '/' || expressions.text.last() === '*') || (expressions.text.last() === '+') || (expressions.text.last() === '-') || (expressions.text.last() === '.')) {
                    enableOperations(false)
                } else {
                    expressions.text = text.dropLast(1)
                    enableOperations(true)
                }
            } else
                results.text = ""

        }

        var buttonClear = findViewById<Button>(R.id.buttonClear)
        buttonClear.setOnClickListener {
            expressions.text = ""
            results.text = ""
            enableOperations(true)
        }

    }

/* ******** Functions ********** */

    private fun evaluateExpression(string: String, clear: Boolean) {
        if (clear) {
            tvResult.text = ""
            tvExpression.append(string)
            enableOperations(true)
        } else {
            tvResult.text = ""
            tvExpression.append(string)
            //       tvExpression.append(tvResult.text)

            enableOperations(false)

        }
    }

    private fun enableOperations(clear: Boolean) {
        if (clear) {
            buttonPlus.isEnabled = true
            buttonMinus.isEnabled = true
            buttonMultiply.isEnabled = true
            buttonDevide.isEnabled = true
            buttonDecimal.isEnabled = true
            buttonEqual.isEnabled = true
        } else {
            buttonDecimal.isEnabled = false
            buttonPlus.isEnabled = false
            buttonMinus.isEnabled = false
            buttonMultiply.isEnabled = false
            buttonDevide.isEnabled = false
            buttonEqual.isEnabled = false
        }

    }

}