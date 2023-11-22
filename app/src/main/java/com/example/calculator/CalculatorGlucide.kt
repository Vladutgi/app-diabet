package com.example.calculator

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment

class CalculatorGlucide : Fragment(), View.OnClickListener {

    private lateinit var buttonCalculeaza: Button
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

        buttonCalculeaza = view.findViewById(R.id.btn_calculeaza)
        tv1 = view.findViewById(R.id.textview_fifth)
        field1 = view.findViewById(R.id.value1)
        field2 = view.findViewById(R.id.value2)
        field3 = view.findViewById(R.id.value3)


        buttonCalculeaza.setOnClickListener(this)

    }

    override fun onClick(view: View) {
        nr1 = getField1Value()
        nr2 = getField2_3Value(field2)
        nr3 = (100 / nr1) * nr2
        nr4 =getField2_3Value(field3)
        when (view.id) {

            R.id.btn_calculeaza -> tv1.setText((nr3*nr4/100).toString())
        }

    }

    private fun getField1Value(): Double {
        return if (field1.text.toString().isEmpty()) {
            100.0
        } else {
            field1.text.toString().toDouble()
        }
    }

    private fun getField2_3Value(editText: EditText): Double {
        return if (editText.text.toString().isEmpty()) {
            0.0
        } else {
            editText.text.toString().toDouble()
        }
    }


}