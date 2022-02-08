package com.example.coinsapplication.prisentation

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.coinsapplication.R
import com.example.coinsapplication.domain.model.BottomNavigationItem
import com.example.coinsapplication.prisentation.TwitterScreen.component.TwitterScreen
import com.example.coinsapplication.prisentation.bottomNavigation.BottomNavigationSection
import com.example.coinsapplication.prisentation.coinDetailsScreen.component.CoinDetailsScreen
import com.example.coinsapplication.prisentation.coinsScreen.componnent.CoinsScreen
import com.example.coinsapplication.prisentation.notification.CreateNotificationScreen
import com.example.coinsapplication.prisentation.setting.CreateSettingScreen
import com.example.coinsapplication.prisentation.ui.theme.CoinsApplicationTheme
import com.example.coinsapplication.prisentation.ui.theme.Shapes
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MainPage()
        }
    }


}

@Composable
fun MainPage() {
    var isDark by remember {
        mutableStateOf(false)
    }
    val navController = rememberNavController()
    val mscaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()

    CoinsApplicationTheme(darkTheme = isDark) {
        // A surface container using the 'background' color from the theme
        Scaffold(
            scaffoldState = mscaffoldState,
            topBar = {
                TobBarSection(
                    navController = navController,
                    scaffoldState = mscaffoldState,
                    scope = scope,
                    isDark = isDark,
                    onChange = { value -> isDark = value }
                )
            },
            drawerContent = {
                DrawerNavigationCompose(
                    navController = navController,
                    scaffoldState = mscaffoldState,
                    scope = scope
                ) {
                    navController.navigate(it)
                }
            },
            drawerBackgroundColor = Color.LightGray,
            drawerContentColor = Color.White,
            drawerShape = RoundedCornerShape(bottomEnd = 50.dp),

            content = { ContentSection(navController, isDark) },

            bottomBar = { BottomNavigationBar(navController = navController) }
        )
    }

}

@Composable
fun BottomNavigationBar(navController: NavHostController) {

    val list = listOf<BottomNavigationItem>(
        BottomNavigationItem(
            "home",
            Screen.CoinsScreen.route,
            Icons.Default.Home
        ),
        BottomNavigationItem(
            "Notfication",
            Screen.CoinNotificationScreen.route,
            Icons.Default.Notifications
        ),
        BottomNavigationItem(
            "home",
            Screen.CoinSettingScreen.route,
            Icons.Default.Settings
        )
    )

    BottomNavigationSection(navController = navController, list = list) {

        navController.navigate(it.route)

//
//        when (it.route) {
//            Screen.CoinsScreen.route -> {
//                navController.navigate(Screen.CoinsScreen.route)
//            }
//
//        }

    }


}

@Composable
fun TobBarSection(
    navController: NavHostController,
    scaffoldState: ScaffoldState,
    scope: CoroutineScope,
    onChange: (Boolean) -> Unit,
    isDark: Boolean = false
) {
    val context = LocalContext.current
    val backStack = navController.currentBackStackEntryAsState().value?.destination
    TopAppBar(
        title = { Text(text = backStack?.route.toString()) },
        navigationIcon = {
            IconButton(onClick = {
                scope.launch {
                    scaffoldState.drawerState.open()

                }
            }) {
                Icon(Icons.Default.Menu, contentDescription = "Menu")

            }
        },
        actions = {
            Switch(checked = isDark, onCheckedChange = {
                onChange(it)
            })
        }
    )


}

@Composable
fun DrawerNavigationCompose(
    navController: NavHostController,
    scaffoldState: ScaffoldState,
    scope: CoroutineScope,
    onItemClick: (String) -> Unit
) {

    val list = listOf<BottomNavigationItem>(
        BottomNavigationItem(
            "home",
            Screen.CoinsScreen.route,
            Icons.Default.Home
        ),
        BottomNavigationItem(
            "Notfication",
            Screen.CoinNotificationScreen.route,
            Icons.Default.Notifications
        ),
        BottomNavigationItem(
            "home",
            Screen.CoinSettingScreen.route,
            Icons.Default.Settings
        )
    )

    val backStackEntry = navController.currentBackStackEntryAsState().value?.destination
    val currentRoute = backStackEntry?.route

    Column(Modifier.fillMaxSize()) {
        Row(Modifier.fillMaxWidth()) {
            Box(modifier = Modifier.weight(8f))
            Box(modifier = Modifier.weight(2f)) {
                IconButton(onClick = {
                    scope.launch {
                        scaffoldState.drawerState.close()
                    }
                }) {
                    Icon(Icons.Default.Close, contentDescription = "Close")
                }
            }
        }
        Column(modifier = Modifier.padding(20.dp)) {
            LazyColumn(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                items(list) { item ->
                    val isSelected = item.route == currentRoute
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 20.dp)
                            .clickable {
                                onItemClick(item.route)
                                scope.launch {
                                    scaffoldState.drawerState.close()
                                }
                            },


                        ) {
                        Icon(
                            item.icon,
                            contentDescription = item.name,
                            modifier = Modifier
                                .weight(2f)
                                .size(40.dp),
                            tint = if (isSelected) Color.Green else Color.White

                        )

                        Text(text = item.name, modifier = Modifier.weight(8f))
                    }
                    Divider()

                }

            }
        }
    }

}


@Composable
fun ContentSection(navController: NavHostController, isDark: Boolean = false) {
    Surface(color = MaterialTheme.colors.background) {

        NavHost(
            navController = navController,
            startDestination = Screen.CoinsScreen.route
        ) {

            composable(Screen.CoinsScreen.route) {
                CoinsScreen(navController = navController)
            }
            composable(Screen.CoinsDetailsScreen.route + "/{coinId}") {
                CoinDetailsScreen(navController = navController)
            }

            composable(Screen.CoinsTwitterScreen.route + "/{coinId}") {
                TwitterScreen(navController = navController)
            }

            composable(Screen.CoinSettingScreen.route) {
                CreateSettingScreen()
            }
            composable(Screen.CoinNotificationScreen.route) {
                CreateNotificationScreen()
            }


        }
    }
}