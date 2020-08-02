package pt.andreia.bunqtest.utils.format

import java.util.*

object CurrencyUtils {
    private val pattern = Regex("\\d+(\\.\\d+)?")

    @JvmStatic
    fun stringToCurrency(value: String?, currencySymbol: String?): String? {
        var formattedValue: String? = null
        if (!value.isNullOrEmpty() && !currencySymbol.isNullOrEmpty()) {
            if (pattern.matches(value)) {
                formattedValue = "$value $currencySymbol"
            }
        }
        return formattedValue
    }

    @JvmStatic
    fun currencyToString(value: String?, currencySymbol: String?): String? {
        var formattedValue: String? = null
        if (!value.isNullOrEmpty() && !currencySymbol.isNullOrEmpty()) {
            formattedValue = value.replace(currencySymbol, "").trim()
        }
        return formattedValue
    }

    fun validateCurrency(value: String?): Boolean {
        var valid = false

        if (!value.isNullOrEmpty()) {
            valid = pattern.matches(value)
        }
        return valid
    }
}