package pt.andreia.bunqtest.model.dto.user


import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Avatar(
    @Expose
    @SerializedName("anchor_uuid")
    val anchorUuid: String? = null,
    @Expose
    @SerializedName("image")
    val image: List<Image>? = null,
    @Expose
    @SerializedName("uuid")
    val uuid: String? = null
)