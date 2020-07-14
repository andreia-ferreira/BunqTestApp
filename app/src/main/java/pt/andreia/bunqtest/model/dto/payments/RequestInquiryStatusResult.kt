package pt.andreia.bunqtest.model.dto.payments


import com.google.gson.annotations.SerializedName

data class RequestInquiryStatusResult(
    @SerializedName("RequestInquiry")
    val requestInquiry: RequestInquiry? = null
)