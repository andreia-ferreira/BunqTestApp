package pt.andreia.bunqtest.model.dto


import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Error(
    @Expose
    @SerializedName("error_description")
    val errorDescription: String? = null,
    @Expose
    @SerializedName("error_description_translated")
    val errorDescriptionTranslated: String? = null
)