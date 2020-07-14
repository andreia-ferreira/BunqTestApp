package pt.andreia.bunqtest.model.dto.payments


import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class LabelUser(
    @Expose
    @SerializedName("country")
    val country: String? = null,
    @Expose
    @SerializedName("display_name")
    val displayName: String? = null,
    @Expose
    @SerializedName("public_nick_name")
    val publicNickName: String? = null,
    @Expose
    @SerializedName("uuid")
    val uuid: String? = null
)