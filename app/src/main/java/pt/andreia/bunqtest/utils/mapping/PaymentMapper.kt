package pt.andreia.bunqtest.utils.mapping

import android.util.Log
import pt.andreia.bunqtest.model.PaymentEntity
import pt.andreia.bunqtest.model.dto.payments.PaymentsResult
import java.text.ParseException
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
                    date = payment?.created ?: "",
                    nameDestination = payment?.counterpartyAlias?.labelUser?.displayName ?: "",
                    description = payment?.description ?: ""
                )
            )
        }
        return listPayments
    }

}