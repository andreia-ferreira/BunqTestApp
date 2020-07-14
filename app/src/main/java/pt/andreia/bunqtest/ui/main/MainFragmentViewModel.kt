package pt.andreia.bunqtest.ui.main

import android.app.Application
import androidx.lifecycle.*
import kotlinx.coroutines.launch
import pt.andreia.bunqtest.model.PaymentEntity
import pt.andreia.bunqtest.model.UserEntity
import pt.andreia.bunqtest.network.ApiClient
import pt.andreia.bunqtest.repository.AuthenticationRepository
import pt.andreia.bunqtest.repository.UserRepository
import java.lang.Exception

class MainFragmentViewModel(private val mApplication: Application): AndroidViewModel(mApplication) {

    private val repository: UserRepository by lazy { UserRepository.getInstance(mApplication, ApiClient) }

    val isLoading = MutableLiveData(false)
    fun showLoading() { isLoading.value = true }
    fun hideLoading() { isLoading.value = false }

    val user: LiveData<UserEntity> = repository.user
    val listPayments: LiveData<List<PaymentEntity>> = repository.listPayments
    val errors: LiveData<String> = repository.reposErrors

    private val _failInit: MutableLiveData<Boolean> = MutableLiveData()
    val failInit: LiveData<Boolean> = _failInit

    init {
        getUserInfo()
    }

    private fun getUserInfo() {
        viewModelScope.launch {
            _failInit.value = !repository.getUserInfo()
        }
    }

    fun getUserPayments() {
        viewModelScope.launch {
            repository.getUserPayments()
        }
    }

}