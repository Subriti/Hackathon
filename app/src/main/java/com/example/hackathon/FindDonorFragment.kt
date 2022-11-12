
import android.app.DatePickerDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import com.example.hackathon.R
import java.util.*


class FindDonorFragment : Fragment(),AdapterView.OnItemSelectedListener {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val v=inflater.inflate(R.layout.fragment_find_donor, container, false)

        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)

        val pickDatebtn = v.findViewById<ImageView>(R.id.pickDatebtn4)
        val donationDate = v.findViewById<TextView>(R.id.date)
        pickDatebtn.setOnClickListener {
            val datepickerdialog = context?.let { it1 ->
                DatePickerDialog(
                    it1, DatePickerDialog.OnDateSetListener { view, mYear, mMonth, mDay ->
                        donationDate.setText("" + mDay + "/" + mMonth + "/" + mYear)
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

        val spinner1: Spinner = v.findViewById(R.id.spinnerLocation)
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter.createFromResource(
            requireContext(),
            R.array.location_array,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            // Specify the layout to use when the list of choices appears
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Apply the adapter to the spinner

            spinner1.adapter = adapter

            spinner1.onItemSelectedListener=this
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