data class Transaction(val ImageURL: String, var donorName: Int, var addresss: Int, var dates: Int){
    fun getName(): Int {
        return donorName
    }
    fun getAddress(): Int {
        return addresss
    }
    fun getDate(): Int {
        return dates
    }
}
