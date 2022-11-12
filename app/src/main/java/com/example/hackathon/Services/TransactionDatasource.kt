import com.example.hackathon.R

class TransactionDatasource {
    fun loadSongs(): List<Transaction> {
        return listOf(
            Transaction(
               "", R.string.donor1, R.string.address1,R.string.dateOfDonation1
            ),
            Transaction(
                "",R.string.donor2, R.string.address2,R.string.dateOfDonation2
            ),
            Transaction(
                "",R.string.donor3, R.string.address3,R.string.dateOfDonation3
            ),
            Transaction(
                "",R.string.donor4, R.string.address4,R.string.dateOfDonation4
            ),
            Transaction(
                "",R.string.donor5, R.string.address5, R.string.dateOfDonation5
            )
        )
    }

}
