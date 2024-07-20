package com.example.calculator

import android.content.res.Configuration
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment

class CalculatorGlucide : Fragment(){

    private lateinit var field1: EditText
    private lateinit var field2: EditText
    private lateinit var field3: EditText

    private lateinit var tv1: TextView
    private var nr1: Double = 0.0
    private var nr2: Double = 0.0
    private var nr3: Double = 0.0
    private var nr4: Double = 0.0


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_calculatordiabet, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        tv1 = view.findViewById(R.id.textview_fifth)
        field1 = view.findViewById(R.id.value1)
        field2 = view.findViewById(R.id.value2)
        field3 = view.findViewById(R.id.value3)






        field1.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(s: Editable?) {
                if(field2.text.isNullOrBlank()==false&&field3.text.isNullOrBlank()==false&&field2.text.toString()!="."){
                    tv1.setText(ArataCH())

                }
            }

        })


        field2.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(s: Editable?) {
                if(field1.text.isNullOrBlank()==false&&field3.text.isNullOrBlank()==false&&field2.text.toString()!="."){
                    tv1.setText(ArataCH())

                }
            }

        })





        field3.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(s: Editable?) {
            if(field1.text.isNullOrBlank()==false&&field2.text.isNullOrBlank()==false&&field2.text.toString()!="."){
                tv1.setText(ArataCH())

            }


            }

        })
            if(field1.text!=null&&field2.text!=null&&field3.text!=null&&field2.text.toString()!="."){
                tv1.setText(ArataCH())
            }


    }



    private fun GetField1Value(): Double {
        return if (field1.text.toString().isEmpty()) {
            100.0
        } else {
            field1.text.toString().toDouble()
        }
    }

    private fun GetField2_3Value(editText: EditText): Double {
        return if (editText.text.toString().isEmpty()) {
            0.0
        } else {
            editText.text.toString().toDouble()
        }
    }


    private fun ArataCH():String{
        nr1 = GetField1Value()
        nr2 = GetField2_3Value(field2)
        nr3 = (100 / nr1) * nr2
        nr4 =GetField2_3Value(field3)
        var calcul =nr3*nr4/100
        return String.format("%.2f",calcul)
    }
}