package com.example.aykol.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.aykol.R
import com.example.aykol.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
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
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
    }

    private fun initialize() {
        binding.rvNews.adapter = adapter

        adapter.run {
            addItems(News(R.drawable.news.toString(), getString(R.string.news), 1))
            addItems(News(R.drawable.news.toString(), getString(R.string.news), 1))
            addItems(News(R.drawable.news.toString(), getString(R.string.news), 1))
            addItems(News(R.drawable.news.toString(), getString(R.string.news), 1))
            addItems(News(R.drawable.news.toString(), getString(R.string.news), 1))
            addItems(News(R.drawable.news.toString(), getString(R.string.news), 1))
            addItems(News(R.drawable.news.toString(), getString(R.string.news), 1))
            addItems(News(R.drawable.news.toString(), getString(R.string.news), 1))
        }
    }
    private fun click(news: News) {
        if (news.keyId == 1)
            findNavController().navigate(R.id.newsFragment)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}