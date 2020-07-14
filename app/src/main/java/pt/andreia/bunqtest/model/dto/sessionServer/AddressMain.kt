package pt.andreia.bunqtest.model.dto.sessionServer


import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class AddressMain(
    @Expose
    @SerializedName("city")
    val city: String? = null,
    @Expose
    @SerializedName("country")
    val country: String? = null,
    @Expose
    @SerializedName("extra")
    val extra: Any? = null,
    @Expose
    @SerializedName("house_number")
    val houseNumber: String? = null,
    @Expose
    @SerializedName("mailbox_name")
    val mailboxName: Any? = null,
    @Expose
    @SerializedName("postal_code")
    val postalCode: String? = null,
    @Expose
    @SerializedName("province")
    val province: Any? = null,
    @Expose
    @SerializedName("street")
    val street: String? = null
)