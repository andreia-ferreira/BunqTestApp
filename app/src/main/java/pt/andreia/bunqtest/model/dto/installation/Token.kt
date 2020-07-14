package pt.andreia.bunqtest.model.dto.installation


import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Token(
    @Expose
    @SerializedName("created")
    val created: String? = null,
    @Expose
    @SerializedName("id")
    val id: Int? = null,
    @Expose
    @SerializedName("token")
    val token: String? = null,
    @Expose
    @SerializedName("updated")
    val updated: String? = null
)