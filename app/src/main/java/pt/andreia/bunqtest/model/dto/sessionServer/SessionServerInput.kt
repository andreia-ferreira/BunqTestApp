package pt.andreia.bunqtest.model.dto.sessionServer


import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class SessionServerInput(
    @Expose
    @SerializedName("secret")
    val secret: String? = null
): Serializable