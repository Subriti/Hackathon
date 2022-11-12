import ExploreDatasource
import android.media.AudioManager
import android.media.MediaPlayer
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.MusicPlayer.Adapters.ExploreAdapter
import com.example.hackathon.R


class ExploreFragment : Fragment() {
    var resource: String? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val v = inflater.inflate(R.layout.fragment_explore, container, false)
        // Initialize data.
        val donorDataset = ExploreDatasource().loadSongs()

        val recyclerView = v.findViewById<RecyclerView>(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(context)

        val image = v.findViewById<ImageView>(R.id.donor_image)

        var adapter = context?.let {
            ExploreAdapter(it, donorDataset) { users->
                //got stringId
                val name = users.getName()
                val address= users.getAddress()
                val bloodGroup= users.getBloodGroup()
                val type= users.getTypes()

                //gives string name
                //val songName= resources.getResourceEntryName(name)
                //val audioName= resources.getResourceEntryName(audioId)

                //converted it to string value
                resource = resources.getString(name)
                val add= resources.getString(address)
                val blood= resources.getString(bloodGroup)
                val types= resources.getString(type)
            }

        }
        recyclerView.adapter = adapter
        return v
    }

}