package dev.raghav.fitnessbuddy.ui.viewmodels

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.raghav.fitnessbuddy.db.Run
import dev.raghav.fitnessbuddy.repository.MainRepository
import kotlinx.coroutines.launch

class MainViewModel @ViewModelInject constructor(
    val mainRepository: MainRepository
): ViewModel() {

    val runsSortedByDate = mainRepository.getAllRunsSortedByDate()

    fun insertRun(run:Run) = viewModelScope.launch {
        mainRepository.insertRun(run)
    }

}