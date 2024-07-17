package com.example.dashboard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.dashboard.presentation.linkScreen.LinkScreen
import com.example.dashboard.presentation.components.Screen
import com.example.dashboard.ui.theme.DashboardTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.Scaffold
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.currentBackStackEntryAsState
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DashboardTheme {
                MyApp()
            }
        }
    }
}


@Composable
fun MyApp() {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = { BottomNavigationBar(navController) }
    ) { innerPadding ->
        NavHost(navController, startDestination = Screen.Links.route, Modifier.padding(innerPadding)) {
            composable(Screen.Links.route) { LinkScreen() }
            composable(Screen.Courses.route) { CoursesScreen() }
            composable(Screen.Add.route) { AddScreen() }
            composable(Screen.Campaigns.route) { CampaignsScreen() }
            composable(Screen.Profile.route) { ProfileScreen() }
        }
    }
}
@Composable
fun BottomNavigationBar(navController: NavHostController) {
    NavigationBar {
        NavigationBarItem(
            icon = { Icon(imageVector = ImageVector.vectorResource(id = R.drawable.link), contentDescription = "Links") },
            label = { Text("Links") },
            selected = navController.currentBackStackEntryAsState().value?.destination?.route == Screen.Links.route,
            onClick = { navController.navigate(Screen.Links.route) }
        )
        NavigationBarItem(
            icon = { Icon(imageVector = ImageVector.vectorResource(id = R.drawable.magazine),contentDescription = "Courses") },
            label = { Text("Courses") },
            selected = navController.currentBackStackEntryAsState().value?.destination?.route == Screen.Courses.route,
            onClick = { navController.navigate(Screen.Courses.route) }
        )
        NavigationBarItem(
            icon = { Icon(Icons.Filled.AddCircle, contentDescription = "Add", tint = MaterialTheme.colorScheme.primary) },
            label = { Text("Add") },
            selected = navController.currentBackStackEntryAsState().value?.destination?.route == Screen.Add.route,
            onClick = { navController.navigate(Screen.Add.route) }
        )
        NavigationBarItem(
            icon = { Icon(imageVector = ImageVector.vectorResource(id = R.drawable.fast_forward), contentDescription = "Campaigns")  },
            label = { Text("Campaigns") },
            selected = navController.currentBackStackEntryAsState().value?.destination?.route == Screen.Campaigns.route,
            onClick = { navController.navigate(Screen.Campaigns.route) }
        )
        NavigationBarItem(
            icon = { Icon(imageVector = ImageVector.vectorResource(id = R.drawable.user), contentDescription = "Profile") },
            label = { Text("Profile") },
            selected = navController.currentBackStackEntryAsState().value?.destination?.route == Screen.Profile.route,
            onClick = { navController.navigate(Screen.Profile.route) }
        )
    }
}

@Composable
fun ProfileScreen() {
    Text("Profile Screen")
}

@Composable
fun CampaignsScreen() {
    Text("Campaigns Screen")
}

@Composable
fun AddScreen() {
    Text("Add Screen")
}

@Composable
fun CoursesScreen() {
    Text("Courses Screen")
}

@Preview(showBackground = true)
@Composable
fun MyAppPreview() {
    DashboardTheme {
        MyApp()
    }
}
