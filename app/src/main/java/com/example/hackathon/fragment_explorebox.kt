package com.example.hackathon

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*

class frament_explorebox : Fragment(),AdapterView.OnItemSelectedListener {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v = inflater.inflate(R.layout.fragment_find_donor, container, false)

        val spinner_loc: Spinner = v.findViewById(R.id.spinnerLocation)
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter.createFromResource(
            requireContext(),
            R.array.location_array,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            // Specify the layout to use when the list of choices appears
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Apply the adapter to the spinner
            spinner_loc.adapter = adapter
            spinner_loc.onItemSelectedListener=this
        }

        val spinnerExplore: Spinner = v.findViewById(R.id.spinnerExplore)
        ArrayAdapter.createFromResource(
            requireContext(),
            R.array.bloodGroup_array,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            // Specify the layout to use when the list of choices appears
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Apply the adapter to the spinner
            spinnerExplore.adapter = adapter
            spinnerExplore.onItemSelectedListener=this
        }
        return v
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, pos: Int, id: Long) {
        // val selection= parent?.getItemAtPosition(pos)
        val item= parent?.selectedItem
        //println(item)
        //Toast.makeText(context,"$item is selected", Toast.LENGTH_SHORT).show()
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {
        TODO("Not yet implemented")
    }}