package com.gbl.neuro.Screens

sealed class Screen(val route: String){
    object MainScreen : Screen("main_screen")
    object DetailScreen : Screen("detail_screen")
    object MeasurementScreen : Screen("measurement_screen")

    fun withArgs(vararg args: String): String {
        return buildString {
            append(route)
            args.forEach { arg ->
                append("/$arg")
            }
        }
    }
}