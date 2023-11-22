package com.example.calculator

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import kotlin.math.sqrt

class SecondFragment : Fragment(), View.OnClickListener {

    private lateinit var buttonPlus: Button
    private lateinit var buttonMinus: Button
    private lateinit var buttonC: Button
    private lateinit var buttonInmultit: Button
    private lateinit var buttonImpartit: Button
    private lateinit var buttonPatrat: Button
    private lateinit var buttonXlaN: Button
    private lateinit var buttonMod: Button
    private lateinit var buttonRadical: Button
    private lateinit var field1: EditText
    private lateinit var field2: EditText
    private var nr1: Double = 0.0
    private var nr2: Double = 0.0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_second, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        buttonPlus = view.findViewById(R.id.btn_plus)
        buttonMinus = view.findViewById(R.id.btn_minus)
        buttonC = view.findViewById(R.id.btn_c)
        buttonInmultit = view.findViewById(R.id.btn_inmultit)
        buttonImpartit = view.findViewById(R.id.btn_impartit)
        buttonPatrat = view.findViewById(R.id.btn_patrat)
        buttonXlaN = view.findViewById(R.id.btn_xlan)
        buttonMod = view.findViewById(R.id.btn_modulo)
        buttonRadical = view.findViewById(R.id.btn_radical)
        field1 = view.findViewById(R.id.value1)
        field2 = view.findViewById(R.id.value2)

        buttonPlus.setOnClickListener(this)
        buttonMinus.setOnClickListener(this)
        buttonC.setOnClickListener(this)
        buttonInmultit.setOnClickListener(this)
        buttonImpartit.setOnClickListener(this)
        buttonPatrat.setOnClickListener(this)
        buttonXlaN.setOnClickListener(this)
        buttonMod.setOnClickListener(this)
        buttonRadical.setOnClickListener(this)
    }

    private fun getDouble(editText: EditText): Double {
        return if (editText.text.toString().isEmpty()) {
            Toast.makeText(requireContext(), "Introduceti valoarea", Toast.LENGTH_SHORT).show()
            0.0
        } else {
            editText.text.toString().toDouble()
        }
    }

    override fun onClick(view: View) {
        nr1 = getDouble(field1)
        nr2 = getDouble(field2)

        when (view.id) {
            R.id.btn_plus -> field1.setText((nr1 + nr2).toString())
            R.id.btn_minus -> field1.setText((nr1 - nr2).toString())
            R.id.btn_c -> {
                field1.setText("")
                field2.setText("")
            }
            R.id.btn_inmultit -> field1.setText((nr1 * nr2).toString())
            R.id.btn_impartit -> field1.setText((nr1 / nr2).toString())
            R.id.btn_patrat -> field1.setText((nr1 * nr1).toString())
            R.id.btn_xlan -> {
                var result = 1.0
                for (i in 1..nr2.toInt()) {
                    result *= nr1
                }
                field1.setText(result.toString())
            }
            R.id.btn_modulo -> field1.setText((nr1 % nr2).toString())
            R.id.btn_radical -> field1.setText(sqrt(nr1).toString())

        }
    }
}
