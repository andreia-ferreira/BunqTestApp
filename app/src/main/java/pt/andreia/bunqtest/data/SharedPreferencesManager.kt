package pt.andreia.bunqtest.data

import android.content.Context
import android.content.SharedPreferences

class SharedPreferencesManager(private val context: Context) {
    private var prefsToken: SharedPreferences = context.getSharedPreferences(KEY_TOKEN, Context.MODE_PRIVATE)

    fun saveTokenToPreferences(token: String?) {
        val editor = prefsToken.edit()
        editor.putString(KEY_TOKEN, token)
        editor.apply()
    }

    fun getTokenFromSharedPreferences(): String? {
        return prefsToken.getString(KEY_TOKEN, "")
    }

    companion object {
        val TAG = SharedPreferencesManager::class.java.simpleName
        private const val KEY_TOKEN = "TOKEN"

        @Volatile
        private var instance: SharedPreferencesManager? = null

        fun getInstance(context: Context): SharedPreferencesManager {
            return instance ?: synchronized(this) {
                SharedPreferencesManager(context).also { instance = it }
            }
        }
    }
}