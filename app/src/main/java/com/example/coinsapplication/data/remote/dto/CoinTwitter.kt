package com.example.coinsapplication.data.remote.dto

import com.example.coinsapplication.domain.model.twitter.CoinTwitter
import com.google.gson.annotations.SerializedName


data class CoinTwitterDto(
    val date: String,
    @SerializedName("is_retweet")
    val isRetweet: Boolean,
    @SerializedName("like_count")
    val likeCount: Int,
    @SerializedName("retweet_count")
    val retweetCount: Int,
    val status: String,
    @SerializedName("status_id")
    val statusId: String,
    @SerializedName("status_link")
    val statusLink: String,
    @SerializedName("user_image_link")
    val userImageLink: String,
    @SerializedName("user_name")
    val userName: String
)

fun CoinTwitterDto.toCoinTwitter(): CoinTwitter {
    return CoinTwitter(
        date = date,
        isRetweet = isRetweet,
        likeCount = likeCount,
        retweetCount = retweetCount,
        status = status,
        statusId = statusId,
        statusLink = statusLink,
        userImageLink = userImageLink,
        userName = userName
    )
}