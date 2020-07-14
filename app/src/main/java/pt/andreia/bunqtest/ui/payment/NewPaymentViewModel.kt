package pt.andreia.bunqtest.ui.payment

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import pt.andreia.bunqtest.model.dto.payments.*
import pt.andreia.bunqtest.model.enums.StatusRequestPaymentEnum
import pt.andreia.bunqtest.network.ApiClient
import pt.andreia.bunqtest.repository.UserRepository

class NewPaymentViewModel(private val mApplication: Application) : AndroidViewModel(mApplication) {

    private val repository: UserRepository by lazy { UserRepository.getInstance(mApplication, ApiClient) }

    val name = MutableLiveData("Sugar Daddy")
    val email = MutableLiveData("sugardaddy@bunq.com")
    val amount = MutableLiveData("100.0")
    val description = MutableLiveData("")

    fun sendRequestPayment(onSuccessCallback: ((Boolean, StatusRequestPaymentEnum?) -> (Unit))) {
        val input = NewRequestInquiry(allowBunqme = false,
            amountInquired = AmountInquired("EUR", amount.value),
            counterpartyAlias = CounterpartyAliasRequest(name.value, "EMAIL", email.value),
            description = description.value)

        viewModelScope.launch {
            val id = repository.requestNewPayment(input)
            if(id != null) {
                repository.checkPayment(id)?.let {
                    onSuccessCallback(true, it)
                }
            } else {
                onSuccessCallback.invoke(false, null)
            }
        }

    }

}