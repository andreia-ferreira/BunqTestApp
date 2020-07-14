package pt.andreia.bunqtest.model.dto.payments

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import pt.andreia.bunqtest.model.dto.Error
import pt.andreia.bunqtest.model.dto.deviceServer.DeviceServerResult

data class RequestInquiryResponse (
    @Expose
    @SerializedName("Response")
    val response: List<RequestInquiryResult>? = null,
    @Expose
    @SerializedName("Error")
    val error: List<Error>? = null
)