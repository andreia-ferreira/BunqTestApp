package pt.andreia.bunqtest.model.dto.sessionServer


import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class BillingContractSubscription(
    @Expose
    @SerializedName("contract_date_end")
    val contractDateEnd: Any? = null,
    @Expose
    @SerializedName("contract_date_start")
    val contractDateStart: String? = null,
    @Expose
    @SerializedName("contract_version")
    val contractVersion: Int? = null,
    @Expose
    @SerializedName("created")
    val created: String? = null,
    @Expose
    @SerializedName("id")
    val id: Int? = null,
    @Expose
    @SerializedName("status")
    val status: String? = null,
    @Expose
    @SerializedName("sub_status")
    val subStatus: String? = null,
    @Expose
    @SerializedName("subscription_type")
    val subscriptionType: String? = null,
    @Expose
    @SerializedName("subscription_type_downgrade")
    val subscriptionTypeDowngrade: String? = null,
    @Expose
    @SerializedName("updated")
    val updated: String? = null
)