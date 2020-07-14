package pt.andreia.bunqtest.model.dto.deviceServer


import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class DeviceServerInput(
    @Expose
    @SerializedName("description")
    val description: String,
    @Expose
    @SerializedName("permitted_ips")
    val permittedIps: List<String>,
    @Expose
    @SerializedName("secret")
    val secret: String
)