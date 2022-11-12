data class Transaction(val ImageURL: String, var donorName: Int, var bGroup: Int, var addresss: Int, var types1: Int){
    fun getName(): Int {
        return donorName
    }
    fun getBloodGroup(): Int {
        return bGroup
    }
    fun getAddress(): Int {
        return addresss
    }
    fun getTypes(): Int {
        return types1
    }
}
