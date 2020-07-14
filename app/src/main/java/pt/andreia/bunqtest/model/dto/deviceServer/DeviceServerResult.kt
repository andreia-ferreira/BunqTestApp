package pt.andreia.bunqtest.model.dto.deviceServer

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import pt.andreia.bunqtest.model.dto.Error

data class DeviceServerResult (
    @Expose
    @SerializedName("Id")
    val idResult: Id? = null
)
