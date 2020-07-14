package pt.andreia.bunqtest.model.dto.payments


import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import pt.andreia.bunqtest.model.dto.Error
import pt.andreia.bunqtest.model.dto.Pagination

data class ListPaymentsResponse(
    @Expose
    @SerializedName("Pagination")
    val pagination: Pagination? = null,
    @Expose
    @SerializedName("Response")
    val paymentsResult: List<PaymentsResult>? = null,
    @Expose
    @SerializedName("Error")
    val error: List<Error>? = null
)