package com.example.androidteste.view

import SharedPreferencesManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.androidteste.R
import java.util.*
import kotlin.math.cos
import kotlin.math.sin
import kotlin.math.tan

class SecondPlanPage : Fragment() {
    private lateinit var initialTime: Date
    private lateinit var finalTime: Date
    private var processingTime: Long = 0

    private fun sharedPrefTest() {
        initialTime = Date()
        val preferencesManager = SharedPreferencesManager(requireContext());
        var numberIterations: Long = 10000;
        preferencesManager.saveInt("number", 0);
        var i = 0
        while (i < numberIterations) {
            i = preferencesManager.getInt("number", 0)
            preferencesManager.saveInt("number", i + 1)
        }

        finalTime = Date()
        processingTime = finalTime.time - initialTime.time
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        sharedPrefTest()
        var view =  inflater.inflate(R.layout.fragment_secon_plan_page, container, false)
        val timeText = view.findViewById<TextView>(R.id.timeInMiliseconds)
        timeText.text = "O tempo de processamento foi de " + processingTime.toString() + " milissegundos"
        print(processingTime)
        return view
    }
}