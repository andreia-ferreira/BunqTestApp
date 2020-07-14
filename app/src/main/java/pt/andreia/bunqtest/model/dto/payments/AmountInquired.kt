package pt.andreia.bunqtest.model.dto.payments


import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class AmountInquired(
    @Expose
    @SerializedName("currency")
    val currency: String? = null,
    @Expose
    @SerializedName("value")
    val value: String? = null
)