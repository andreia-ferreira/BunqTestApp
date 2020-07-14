package pt.andreia.bunqtest.model.dto.payments


import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Payment(
    @Expose
    @SerializedName("address_billing")
    val addressBilling: Any? = null,
    @Expose
    @SerializedName("address_shipping")
    val addressShipping: Any? = null,
    @Expose
    @SerializedName("alias")
    val alias: Alias? = null,
    @Expose
    @SerializedName("amount")
    val amount: Amount? = null,
    @Expose
    @SerializedName("attachment")
    val attachment: List<Any>? = null,
    @Expose
    @SerializedName("balance_after_mutation")
    val balanceAfterMutation: BalanceAfterMutation? = null,
    @Expose
    @SerializedName("batch_id")
    val batchId: Any? = null,
    @Expose
    @SerializedName("counterparty_alias")
    val counterpartyAlias: CounterpartyAlias? = null,
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
    @SerializedName("monetary_account_id")
    val monetaryAccountId: Int? = null,
    @Expose
    @SerializedName("payment_auto_allocate_instance")
    val paymentAutoAllocateInstance: Any? = null,
    @Expose
    @SerializedName("request_reference_split_the_bill")
    val requestReferenceSplitTheBill: List<Any>? = null,
    @Expose
    @SerializedName("scheduled_id")
    val scheduledId: Any? = null,
    @Expose
    @SerializedName("sub_type")
    val subType: String? = null,
    @Expose
    @SerializedName("type")
    val type: String? = null,
    @Expose
    @SerializedName("updated")
    val updated: String? = null
)