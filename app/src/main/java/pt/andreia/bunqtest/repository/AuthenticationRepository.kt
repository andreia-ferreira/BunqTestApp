package pt.andreia.bunqtest.repository

import android.app.Application
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.gson.Gson
import pt.andreia.bunqtest.BuildConfig
import pt.andreia.bunqtest.model.dto.deviceServer.DeviceServerInput
import pt.andreia.bunqtest.model.dto.installation.InstallationInput
import pt.andreia.bunqtest.model.dto.installation.InstallationResponse
import pt.andreia.bunqtest.model.dto.installation.InstallationResult
import pt.andreia.bunqtest.model.dto.sessionServer.SessionServerInput
import pt.andreia.bunqtest.network.ApiClient
import pt.andreia.bunqtest.utils.SecurityUtils
import pt.andreia.bunqtest.utils.SecurityUtils.keyPair
import retrofit2.Response

class AuthenticationRepository(private val mApplication: Application,
                               private val api: ApiClient) {

    suspend fun createInstallation(): Boolean {
        var success = false
        val installationInput = InstallationInput(SecurityUtils.getPublicKeyPKCS8(keyPair))
        val response = api.getInstallationClient().createInstallation(installationInput)
        if (response.isSuccessful) {
            response.body()?.response?.get(InstallationResult.POSITION_TOKEN)?.token?.let {
                val tokenString = it.token
                if (!tokenString.isNullOrEmpty()) {
                    api.token = tokenString
                    api.signature = SecurityUtils.getPublicKeyString(keyPair)
                    success = true
                }
            }
        } else {
            Log.d(TAG, response.body()?.error?.get(0)?.errorDescriptionTranslated ?: "Error in installation.")
        }
        return success
    }

    suspend fun registerDevice(): Boolean {
        var success = false
        val deviceServerInput = DeviceServerInput("android", listOf("*"), BuildConfig.API_KEY)

        val response = api.getApiClient().registerDevice(deviceServerInput)
        if (response.isSuccessful) {
            response.body()?.response?.get(0)?.idResult?.id?.let {
                success = true
            }
        } else {
            Log.d(TAG, response.body()?.error?.get(0)?.errorDescriptionTranslated ?: "Error in device-server.")
        }
        return success
    }

    suspend fun initSession(): Boolean {
        var success = false
        val sessionServerInput = SessionServerInput(BuildConfig.API_KEY)
        val jsonString = Gson().toJson(sessionServerInput)
        val signedSessionServerInput = SecurityUtils.signDataWithPrivateKey(jsonString, keyPair)
        api.signature = signedSessionServerInput ?: ""

        val response = api.getApiClient().initSession(sessionServerInput)
        if (response.isSuccessful) {
            response.body()?.sessionServerResult?.get(1)?.tokenResult?.token?.let {
                api.token = it
                api.signature = SecurityUtils.getPublicKeyString(keyPair)
                success = true
            }
        } else {
            Log.d(TAG, response.body()?.error?.get(0)?.errorDescriptionTranslated ?: "Error in session-server.")
        }
        return success
    }

    companion object {
        private val TAG = AuthenticationRepository::class.java.simpleName

        // For Singleton instantiation
        @Volatile
        private var instance: AuthenticationRepository? = null

        fun getInstance(application: Application, apiClient: ApiClient) =
            instance ?: synchronized(this) {
                instance ?: AuthenticationRepository(application, apiClient).also {
                    instance = it
                }
            }
    }

}