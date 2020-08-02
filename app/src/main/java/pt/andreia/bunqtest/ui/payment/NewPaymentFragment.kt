package pt.andreia.bunqtest.ui.payment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import pt.andreia.bunqtest.R
import pt.andreia.bunqtest.databinding.NewPaymentFragmentBinding
import pt.andreia.bunqtest.model.enums.StatusRequestPaymentEnum
import pt.andreia.bunqtest.utils.format.CurrencyUtils.validateCurrency

class NewPaymentFragment : Fragment() {

    private val viewModel: NewPaymentViewModel by lazy { ViewModelProvider(this).get(NewPaymentViewModel::class.java) }
    private lateinit var binding: NewPaymentFragmentBinding
    private lateinit var mContext: Context

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext = context
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(LayoutInflater.from(mContext), R.layout.new_payment_fragment, null, false)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        initListeners()

        return binding.root
    }

    private fun initListeners() {
        binding.buttonPayment.setOnClickListener {
            if (validateCurrency(viewModel.amount.value)) {
                viewModel.sendRequestPayment {success, statusEnum -> checkSuccess(success, statusEnum)}
            } else {
                Toast.makeText(mContext, resources.getString(R.string.error_invalid_amount), Toast.LENGTH_LONG).show()
            }
        }

    }

    private fun checkSuccess(success: Boolean, statusRequestPaymentEnum: StatusRequestPaymentEnum?) {
        val message = if (success) {
            when(statusRequestPaymentEnum) {
                StatusRequestPaymentEnum.ACCEPTED -> resources.getString(R.string.message_success_payment)
                StatusRequestPaymentEnum.REJECTED -> resources.getString(R.string.message_reject_payment)
                StatusRequestPaymentEnum.PENDING -> resources.getString(R.string.message_pending_payment)
                else -> resources.getString(R.string.error_request_payment)
            }
        } else {
            resources.getString(R.string.error_request_payment)
        }
        Toast.makeText(mContext, message, Toast.LENGTH_LONG).show()
        activity?.supportFragmentManager?.popBackStack()
    }

    companion object {
        val TAG: String = NewPaymentFragment::class.java.simpleName

        fun newInstance() = NewPaymentFragment()
    }

}