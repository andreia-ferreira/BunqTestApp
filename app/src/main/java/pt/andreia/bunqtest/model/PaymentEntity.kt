package pt.andreia.bunqtest.model

data class PaymentEntity(
    val idPayment: Int,
    val amount: String,
    val date: String,
    val nameDestination: String,
    var description: String = ""
)