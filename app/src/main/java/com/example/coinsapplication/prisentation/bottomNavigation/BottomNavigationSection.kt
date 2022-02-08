package com.example.coinsapplication.prisentation.bottomNavigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.coinsapplication.domain.model.BottomNavigationItem

@Composable
fun BottomNavigationSection(
    navController: NavController,
    list: List<BottomNavigationItem>,
    onItemClick: (BottomNavigationItem) -> Unit
) {

    val backStackEntry = navController.currentBackStackEntryAsState()
    BottomNavigation(
        Modifier.background(color = Color.DarkGray),
        elevation = 5.dp
    ) {

        list.forEach {

            val isSelected = it.route == backStackEntry.value?.destination?.route

            BottomNavigationItem(
                selected = isSelected,
                onClick = { onItemClick(it) },
                icon = {
                    Icon(
                        imageVector = it.icon,
                        contentDescription = it.name,
                        tint = if (isSelected) Color.Green else Color.LightGray,
                        modifier = if (isSelected) Modifier.scale(1.5f) else Modifier.scale(1.2f)

                    )
                }
            )
        }
    }

}


