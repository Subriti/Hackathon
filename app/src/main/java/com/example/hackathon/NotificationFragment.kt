import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import com.example.hackathon.BankNotifications
import com.example.hackathon.R

class NotificationFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val v = inflater.inflate(R.layout.fragment_notifications, container, false)

        val bloodbankNotif= v.findViewById<Button>(R.id.bloodBankNotif)
        bloodbankNotif.setOnClickListener {
            val intent = Intent(context, BankNotifications::class.java)
            startActivity(intent)
        }



        val completionNotif = v.findViewById<ConstraintLayout>(R.id.completion_notif)
        completionNotif.setOnClickListener {
            val builder = context?.let { it1 -> AlertDialog.Builder(it1) }
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
                                Toast.makeText(
                                    context,
                                    "Thankyou for your time and effort",
                                    Toast.LENGTH_LONG
                                ).show()

                                val layout= v.findViewById<ConstraintLayout>(R.id.frameLayout)
                                layout.removeAllViews()
                                /* val intent = Intent(Intent.ACTION_VIEW)
                            intent.setData(Uri.parse("https://esewa.com.np/#/home"))
                            startActivity(intent)*/
                            }
                        } catch (e: Exception) {
                            Toast.makeText(
                                context,
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
        return v
    }
}
