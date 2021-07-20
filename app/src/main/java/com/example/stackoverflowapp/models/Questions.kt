package com.example.stackoverflowapp.models

import com.example.stackoverflowapp.models.Item
import com.google.gson.annotations.SerializedName

data class Questions(
    @SerializedName("has_more") val hasMore: Boolean,
    val items: List<Item>,
    @SerializedName("quota_max") val quotaMax: Int,
    @SerializedName("quota_remaining") val quotaRemaining: Int
)