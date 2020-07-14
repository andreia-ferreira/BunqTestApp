package pt.andreia.bunqtest.model.dto.installation


import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Id(
    @Expose
    @SerializedName("id")
    val id: Int? = null
)