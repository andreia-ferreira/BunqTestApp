package pt.andreia.bunqtest.model.dto.installation


import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class InstallationInput(
    @Expose
    @SerializedName("client_public_key")
    val clientPublicKey: String = ""
)