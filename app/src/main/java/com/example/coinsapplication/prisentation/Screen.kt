package com.example.coinsapplication.prisentation

sealed class Screen(val route: String) {

    object CoinsScreen : Screen("coins_screen")
    object CoinsDetailsScreen : Screen("coins_details_screen")
    object CoinsTwitterScreen : Screen("coins_twitter_screen")
    object CoinSettingScreen : Screen("coin_setting_screen")
    object CoinNotificationScreen : Screen("coin_notification_screen")

}
