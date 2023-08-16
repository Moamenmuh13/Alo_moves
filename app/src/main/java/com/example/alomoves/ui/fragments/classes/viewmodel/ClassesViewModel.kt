package com.example.alomoves.ui.fragments.classes.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.alomoves.data.models.GymClasses
import com.example.alomoves.data.repositories.ClassesRepository
import com.example.alomoves.ui.fragments.classes.ClassesFragmentDirections
import com.example.alomoves.utils.Navigator
import kotlinx.coroutines.launch

class ClassesViewModel(private val repository: ClassesRepository) : ViewModel() {

    private val _classLiveData = MutableLiveData<GymClasses>()
    val classLiveData: LiveData<GymClasses> = _classLiveData

    lateinit var navigator: Navigator

    init {
        viewModelScope.launch {
            try {
                val classes = repository.getClasses()
                _classLiveData.postValue(classes)
            } catch (_: Exception) {
            }
        }
    }

    fun navigateToOverviewFragment(classesDescription: String?) = navigator.navigate(
        ClassesFragmentDirections.actionClassesFragmentToOverviewFragment(
            classesDescription.toString()
        )
    )
}