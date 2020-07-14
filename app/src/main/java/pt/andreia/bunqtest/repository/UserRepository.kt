package pt.andreia.bunqtest.repository

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import pt.andreia.bunqtest.R
import pt.andreia.bunqtest.model.PaymentEntity
import pt.andreia.bunqtest.model.UserEntity
import pt.andreia.bunqtest.model.dto.payments.NewRequestInquiry
import pt.andreia.bunqtest.model.enums.StatusRequestPaymentEnum
import pt.andreia.bunqtest.network.ApiClient
import pt.andreia.bunqtest.utils.mapping.PaymentMapper
import pt.andreia.bunqtest.utils.mapping.UserMapper

class UserRepository(private val mApplication: Application,
                     private val api: ApiClient) {

    private val _reposErrors = MutableLiveData<String>()
    val reposErrors: LiveData<String> = _reposErrors

    private val _user = MutableLiveData<UserEntity>()
    val user: LiveData<UserEntity> = _user

    private val _listPayments = MutableLiveData<List<PaymentEntity>>()
    val listPayments: LiveData<List<PaymentEntity>> = _listPayments

    suspend fun getUserInfo(): Boolean {
        var success = false
        val response = api.getApiClient().getUserInfo()
        if (response.isSuccessful) {
            response.body()?.userInfoResult?.get(0)?.userPerson?.let {
                _user.value = UserMapper.mapUser(it)
                success = true
            }
        } else {
            _reposErrors.value = response.body()?.error?.get(0)?.errorDescriptionTranslated ?: mApplication.getString(R.string.error_user_info)
        }
        return success
    }

    suspend fun getUserPayments() {
        val userId = _user.value?.userId
        val monetaryId = user.value?.billingAccountId
        val response = api.getApiClient().getUserPayments(userId, monetaryId)
        if (response.isSuccessful) {
            response.body()?.paymentsResult?.let {
                _listPayments.value = PaymentMapper.mapListPayment(it)
            }
        } else {
            _reposErrors.value = response.body()?.error?.get(0)?.errorDescriptionTranslated ?: mApplication.getString(R.string.error_get_payments)
        }
    }

    suspend fun requestNewPayment(input: NewRequestInquiry): Int? {
        var idRequest: Int? = null
        val userId = _user.value?.userId
        val monetaryId = user.value?.billingAccountId

        val response = api.getApiClient().requestNewPayment(userId, monetaryId, input)
        if (response.isSuccessful) {
            response.body()?.response?.get(0)?.idResult?.id?.let {
                idRequest = it
            }
        } else {
            _reposErrors.value = response.body()?.error?.get(0)?.errorDescriptionTranslated ?: mApplication.getString(R.string.error_request_payment)
        }
        return idRequest
    }

    suspend fun checkPayment(id: Int): StatusRequestPaymentEnum? {
        val userId = _user.value?.userId
        val monetaryId = user.value?.billingAccountId

        val response = api.getApiClient().checkPaymentStatus(userId, monetaryId, id)
        if (response.isSuccessful) {
            response.body()?.response?.get(0)?.requestInquiry?.status?.let {
                if (it == StatusRequestPaymentEnum.ACCEPTED.name) {
                    return StatusRequestPaymentEnum.ACCEPTED
                } else {
                    return StatusRequestPaymentEnum.REJECTED
                }
            }
        } else {
            _reposErrors.value = response.body()?.error?.get(0)?.errorDescriptionTranslated ?: mApplication.getString(R.string.error_request_payment)
        }
        return null
    }

    companion object {
        private val TAG = UserRepository::class.java.simpleName

        // For Singleton instantiation
        @Volatile
        private var instance: UserRepository? = null

        fun getInstance(application: Application, apiClient: ApiClient) =
            instance ?: synchronized(this) {
                instance ?: UserRepository(application, apiClient).also {
                    instance = it
                }
            }
    }
}