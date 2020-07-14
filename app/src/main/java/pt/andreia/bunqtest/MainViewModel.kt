package pt.andreia.bunqtest

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import pt.andreia.bunqtest.network.ApiClient
import pt.andreia.bunqtest.repository.AuthenticationRepository
import java.lang.Exception

class MainViewModel(private val mApplication: Application): AndroidViewModel(mApplication) {

    private val _authenticateSuccess = MutableLiveData(false)
    val authenticateSuccess: LiveData<Boolean> = _authenticateSuccess

    private val repository: AuthenticationRepository by lazy {
        AuthenticationRepository.getInstance(mApplication, ApiClient)
    }

    fun authenticate() {
        viewModelScope.launch {
            try {
                val installationSuccess = async { repository.createInstallation() }
                if (installationSuccess.await()) {
                    val successDevice = async { repository.registerDevice() }
                    if (successDevice.await()) {
                        repository.initSession()
                        _authenticateSuccess.value = true
                    }
                }
                throw Exception("Error in authentication")
            } catch (e: Exception) {
                Log.e(TAG, e.message ?: "Error in authentication")
                _authenticateSuccess.value = false
            }
        }
    }

    companion object {
        val TAG = MainViewModel::class.java.simpleName
    }

}