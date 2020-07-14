package pt.andreia.bunqtest.ui.main

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import pt.andreia.bunqtest.R
import pt.andreia.bunqtest.databinding.MainFragmentBinding
import pt.andreia.bunqtest.model.interfaces.ActivityCallback
import pt.andreia.bunqtest.ui.adapter.PaymentsRecyclerViewAdapter

class MainFragment : Fragment() {

    private val viewModel by lazy { ViewModelProvider(this).get(MainFragmentViewModel::class.java) }
    private lateinit var mContext: Context
    private var mCallback: ActivityCallback? = null
    private lateinit var binding: MainFragmentBinding

    companion object {
        val TAG = MainFragment::class.java.simpleName
        fun newInstance() = MainFragment()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext = context
        mCallback = context as? ActivityCallback
    }

    override fun onResume() {
        super.onResume()
        if (viewModel.user.value != null) {
            viewModel.showLoading()
            viewModel.getUserPayments()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.main_fragment, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel

        val layoutManager = LinearLayoutManager(mContext)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        binding.layoutManager = layoutManager
        binding.adapter = PaymentsRecyclerViewAdapter(mContext, emptyList()) { paymentId -> onClickPayment(paymentId)}

        viewModel.showLoading()
        initObservers()
        initListeners()

        return binding.root
    }

    private fun onClickPayment(id: Int?) {}

    private fun initListeners() {
        binding.buttonPayment.setOnClickListener {
            mCallback?.openNewPaymentFragment()
        }

        binding.swipeRefreshLayout = SwipeRefreshLayout.OnRefreshListener {
            viewModel.getUserPayments()
        }
    }

    private fun initObservers() {
        viewModel.failInit.observe(viewLifecycleOwner, Observer {
            if (it != null) {
                if (it) {
                    mCallback?.blockApp()
                } else {
                    viewModel.getUserPayments()
                }
            }
        })

        viewModel.listPayments.observe(viewLifecycleOwner, Observer { listPayments ->
            if (listPayments != null) {
                binding.adapter?.setData(listPayments)
                viewModel.hideLoading()
            }
        })

        viewModel.errors.observe(viewLifecycleOwner, Observer {message ->
            message?.run {
                viewModel.hideLoading()
                Toast.makeText(mContext, this, Toast.LENGTH_LONG).show()
        }
        })
    }

}