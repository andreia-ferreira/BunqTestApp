package pt.andreia.bunqtest.ui.payment

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import pt.andreia.bunqtest.R
import pt.andreia.bunqtest.databinding.NewPaymentDialogFragmentBinding
import pt.andreia.bunqtest.model.UserEntity

class NewPaymentFragment : Fragment() {

    private val viewModel: NewPaymentViewModel by lazy { ViewModelProvider(this).get(NewPaymentViewModel::class.java) }
    private lateinit var binding: NewPaymentDialogFragmentBinding
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

        binding = DataBindingUtil.inflate(LayoutInflater.from(mContext), R.layout.new_payment_dialog_fragment, null, false)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        initListeners()

        return binding.root
    }

    private fun initListeners() {
        binding.buttonPayment.setOnClickListener {
            viewModel.sendRequestPayment {success -> checkSuccess(success)}
        }
    }

    private fun checkSuccess(success: Boolean) {
        if (success) {
            Toast.makeText(mContext, resources.getString(R.string.message_success_payment), Toast.LENGTH_LONG).show()

        } else {
            Toast.makeText(mContext, resources.getString(R.string.error_request_payment), Toast.LENGTH_LONG).show()
        }
        activity?.supportFragmentManager?.popBackStack()
    }

    companion object {
        val TAG: String = NewPaymentFragment::class.java.simpleName

        fun newInstance() = NewPaymentFragment()
    }

}