package pt.andreia.bunqtest.model.dto.user


import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class UserInfoResult(
    @Expose
    @SerializedName("UserPerson")
    val userPerson: UserPerson? = null
)