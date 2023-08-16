package com.example.alomoves.ui.fragments.classes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.alomoves.data.repositories.ClassesRepository
import com.example.alomoves.databinding.FragmentClassesBinding
import com.example.alomoves.ui.fragments.ParentFragment
import com.example.alomoves.ui.fragments.classes.adapter.ClassesAdapter
import com.example.alomoves.ui.fragments.classes.viewmodel.ClassesViewModel
import com.example.alomoves.ui.fragments.classes.viewmodel.ClassesViewModelFactory
import kotlinx.coroutines.launch

class ClassesFragment : ParentFragment() {
    private lateinit var binding: FragmentClassesBinding
    private lateinit var viewModel: ClassesViewModel
    private val classesAdapter = ClassesAdapter {
        viewModel.navigateToOverviewFragment(it.classesDescription)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentClassesBinding.inflate(inflater , container, false)

        binding.classesRecyclerView.adapter = classesAdapter
        val repository = ClassesRepository(requireContext())
        val viewModelFactory = ClassesViewModelFactory(repository)

        viewModel = ViewModelProvider(this, viewModelFactory)[ClassesViewModel::class.java]
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
        viewModel.navigator = this

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        this.render()
    }

    private fun render() {
        lifecycleScope.launch {
            viewModel.classLiveData.observe(viewLifecycleOwner) {
                if (it.isNotEmpty()) {
                    classesAdapter.submitList(it)
                } else {
                    Toast.makeText(requireContext(), "Data not exist", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}