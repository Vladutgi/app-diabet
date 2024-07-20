package com.example.calculator

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.calculator.databinding.FragmentEcranprincipalBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class EcranPrincipal : Fragment() {

    private var _binding: FragmentEcranprincipalBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentEcranprincipalBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.buttonSecond.setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_CalculatorGlucide)
        }
        binding.buttonThird.setOnClickListener{
            findNavController().navigate(R.id.action_FirstFragment_to_AdaugaProdus)
        }
        binding.buttonFourth.setOnClickListener{
            findNavController().navigate(R.id.action_FirstFragment_to_Lista)
        }
        binding.buttonFifth.setOnClickListener{
            findNavController().navigate(R.id.action_FirstFragment_to_CarbohidratiMancare)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}