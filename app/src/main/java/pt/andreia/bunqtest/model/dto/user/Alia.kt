package pt.andreia.bunqtest.model.dto.user


import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Alia(
    @Expose
    @SerializedName("name")
    val name: String? = null,
    @Expose
    @SerializedName("type")
    val type: String? = null,
    @Expose
    @SerializedName("value")
    val value: String? = null
)