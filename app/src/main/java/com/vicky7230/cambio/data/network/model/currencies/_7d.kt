package com.vicky7230.cambio.data.network.model.currencies

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class _7d (
    @SerializedName("price_change")
    @Expose
    var priceChange: String? = null,
    @SerializedName("price_change_pct")
    @Expose
    var priceChangePct: String? = null,
    @SerializedName("volume")
    @Expose
    var volume: String? = null,
    @SerializedName("volume_change")
    @Expose
    var volumeChange: String? = null,
    @SerializedName("volume_change_pct")
    @Expose
    var volumeChangePct: String? = null,
    @SerializedName("market_cap_change")
    @Expose
    var marketCapChange: String? = null,
    @SerializedName("market_cap_change_pct")
    @Expose
    var marketCapChangePct: String? = null,
    @SerializedName("volume_transparency_grade")
    @Expose
    var volumeTransparencyGrade: String? = null
)
