package pt.andreia.bunqtest.model.dto.installation


import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import pt.andreia.bunqtest.model.dto.Error

data class InstallationResponse(
    @Expose
    @SerializedName("Response")
    val response: List<InstallationResult>? = null,
    @Expose
    @SerializedName("Error")
    val error: List<Error>? = null
)