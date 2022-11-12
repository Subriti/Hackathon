import com.example.hackathon.R

class ExploreDatasource {
    fun loadSongs(): List<Explore> {
        return listOf(
            Explore(
               "", R.string.donor1, R.string.address1, R.string.bloodGroup1, R.string.type1
            ),
            Explore(
                "",R.string.donor2, R.string.address2, R.string.bloodGroup2, R.string.type2
            ),
            Explore(
                "",R.string.donor3, R.string.address3, R.string.bloodGroup3, R.string.type3
            ),
            Explore(
                "",R.string.donor4, R.string.address4, R.string.bloodGroup4, R.string.type4
            ),
            Explore(
                "",R.string.donor5, R.string.address5, R.string.bloodGroup5, R.string.type5
            )
        )
    }

}
