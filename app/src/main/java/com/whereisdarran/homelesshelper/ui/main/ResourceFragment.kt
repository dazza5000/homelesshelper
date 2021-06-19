package com.whereisdarran.homelesshelper.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.whereisdarran.homelesshelper.databinding.MainFragmentBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ResourceFragment : Fragment() {

    companion object {
        fun newInstance() = ResourceFragment()
    }

    private val viewModel by viewModels<ResourceViewModel>()
    private val resourceAdapter: ResourceAdapter = ResourceAdapter()

    private lateinit var binding: MainFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = MainFragmentBinding.inflate(inflater, container, false)
        binding.resourceRecyclerView.adapter = resourceAdapter
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel.resources.observe(viewLifecycleOwner) {
            resourceAdapter.submitList(it)
        }
    }
}
