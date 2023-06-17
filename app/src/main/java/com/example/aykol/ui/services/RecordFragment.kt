package com.example.aykol.ui.services

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.aykol.R
import com.example.aykol.databinding.FragmentRecordBinding

class RecordFragment : Fragment() {

    private lateinit var binding: FragmentRecordBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRecordBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        click()
    }

    private fun click() {
        binding.btnVia.setOnClickListener {
            val url = "https://registratura.med.kg/index"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            requireActivity().startActivity(intent)
        }
        binding.btnViaNumber.setOnClickListener {
            findNavController().navigate(R.id.CFMFragment)
        }
    }

}