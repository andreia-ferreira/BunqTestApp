package pt.andreia.bunqtest.model.dto.user


import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Customer(
    @Expose
    @SerializedName("billing_account_id")
    val billingAccountId: Int? = null,
    @Expose
    @SerializedName("created")
    val created: String? = null,
    @Expose
    @SerializedName("id")
    val id: Int? = null,
    @Expose
    @SerializedName("invoice_notification_preference")
    val invoiceNotificationPreference: String? = null,
    @Expose
    @SerializedName("updated")
    val updated: String? = null
)