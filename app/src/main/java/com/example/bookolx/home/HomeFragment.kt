package com.example.bookolx.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.bookolx.R
import com.example.bookolx.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    private lateinit var viewModel: HomeViewModel
    private lateinit var viewModelFactory: HomeViewModelFactory

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentHomeBinding>(inflater, R.layout.fragment_home, container, false)

        viewModelFactory = HomeViewModelFactory(HomeFragmentArgs.fromBundle(requireArguments()).token!!,
            HomeFragmentArgs.fromBundle(requireArguments()).email!!,
            HomeFragmentArgs.fromBundle(requireArguments()).username!!)
        viewModel = ViewModelProvider(this, viewModelFactory).get(HomeViewModel::class.java)

        binding.textView.text = viewModel.email + " " + viewModel.username + "\n" + viewModel.token

        return binding.root
    }
}