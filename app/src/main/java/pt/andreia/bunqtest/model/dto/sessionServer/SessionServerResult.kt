package pt.andreia.bunqtest.model.dto.sessionServer


import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class SessionServerResult(
    @Expose
    @SerializedName("Id")
    val idResult: Id? = null,
    @Expose
    @SerializedName("Token")
    val tokenResult: Token? = null,
    @Expose
    @SerializedName("UserPerson")
    val userPerson: UserPerson? = null
)