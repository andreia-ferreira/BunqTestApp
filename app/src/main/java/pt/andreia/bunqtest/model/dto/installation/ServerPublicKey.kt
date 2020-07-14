package pt.andreia.bunqtest.model.dto.installation


import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ServerPublicKey(
    @Expose
    @SerializedName("server_public_key")
    val serverPublicKey: String? = null
)