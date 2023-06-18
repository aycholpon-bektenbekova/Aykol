package com.example.aykol

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.aykol.databinding.FragmentAuthBinding
import com.google.android.material.navigation.NavigationView

class AuthFragment : Fragment() {

    private lateinit var binding: FragmentAuthBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAuthBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        click()
    }

    private fun personNumberCheck() {
        if (binding.personNumber.minEms < 14) {
            Toast.makeText(requireContext(), getString(R.string._10), Toast.LENGTH_SHORT).show()
        }
    }

    private fun click() {
        binding.btnNext.setOnClickListener {
            personNumberCheck()
            if (binding.personNumber.text.isNotEmpty() ||
                binding.password.text.isNotEmpty()
            ) {
                findNavController().navigate(R.id.navigation_home)
            } else Toast.makeText(requireContext(), getString(R.string.inputs), Toast.LENGTH_SHORT).show()
        }
    }
}