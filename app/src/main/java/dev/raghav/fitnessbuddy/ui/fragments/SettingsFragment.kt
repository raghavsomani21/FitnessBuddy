package dev.raghav.fitnessbuddy.ui.fragments

import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.Toolbar
import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import dev.raghav.fitnessbuddy.R
import dev.raghav.fitnessbuddy.other.Constants.KEY_NAME
import dev.raghav.fitnessbuddy.other.Constants.KEY_WEIGHT
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_settings.*
import kotlinx.android.synthetic.main.fragment_setup.*
import kotlinx.android.synthetic.main.fragment_setup.etName
import javax.inject.Inject

@AndroidEntryPoint
class SettingsFragment: Fragment(R.layout.fragment_settings) {

    @Inject
    lateinit var sharedPreferences: SharedPreferences

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        loadFieldsFromSharedPreferences()

        btnApplyChanges.setOnClickListener {
            val success = applyChangesToSharedPreferences()
            if(success) {
                Snackbar.make(view,"Saved Changes",Snackbar.LENGTH_LONG).show()
            } else {
                Snackbar.make(view,"Please fill out all the fields!!",Snackbar.LENGTH_LONG).show()
            }
        }
    }

    private fun loadFieldsFromSharedPreferences() {
        val name = sharedPreferences.getString(KEY_NAME,"")
        val weight = sharedPreferences.getFloat(KEY_WEIGHT,80f)
        etNameSettings.setText(name)
        etWeightSettings.setText(weight.toString())
    }

    private fun applyChangesToSharedPreferences() : Boolean {
        val nameText = etNameSettings.text.toString()
        val weightText = etWeightSettings.text.toString()
        if(nameText.isEmpty() || weightText.isEmpty())
            return false
        sharedPreferences.edit()
            .putString(KEY_NAME,nameText)
            .putFloat(KEY_WEIGHT,weightText.toFloat())
            .apply()
        val toolbarText = "Let's go $nameText"
        requireActivity().tvToolbarTitle.text = toolbarText
        return true
    }

}