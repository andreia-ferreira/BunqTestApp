package pt.andreia.bunqtest.model.dto.payments

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import pt.andreia.bunqtest.model.dto.deviceServer.Id

data class RequestInquiryResult (
    @Expose
    @SerializedName("Id")
    val idResult: Id? = null
)