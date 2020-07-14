package pt.andreia.bunqtest.model.dto.payments

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName

data class BunqMe(
    @Expose
    @SerializedName("type")
    val type: String? = null,
    @Expose
    @SerializedName("name")
    val name: String? = null,
    @Expose
    @SerializedName("value")
    val email: String? = null
)