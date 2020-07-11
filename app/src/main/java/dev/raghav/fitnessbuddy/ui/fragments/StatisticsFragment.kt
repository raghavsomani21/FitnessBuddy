package dev.raghav.fitnessbuddy.ui.fragments

import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import dev.raghav.fitnessbuddy.R
import dev.raghav.fitnessbuddy.ui.viewmodels.MainViewModel
import dev.raghav.fitnessbuddy.ui.viewmodels.StatisticsViewModel

@AndroidEntryPoint
class StatisticsFragment: Fragment(R.layout.fragment_statistics) {

    private val viewModel: StatisticsViewModel by viewModels()
}