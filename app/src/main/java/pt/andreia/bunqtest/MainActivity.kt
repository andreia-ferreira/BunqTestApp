package pt.andreia.bunqtest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import pt.andreia.bunqtest.model.enums.ScreenControlEnum
import pt.andreia.bunqtest.model.interfaces.ActivityCallback
import pt.andreia.bunqtest.ui.main.MainFragment
import pt.andreia.bunqtest.ui.payment.NewPaymentFragment

class MainActivity : AppCompatActivity(), ActivityCallback {

    private val viewModel by lazy { ViewModelProvider(this).get(MainViewModel::class.java) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        findViewById<TextView>(R.id.errorTextView).visibility = View.GONE

        if (savedInstanceState == null) {
            initObservers()
            viewModel.authenticate()
        }
    }

    private fun initObservers() {
        viewModel.authenticateSuccess.observe(this, Observer {
            if (it != null && it == true) {
                if (it) {
                    switchFragment(ScreenControlEnum.MAIN_FRAGMENT, false, null)
                } else {
                    blockApp()
                }

            }
        })

    }

    private fun switchFragment(fragmentEnum: ScreenControlEnum, addToBackStack: Boolean, bundle: Bundle?) {
        val manager: FragmentManager = this.supportFragmentManager
        val fragment: Fragment
        val fragmentName: String

        when (fragmentEnum) {
            ScreenControlEnum.MAIN_FRAGMENT -> {
                fragment = MainFragment.newInstance()
                fragmentName = MainFragment.TAG
            }
            ScreenControlEnum.NEW_PAYMENT_FRAGMENT -> {
                fragment = NewPaymentFragment.newInstance()
                fragmentName = NewPaymentFragment.TAG
                fragment.arguments = bundle
            } else -> {
            fragment = MainFragment.newInstance()
            fragmentName = MainFragment.TAG
            fragment.arguments = bundle
        }
        }

        if (!addToBackStack) {
            for (i in 0 until manager.backStackEntryCount) {
                manager.popBackStack()
            }
            manager.beginTransaction()
                .replace(R.id.container, fragment)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .commit()
        } else {
            manager.beginTransaction()
                .replace(R.id.container, fragment)
                .addToBackStack(fragmentName)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .commit()
        }

    }

    override fun openNewPaymentFragment() {
        switchFragment(ScreenControlEnum.NEW_PAYMENT_FRAGMENT, true, null)
    }

    override fun blockApp() {
        findViewById<TextView>(R.id.errorTextView).visibility = View.VISIBLE
    }

}