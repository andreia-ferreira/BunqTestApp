package pt.andreia.bunqtest.model.dto.payments


import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class NewRequestInquiry(
    @Expose
    @SerializedName("allow_bunqme")
    val allowBunqme: Boolean? = null,
    @Expose
    @SerializedName("amount_inquired")
    val amountInquired: AmountInquired? = null,
    @Expose
    @SerializedName("counterparty_alias")
    val counterpartyAlias: CounterpartyAliasRequest? = null,
    @Expose
    @SerializedName("description")
    val description: String? = null
)