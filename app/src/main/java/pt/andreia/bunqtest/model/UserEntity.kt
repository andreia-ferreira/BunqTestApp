package pt.andreia.bunqtest.model

data class UserEntity(
    val userId: Int,
    val name: String,
    val billingAccountId: Int
) {
    companion object {
        const val KEY_USER_ID = "KEY_USER_ID"
        const val KEY_MONETARY_ID = "KEY_MONETARY_ID"
    }
}