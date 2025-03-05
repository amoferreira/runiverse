package com.amoferreira.runiverse

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.amoferreira.auth.presentation.intro.IntroScreenContainer
import com.amoferreira.auth.presentation.register.RegisterScreenContainer

@Composable
fun NavigationRoot(
    navController: NavHostController,
) {
    NavHost(
        navController = navController,
        startDestination = "auth",
    ) {
        authGraph(navController)
    }
}

private fun NavGraphBuilder.authGraph(navController: NavHostController) {
    navigation(
        startDestination = "intro",
        route = "auth"
    ) {
        composable(route = "intro") {
            IntroScreenContainer(
                onSignInClick = {
                    navController.navigate("login")
                },
                onSignUpClick = {
                    navController.navigate("register")
                },
            )
        }
        composable(route = "register") {
            RegisterScreenContainer(
                onSignInClick = {
                    navController.navigate("login") {
                        popUpTo(
                            route = "register"
                        ) {
                            inclusive = true
                            saveState = true
                        }
                        restoreState = true
                    }
                },
                onSuccessfulRegistration = {
                    navController.navigate("login")
                },
            )
        }
    }
}