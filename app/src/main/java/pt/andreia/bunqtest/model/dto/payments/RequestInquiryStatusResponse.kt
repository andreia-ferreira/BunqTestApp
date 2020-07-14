package pt.andreia.bunqtest.model.dto.payments

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import pt.andreia.bunqtest.model.dto.Error

data class RequestInquiryStatusResponse (
    @Expose
    @SerializedName("Response")
    val response: List<RequestInquiryStatusResult>? = null,
    @Expose
    @SerializedName("Error")
    val error: List<Error>?
)