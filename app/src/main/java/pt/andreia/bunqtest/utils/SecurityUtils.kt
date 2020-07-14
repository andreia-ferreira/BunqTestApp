package pt.andreia.bunqtest.utils

import android.util.Base64
import android.util.Log
import java.io.ByteArrayOutputStream
import java.io.ObjectOutputStream
import java.lang.Exception
import java.security.GeneralSecurityException
import java.security.KeyPair
import java.security.KeyPairGenerator
import java.security.Signature

object SecurityUtils {

    private val TAG = SecurityUtils::class.java.simpleName
    private const val KEY_PAIR_GENERATOR_ALGORITHM = "RSA"
    private const val SIGNATURE_ALGORITHM = "SHA256withRSA"
    private const val KEY_PAIR_GENERATOR_KEY_SIZE = 2048

    private const val PUBLIC_KEY_START = "-----BEGIN PUBLIC KEY-----\n"
    private const val PUBLIC_KEY_END = "-----END PUBLIC KEY-----\n"

    val keyPair = generateKeys()

    private fun generateKeys(): KeyPair? {
        var keyPair: KeyPair? = null
        try {
            val keyGen: KeyPairGenerator = KeyPairGenerator.getInstance(KEY_PAIR_GENERATOR_ALGORITHM)
            keyGen.initialize(KEY_PAIR_GENERATOR_KEY_SIZE)
            keyPair = keyGen.generateKeyPair()
        } catch (e: GeneralSecurityException) {
            println(e)
        }
        return keyPair
    }

    fun getPublicKeyPKCS8(keyPair: KeyPair?): String {
        var formattedString = ""
        val encodedPublicKey = keyPair?.public?.encoded
        if (encodedPublicKey != null) {
            val publicKeyString: String = Base64.encodeToString(encodedPublicKey, Base64.DEFAULT)
            formattedString = "$PUBLIC_KEY_START$publicKeyString$PUBLIC_KEY_END"
        }
        return formattedString
    }

    fun getPublicKeyString(keyPair: KeyPair?): String {
        var formattedString = ""
        val encodedPublicKey = keyPair?.public?.encoded
        if (encodedPublicKey != null) {
            formattedString = Base64.encodeToString(encodedPublicKey, Base64.NO_WRAP)
        }
        return formattedString
    }

    fun signDataWithPrivateKey(data: String, keyPair: KeyPair?): String? {
        var encrypted = ""
        try {
            val dataByteArray = data.toByteArray()

            val signature: ByteArray? = Signature.getInstance(SIGNATURE_ALGORITHM).run {
                initSign(keyPair?.private)
                update(dataByteArray)
                sign()
            }
            if (signature != null) {
                encrypted = Base64.encodeToString(signature, Base64.NO_WRAP)
            }
        } catch (e: Exception) {
            Log.e(TAG, e.message.toString())
        }
        return encrypted
    }

}