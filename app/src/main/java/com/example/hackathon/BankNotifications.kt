package com.example.hackathon

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.RatingBar
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.constraintlayout.widget.ConstraintLayout

class BankNotifications : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bank_notif)

        val completionNotif = findViewById<ConstraintLayout>(R.id.completion_notif)
        completionNotif.setOnClickListener {
            val builder = this.let { it1 -> AlertDialog.Builder(it1) }
            val dialogView = layoutInflater.inflate(R.layout.confirmation_prompt, null)

            if (builder != null) {
                builder.setView(dialogView)
                    .setPositiveButton("Send") { _, i ->

                        val radioGroup =
                            dialogView.findViewById<RadioGroup>(R.id.confirmation_group)
                        val selection = radioGroup.checkedRadioButtonId

                        try {
                            var confirmation = dialogView.findViewById<RadioButton>(selection)
                            if (confirmation.text == "Yes") {

                                //rating ko kura
                                val builder = this.let { it1 -> AlertDialog.Builder(it1) }
                                val dialogView = layoutInflater.inflate(R.layout.rating_prompt, null)

                                if (builder != null) {
                                    builder.setView(dialogView)
                                        .setPositiveButton("Send") { _, i ->

                                            //val ratingBar= findViewById<RatingBar>(R.id.ratingBar)

                                            try {
                                                   //val stars= ratingBar.numStars
                                                   //println("Stars rating " +stars)
                                                   //val rating= ratingBar.rating
                                                   //println("Rating is +" +rating)
                                                  //Toast.makeText(this,"You rated: $rating", Toast.LENGTH_LONG).show()
                                                  //if (rating != null) {
                                                      val intent = Intent(Intent.ACTION_VIEW)
                                                      intent.setData(Uri.parse("https://esewa.com.np/#/home"))
                                                      startActivity(intent)
                                                  //}


                                            } catch (e: Exception) {
                                                Toast.makeText(
                                                    this,
                                                    "Please rate the donor",
                                                    Toast.LENGTH_LONG
                                                ).show()
                                            }
                                        }
                                        .setNegativeButton("Cancel") { _, i -> //cancel and close the dialog
                                        }
                                        .show()
                                }
/*
                                val intent = Intent(Intent.ACTION_VIEW)
                                intent.setData(Uri.parse("https://esewa.com.np/#/home"))
                                startActivity(intent)*/
                            }
                        } catch (e: Exception) {
                            Toast.makeText(
                                this,
                                "Please input one choice",
                                Toast.LENGTH_LONG
                            ).show()
                        }
                    }
                    .setNegativeButton("Cancel") { _, i -> //cancel and close the dialog
                    }
                    .show()
            }
        }
    }
}