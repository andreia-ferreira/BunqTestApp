package pt.andreia.bunqtest.model.dto.sessionServer


import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Image(
    @Expose
    @SerializedName("attachment_public_uuid")
    val attachmentPublicUuid: String? = null,
    @Expose
    @SerializedName("content_type")
    val contentType: String? = null,
    @Expose
    @SerializedName("height")
    val height: Int? = null,
    @Expose
    @SerializedName("width")
    val width: Int? = null
)