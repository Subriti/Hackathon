package com.example.hackathon

import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import java.util.*

class SignUpFragment : Fragment(), AdapterView.OnItemSelectedListener {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v = inflater.inflate(R.layout.sign_up_fragment, container, false)

        val register_btn = v.findViewById<Button>(R.id.submit_btn)
        register_btn.setOnClickListener {
            Toast.makeText(context, "Successfully Registered", Toast.LENGTH_SHORT).show()

            val intent = Intent(context, MainActivity::class.java)
            startActivity(intent)
        }

        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)

        val pickDatebtn = v.findViewById<ImageView>(R.id.pickDatebtn)
        val birthDate = v.findViewById<TextView>(R.id.birthDate)
        pickDatebtn.setOnClickListener {
            val datepickerdialog = context?.let { it1 ->
                DatePickerDialog(
                    it1, DatePickerDialog.OnDateSetListener { view, mYear, mMonth, mDay ->
                        birthDate.text = "" + mDay + "/" + mMonth + "/" + mYear
                    }, year, month, day
                )
            }
            if (datepickerdialog != null) {
                datepickerdialog.show()
            }
            }

        val spinner: Spinner = v.findViewById(R.id.spinnerExplore)
// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter.createFromResource(
            requireContext(),
            R.array.bloodGroup_array,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            // Specify the layout to use when the list of choices appears
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Apply the adapter to the spinner

            spinner.adapter = adapter

            spinner.onItemSelectedListener=this
        }
        return v
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, pos: Int, id: Long) {
        val item= parent?.selectedItem
       }

    override fun onNothingSelected(p0: AdapterView<*>?) {
        TODO("Not yet implemented")
    }
}