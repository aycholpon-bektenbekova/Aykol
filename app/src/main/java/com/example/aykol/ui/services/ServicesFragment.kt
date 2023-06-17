package com.example.aykol.ui.services

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.aykol.R
import com.example.aykol.databinding.FragmentServicesBinding
import com.example.aykol.ui.home.NewsAdapter
import com.example.aykol.ui.home.Model

class ServicesFragment : Fragment() {

    private var _binding: FragmentServicesBinding? = null

    private val adapter = NewsAdapter(
        context = this,
        onClick = this::click
    )

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val dashboardViewModel =
            ViewModelProvider(this).get(DashboardViewModel::class.java)

        _binding = FragmentServicesBinding.inflate(inflater, container, false)
        val root: View = binding.root

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
    }

    private fun initialize() {
        binding.rvServices.adapter = adapter

        val itemList = listOf(
            Model(R.drawable.service, getString(R.string.school), 1),
            Model(R.drawable.heart, getString(R.string.record), 2),
            Model(R.drawable.house, getString(R.string.house), 3),
            Model(R.drawable.paper, getString(R.string.papers), 4),
            Model(R.drawable.dollar, getString(R.string.business), 5),
            Model(R.drawable.social, getString(R.string.social_pay), 6),
            Model(R.drawable.family, getString(R.string.family), 7),
            Model(R.drawable.car, getString(R.string.cars_pay), 8)
        )

        adapter.addItems(itemList)

    }
    private fun click(model: Model) {
        when (model.keyId) {
           1 -> Toast.makeText(requireContext(), getString(R.string.in_develop), Toast.LENGTH_SHORT).show()
            2 -> findNavController().navigate(R.id.recordFragment)
            3 -> findNavController().navigate(R.id.houseFragment)
            4 -> findNavController()
            5 -> findNavController()
            6 -> findNavController()
            7 -> findNavController()
            8 -> findNavController()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}