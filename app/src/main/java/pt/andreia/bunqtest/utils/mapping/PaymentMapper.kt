package pt.andreia.bunqtest.utils.mapping

import android.util.Log
import pt.andreia.bunqtest.model.PaymentEntity
import pt.andreia.bunqtest.model.dto.payments.PaymentsResult
import java.lang.Exception
import java.text.SimpleDateFormat
import java.util.*

object PaymentMapper {

    val TAG = PaymentMapper::class.java.simpleName

    fun mapListPayment(input: List<PaymentsResult>): List<PaymentEntity> {
        val listPayments = mutableListOf<PaymentEntity>()
        for (paymentResult in input) {
            val payment = paymentResult.payment
            listPayments.add(
                PaymentEntity(
                    idPayment = payment?.id ?: 0,
                    amount = payment?.amount?.value ?: "",
                    date = formatDateString(payment?.created ?: ""),
                    nameDestination = payment?.counterpartyAlias?.labelUser?.displayName ?: "",
                    description = payment?.description ?: ""
                )
            )
        }
        return listPayments
    }

    private fun formatDateString(unformattedDate: String): String {
        var result = ""
        try {
            val parser = SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSSSS", Locale.ENGLISH)
            val formatter = SimpleDateFormat("dd MMM - HH:mm", Locale.ENGLISH)
            result = formatter.format(parser.parse(unformattedDate) ?: Date())
        } catch (e: Exception) {
            Log.e(TAG, e.message.toString())
        }

        return result
    }

}