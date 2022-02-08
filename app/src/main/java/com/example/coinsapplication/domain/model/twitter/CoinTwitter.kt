package com.example.coinsapplication.domain.model.twitter

data class CoinTwitter(
    val date: String,
    val isRetweet: Boolean,
    val likeCount: Int,
    val retweetCount: Int,
    val status: String,
    val statusId: String,
    val statusLink: String,
    val userImageLink: String,
    val userName: String
)