package com.example.coinsapplication.domain.model

import androidx.compose.ui.graphics.vector.ImageVector

data class BottomNavigationItem(
    val name: String,
    val route: String,
    val icon: ImageVector,
)
