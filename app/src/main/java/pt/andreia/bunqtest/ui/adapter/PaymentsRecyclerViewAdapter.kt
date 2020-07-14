package pt.andreia.bunqtest.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import pt.andreia.bunqtest.R
import pt.andreia.bunqtest.databinding.ItemPaymentBinding
import pt.andreia.bunqtest.model.PaymentEntity

class PaymentsRecyclerViewAdapter(private val context: Context, private var listPayments: List<PaymentEntity>, private val onClickPayment: ((Int?) -> (Unit)))
    : RecyclerView.Adapter<PaymentsRecyclerViewAdapter.PaymentViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PaymentsRecyclerViewAdapter.PaymentViewHolder {
        val binding = DataBindingUtil.inflate(
            LayoutInflater.from(context),
            R.layout.item_payment,
            parent,
            false
        ) as ItemPaymentBinding

        return PaymentViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return listPayments.size
    }

    override fun onBindViewHolder(
        holder: PaymentsRecyclerViewAdapter.PaymentViewHolder,
        position: Int
    ) {
        return holder.bind(position, listPayments[position], onClickPayment)
    }

    fun setData(list: List<PaymentEntity>) {
        listPayments = list
        notifyDataSetChanged()
    }

    inner class PaymentViewHolder(private val binding: ItemPaymentBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(position: Int?, payment: PaymentEntity?, onClickPayment: ((Int?) -> (Unit))) {
            binding.payment = payment
        }
    }
}