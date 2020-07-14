package pt.andreia.bunqtest.model.dto.payments


import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class RequestInquiry(
    @Expose
    @SerializedName("address_billing")
    val addressBilling: Any? = null,
    @Expose
    @SerializedName("address_shipping")
    val addressShipping: Any? = null,
    @Expose
    @SerializedName("attachment")
    val attachment: List<Any>? = null,
    @Expose
    @SerializedName("batch_id")
    val batchId: Any? = null,
    @Expose
    @SerializedName("bunqme_share_url")
    val bunqmeShareUrl: Any? = null,
    @Expose
    @SerializedName("created")
    val created: String? = null,
    @Expose
    @SerializedName("description")
    val description: String? = null,
    @Expose
    @SerializedName("geolocation")
    val geolocation: Any? = null,
    @Expose
    @SerializedName("id")
    val id: Int? = null,
    @Expose
    @SerializedName("merchant_reference")
    val merchantReference: Any? = null,
    @Expose
    @SerializedName("minimum_age")
    val minimumAge: Any? = null,
    @Expose
    @SerializedName("monetary_account_id")
    val monetaryAccountId: Int? = null,
    @Expose
    @SerializedName("redirect_url")
    val redirectUrl: Any? = null,
    @Expose
    @SerializedName("reference_split_the_bill")
    val referenceSplitTheBill: Any? = null,
    @Expose
    @SerializedName("require_address")
    val requireAddress: Any? = null,
    @Expose
    @SerializedName("scheduled_id")
    val scheduledId: Any? = null,
    @Expose
    @SerializedName("status")
    val status: String? = null,
    @Expose
    @SerializedName("time_expiry")
    val timeExpiry: Any? = null,
    @Expose
    @SerializedName("time_responded")
    val timeResponded: String? = null,
    @Expose
    @SerializedName("updated")
    val updated: String? = null,
    @Expose
    @SerializedName("user_alias_revoked")
    val userAliasRevoked: Any? = null
)