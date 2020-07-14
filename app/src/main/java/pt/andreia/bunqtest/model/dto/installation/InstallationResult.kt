package pt.andreia.bunqtest.model.dto.installation


import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import pt.andreia.bunqtest.model.dto.Error

data class InstallationResult(
    @Expose
    @SerializedName("Id")
    val id: Id? = null,
    @Expose
    @SerializedName("ServerPublicKey")
    val serverPublicKey: ServerPublicKey? = null,
    @Expose
    @SerializedName("Token")
    val token: Token? = null
) {
    companion object {
        const val POSITION_ID = 0
        const val POSITION_TOKEN = 1
        const val POSITION_SERVER_KEY = 2
    }
}