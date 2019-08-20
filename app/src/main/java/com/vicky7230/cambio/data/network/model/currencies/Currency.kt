package com.vicky7230.cambio.data.network.model.currencies

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Currency (
    @SerializedName("currency")
    @Expose
    var currency: String? = null,
    @SerializedName("id")
    @Expose
    var id: String? = null,
    @SerializedName("price")
    @Expose
    var price: String? = null,
    @SerializedName("price_date")
    @Expose
    var priceDate: String? = null,
    @SerializedName("symbol")
    @Expose
    var symbol: String? = null,
    @SerializedName("circulating_supply")
    @Expose
    var circulatingSupply: String? = null,
    @SerializedName("max_supply")
    @Expose
    var maxSupply: String? = null,
    @SerializedName("name")
    @Expose
    var name: String? = null,
    @SerializedName("logo_url")
    @Expose
    var logoUrl: String? = null,
    @SerializedName("market_cap")
    @Expose
    var marketCap: String? = null,
    @SerializedName("rank")
    @Expose
    var rank: String? = null,
    @SerializedName("high")
    @Expose
    var high: String? = null,
    @SerializedName("high_timestamp")
    @Expose
    var highTimestamp: String? = null,
    @SerializedName("1d")
    @Expose
    var _1d: _1d? = null,
    @SerializedName("7d")
    @Expose
    var _7d: _7d? = null,
    @SerializedName("30d")
    @Expose
    var _30d: _30d? = null,
    @SerializedName("365d")
    @Expose
    var _365d: _365d? = null,
    @SerializedName("ytd")
    @Expose
    var ytd: Ytd? = null
)
