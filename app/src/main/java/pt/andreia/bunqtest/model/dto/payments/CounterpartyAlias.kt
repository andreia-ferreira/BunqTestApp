package pt.andreia.bunqtest.model.dto.payments


import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class CounterpartyAlias(
    @Expose
    @SerializedName("iban")
    val iban: String? = null,
    @Expose
    @SerializedName("is_light")
    val isLight: Boolean? = null,
    @Expose
    @SerializedName("label_user")
    val labelUser: LabelUser? = null,
    @Expose
    @SerializedName("bunq_me")
    val bunqMe: BunqMe? = null

)