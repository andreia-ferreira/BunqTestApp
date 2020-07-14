package pt.andreia.bunqtest.model.dto.payments


import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Alias(
    @Expose
    @SerializedName("country")
    val country: String? = null,
    @Expose
    @SerializedName("display_name")
    val displayName: String? = null,
    @Expose
    @SerializedName("iban")
    val iban: String? = null,
    @Expose
    @SerializedName("is_light")
    val isLight: Boolean? = null,
    @Expose
    @SerializedName("label_user")
    val labelUser: LabelUser? = null
)