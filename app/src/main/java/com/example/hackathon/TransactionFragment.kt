import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.MusicPlayer.Adapters.TransactionAdapter
import com.example.hackathon.R


class TransactionFragment : Fragment() {
    var resource: String? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val v = inflater.inflate(R.layout.fragment_transactions, container, false)
        // Initialize data.
        val donorDataset = TransactionDatasource().loadSongs()

        val recyclerView = v.findViewById<RecyclerView>(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(context)

        val image = v.findViewById<ImageView>(R.id.donor_image)

        var adapter = context?.let {
            TransactionAdapter(it, donorDataset) { users->
                //got stringId
                val name = users.getName()
                val address= users.getAddress()

                //gives string name
                //val songName= resources.getResourceEntryName(name)
                //val audioName= resources.getResourceEntryName(audioId)

                //converted it to string value
                resource = resources.getString(name)
                val add= resources.getString(address)
            }

        }
        recyclerView.adapter = adapter
        return v
    }

}