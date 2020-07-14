package pt.andreia.bunqtest.model.dto.deviceServer


import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import pt.andreia.bunqtest.model.dto.Error
import pt.andreia.bunqtest.model.dto.installation.InstallationResult

data class DeviceServerResponse(
    @Expose
    @SerializedName("Response")
    val response: List<DeviceServerResult>? = null,
    @Expose
    @SerializedName("Error")
    val error: List<Error>? = null
)