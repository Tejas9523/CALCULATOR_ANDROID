package com.example.calculator

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.calculator.databinding.ActivityMainBinding
import org.mariuszgromada.math.mxparser.Expression
import java.lang.Exception
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.buttonClear.setOnClickListener {
                binding.input.text = ""
        binding.output.text = ""
        }

        binding.buttonBracketLeft.setOnClickListener {
            binding.input.text = addToInputText("(")
        }

        binding.buttonBracketRight.setOnClickListener {
            binding.input.text = addToInputText(")")
        }

        binding.button0.setOnClickListener {
            binding.input.text = addToInputText("0")
        }

        binding.button1.setOnClickListener {
            binding.input.text = addToInputText("1")
        }

        binding.button2.setOnClickListener {
            binding.input.text = addToInputText("2")
        }

        binding.button3.setOnClickListener {
            binding.input.text = addToInputText("3")
        }

        binding.button4.setOnClickListener {
            binding.input.text = addToInputText("4")
        }

        binding.button5.setOnClickListener {
            binding.input.text = addToInputText("5")
        }

        binding.button6.setOnClickListener {
            binding.input.text = addToInputText("6")
        }

        binding.button7.setOnClickListener {
            binding.input.text = addToInputText("7")
        }

        binding.button8.setOnClickListener {
            binding.input.text = addToInputText("8")
        }

        binding.button9.setOnClickListener {
            binding.input.text = addToInputText("9")
        }

        binding.buttonDot.setOnClickListener {
            binding.input.text = addToInputText(".")
        }

        binding.buttonAdd.setOnClickListener {
            binding.input.text = addToInputText("+")
        }

        binding.buttonSubstract.setOnClickListener {
            binding.input.text = addToInputText("-")
        }

        binding.buttonMultiply.setOnClickListener {
            binding.input.text = addToInputText("X")
        }

        binding.buttonDivision.setOnClickListener {
            binding.input.text = addToInputText("/")
        }

        binding.buttonEquals.setOnClickListener {
            showresult()
        }
    }
    private fun addToInputText(buttonValue: String):String{
        return  "${binding.input.text}$buttonValue"
    }
    private fun getInputExpression():String{
        var exp = binding.input.text.replace(Regex("÷"),"/")
        exp = exp.replace(Regex("X"),"*")
        return exp
    }
    private  fun showresult(){
        try {
            val exp = getInputExpression()
            val result = Expression(exp).calculate()
            if(result.isNaN()){
                // show error msg
                binding.output.text = "Error"
                binding.output.setTextColor(ContextCompat.getColor(this,R.color.green))
            } else{
                // show result
                binding.output.text = DecimalFormat("0.######").format(result).toString()
                binding.output.setTextColor(ContextCompat.getColor(this,R.color.green))
            }
        }
        catch (e: Exception){
            // show error msg
            binding.output.text = "Error"
            binding.output.setTextColor(ContextCompat.getColor(this,R.color.green))
        }
    }
}