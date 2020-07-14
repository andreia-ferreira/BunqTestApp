package pt.andreia.bunqtest.model.dto.sessionServer


import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class CustomerLimit(
    @Expose
    @SerializedName("limit_amount_monthly")
    val limitAmountMonthly: Any? = null,
    @Expose
    @SerializedName("limit_card_credit_mastercard")
    val limitCardCreditMastercard: Int? = null,
    @Expose
    @SerializedName("limit_card_debit_maestro")
    val limitCardDebitMaestro: Int? = null,
    @Expose
    @SerializedName("limit_card_debit_maestro_virtual_subscription")
    val limitCardDebitMaestroVirtualSubscription: Int? = null,
    @Expose
    @SerializedName("limit_card_debit_maestro_virtual_total")
    val limitCardDebitMaestroVirtualTotal: Int? = null,
    @Expose
    @SerializedName("limit_card_debit_mastercard")
    val limitCardDebitMastercard: Int? = null,
    @Expose
    @SerializedName("limit_card_debit_mastercard_virtual_subscription")
    val limitCardDebitMastercardVirtualSubscription: Int? = null,
    @Expose
    @SerializedName("limit_card_debit_mastercard_virtual_total")
    val limitCardDebitMastercardVirtualTotal: Int? = null,
    @Expose
    @SerializedName("limit_card_debit_wildcard")
    val limitCardDebitWildcard: Int? = null,
    @Expose
    @SerializedName("limit_card_replacement")
    val limitCardReplacement: Int? = null,
    @Expose
    @SerializedName("limit_card_wildcard")
    val limitCardWildcard: Int? = null,
    @Expose
    @SerializedName("limit_monetary_account")
    val limitMonetaryAccount: Int? = null,
    @Expose
    @SerializedName("limit_monetary_account_remaining")
    val limitMonetaryAccountRemaining: Int? = null,
    @Expose
    @SerializedName("spent_amount_monthly")
    val spentAmountMonthly: Any? = null
)