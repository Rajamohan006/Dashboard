package com.example.dashboard.presentation.components

sealed class Screen(val route: String) {
    object Links : Screen("links")
    object Courses : Screen("courses")
    object Add : Screen("add")
    object Campaigns : Screen("campaigns")
    object Profile : Screen("profile")
}
