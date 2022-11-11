package com.example.androidteste.view

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

//    override fun onStart() {
//        super.onStart()
//        calculator()
//    }
    private fun calculator() {
        initialTime = Date()
        var numberIterations: Long = 10000;
        for(i in 0.. numberIterations) {

            val cosseno = cos(i.toDouble())
            val seno = sin(cosseno)
            val tangente = tan(seno)
        }
        finalTime = Date()
        processingTime = finalTime.time - initialTime.time
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        calculator()
        var view =  inflater.inflate(R.layout.fragment_secon_plan_page, container, false)
        val timeText = view.findViewById<TextView>(R.id.timeInMiliseconds)
        timeText.text = processingTime.toString()
        print(processingTime)
        return view
    }
}