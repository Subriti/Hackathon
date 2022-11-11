package com.example.hackathon

import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import java.util.*

class SignUpFragment : Fragment() {

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
                        birthDate.setText("" + mDay + "/" + mMonth + "/" + mYear)
                    }, year, month, day
                )
            }
            if (datepickerdialog != null) {
                datepickerdialog.show()
            }
            }

/*
        val secondFragment = Fragment2()
        val secondfragmentBtn = v.findViewById<Button>(R.id.fragmentbutton2)

        secondfragmentBtn.setOnClickListener {
            val transaction: FragmentTransaction = requireFragmentManager().beginTransaction()
            transaction.replace(R.id.ReplaceLayout, secondFragment)
            transaction.addToBackStack(null)
            transaction.commit()
        }*/
        return v
        //val mainActivity= MainActivity()
        //mainActivity.supportFragmentManager
    }
}