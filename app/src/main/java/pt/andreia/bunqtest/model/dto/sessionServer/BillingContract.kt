package pt.andreia.bunqtest.model.dto.sessionServer


import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class BillingContract(
    @Expose
    @SerializedName("BillingContractSubscription")
    val billingContractSubscription: BillingContractSubscription? = null
)