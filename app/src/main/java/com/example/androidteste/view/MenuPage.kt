package com.example.androidteste.view

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import com.example.androidteste.R
import com.example.androidteste.database.SQLiteHelper

class MenuPage : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view =  inflater.inflate(R.layout.fragment_menu_page, container, false)
        val secondPlanButton = view.findViewById<Button>(R.id.second_plan_button)
        secondPlanButton.setOnClickListener{
            findNavController().navigate(R.id.action_menuPage_to_seconPlanPage)
        }
        val renderingButton = view.findViewById<Button>(R.id.rendering_button)
        renderingButton.setOnClickListener{
            val intent = Intent(context, DataRenderingPage::class.java)
            startActivity(intent)
        }
        val database = SQLiteHelper(requireContext());
        val x = database.getAllChars()
        println(x)
        return view
    }
}