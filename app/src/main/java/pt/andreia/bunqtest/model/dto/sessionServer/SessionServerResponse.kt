package pt.andreia.bunqtest.model.dto.sessionServer


import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import pt.andreia.bunqtest.model.dto.Error

data class SessionServerResponse(
    @Expose
    @SerializedName("Response")
    val sessionServerResult: List<SessionServerResult>? = null,
    @Expose
    @SerializedName("Error")
    val error: List<Error>? = null

)