package pt.andreia.bunqtest.model.dto.payments


import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class PaymentsResult(
    @Expose
    @SerializedName("Payment")
    val payment: Payment? = null
)