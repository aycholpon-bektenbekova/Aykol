package com.example.aykol.ui.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.aykol.R
import com.example.aykol.databinding.FragmentProfileBinding
import com.example.aykol.ui.home.Model
import com.example.aykol.ui.home.NewsAdapter

class ProfileFragment : Fragment() {

    private var _binding: FragmentProfileBinding? = null
    private val adapter = NewsAdapter(
        context = this,
        onClick = this::clickAdapter
    )

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val notificationsViewModel =
            ViewModelProvider(this).get(NotificationsViewModel::class.java)

        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        val root: View = binding.root

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        click()
        initialize()
    }

    private fun initialize() {
        binding.rvProfile.adapter = adapter

        val itemList = listOf(
            Model(R.drawable.ic_notifications, getString(R.string.notification), 1),
            Model(R.drawable.earth, getString(R.string.language), 2),
            Model(R.drawable.personal, getString(R.string.personal), 3),
            Model(R.drawable.car, getString(R.string.my_cars), 4)
        )
        adapter.addItems(itemList)
    }

    private fun clickAdapter(model: Model) {
        when (model.keyId) {
            1 -> findNavController()
            2 -> findNavController().navigate(R.id.recordFragment)
            3 -> findNavController().navigate(R.id.houseFragment)
            4 -> findNavController()
        }
    }

    private fun click() {
        binding.nextProfile.setOnClickListener {
            findNavController().navigate(R.id.profileOptionsFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}