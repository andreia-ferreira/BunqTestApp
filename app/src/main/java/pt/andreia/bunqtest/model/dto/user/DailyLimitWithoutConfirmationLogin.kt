package pt.andreia.bunqtest.model.dto.user


import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class DailyLimitWithoutConfirmationLogin(
    @Expose
    @SerializedName("currency")
    val currency: String? = null,
    @Expose
    @SerializedName("value")
    val value: String? = null
)