package com.example.aykol.ui.services

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.aykol.R
import com.example.aykol.databinding.FragmentServicesBinding
import com.example.aykol.ui.home.Model
import com.example.aykol.ui.home.NewsAdapter

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
        //binding.rvNews.adapter = adapter

        adapter.run {
            addItems(Model(R.drawable.service.toString(), getString(R.string.school), 1))
            addItems(Model(R.drawable.heart.toString(), getString(R.string.record), 2))
            addItems(Model(R.drawable.house.toString(), getString(R.string.house), 3))
            addItems(Model(R.drawable.paper.toString(), getString(R.string.papers), 4))
        }
    }
    private fun click(model: Model) {
        if (model.keyId == 1)
            findNavController().navigate(R.id.navigation_dashboard)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}