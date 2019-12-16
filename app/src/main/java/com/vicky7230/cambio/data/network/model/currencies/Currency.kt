package com.vicky7230.cambio.data.network.model.currencies

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

@Entity(tableName = "currencies")
data class Currency(

    @PrimaryKey
    @SerializedName("id")
    @Expose
    @NonNull var id: String,

    @ColumnInfo(name = "currency")
    @SerializedName("currency")
    @Expose
    var currency: String? = null,

    @ColumnInfo(name = "price")
    @SerializedName("price")
    @Expose
    var price: String? = null,

    @ColumnInfo(name = "name")
    @SerializedName("name")
    @Expose
    var name: String? = null,

    @ColumnInfo(name = "logo_url")
    @SerializedName("logo_url")
    @Expose
    var logoUrl: String? = null
)
