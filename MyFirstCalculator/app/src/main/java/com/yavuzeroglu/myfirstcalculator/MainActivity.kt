package com.yavuzeroglu.myfirstcalculator

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton
import com.yavuzeroglu.myfirstcalculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    // binding
    private lateinit var binding: ActivityMainBinding

    private var currentValue: Double = 0.0
    private var lastOperation: String = ""
    private var isNewOperation: Boolean = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        // backspace button
        binding.backspaceButton.setOnClickListener {
            backspaceOperation()
        }

        // dot button
        binding.dotButton.setOnClickListener {
            val currentText = binding.resultTextView.text.toString()
            when {
                currentText.isEmpty() -> binding.resultTextView.append("0.")
                currentText.contains("-") && currentText.length == 1 -> binding.resultTextView.append(
                    "0."
                )

                !currentText.contains(".") -> binding.resultTextView.append(".")
            }
        }

        // All Clear Button
        binding.clearButton.setOnClickListener {
            allClear()
        }

        // number buttons
        with(binding) {
            listOf(
                oneButton, twoButton, threeButton,
                fourButton, fiveButton, sixButton,
                sevenButton, eightButton, nineButton,
                zeroButton
            ).forEach { button ->
                button.setOnClickListener {
                    if (isNewOperation) {
                        binding.resultTextView.text = ""
                        isNewOperation = false
                    }
                    binding.resultTextView.append(button.text)
                }
            }
        }

        // operator buttons
        with(binding) {
            listOf(plusButton, divideButton, minusButton, multiplyButton).forEach { button ->
                button.setOnClickListener {
                    setupOperatorButtons(button)
                }
            }
        }

        // equal button
        binding.equalButton.setOnClickListener {
            if (binding.resultTextView.text.isNotEmpty() && lastOperation.isNotEmpty()) {
                val currentNumber = binding.resultTextView.text.toString().toDoubleOrNull() ?: 0.0
                currentValue = calculate(currentValue, currentNumber, lastOperation)

                binding.resultTextView.text = formatNumber(currentValue)
                binding.formulaTextView.text = ""
                lastOperation = ""
                isNewOperation = true
            }
        }
    }

    private fun setupOperatorButtons(button: MaterialButton) {
        val operators = setOf("+", "/", "*")
        if (button.text.toString() in operators) {
            handleOperator(button.text.toString())
        } else {
            val currentText = binding.resultTextView.text.toString()
            // Durum 1: Başlangıçta veya operatörden sonra eksi (negatif sayı)
            if (currentText.isEmpty() || lastOperation.isNotEmpty()) {
                binding.resultTextView.append("-")
            }
            // Durum 2: Normal çıkarma işlemi
            else {
                handleOperator("-")
            }
        }

    }

    private fun handleOperator(operator: String) {
        if (binding.resultTextView.text.isNotEmpty()) {
            val currentNumber = binding.resultTextView.text.toString().toDoubleOrNull() ?: 0.0

            if (lastOperation.isNotEmpty() && !isNewOperation) {
                currentValue = calculate(currentValue, currentNumber, lastOperation)
            } else {
                currentValue = currentNumber
            }

            binding.formulaTextView.text = "${formatNumber(currentValue)}$operator"
            lastOperation = operator
            binding.resultTextView.text = ""
            isNewOperation = false
        }
    }

    // functions
    private fun allClear() {
        currentValue = 0.0
        lastOperation = ""
        binding.resultTextView.text = ""
        binding.formulaTextView.text = ""
    }

    private fun backspaceOperation() {
        if (binding.resultTextView.text.isNotEmpty()) {
            binding.resultTextView.text = binding.resultTextView.text.dropLast(1)
        }
    }

    private fun calculate(firstNumber: Double, currentNumber: Double, operation: String): Double {
        return when (operation) {
            "+" -> firstNumber + currentNumber
            "-" -> firstNumber - currentNumber
            "*" -> firstNumber * currentNumber
            "/" -> if (currentNumber != 0.0) firstNumber / currentNumber else Double.NaN
            else -> currentNumber
        }
    }


    private fun formatNumber(number: Double): String {
        return if (number.isNaN()) "Hata"
        else if (number % 1 == 0.0) number.toInt().toString()
        else "%.4f".format(number).replace(",", ".").replace(Regex("\\.?0+$"), "")
    }
}

