package com.josehumaneshumanes.onboarding

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.*
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.google.accompanist.pager.ExperimentalPagerApi
import com.josehumaneshumanes.onboarding.ui.navigation.Screen
import com.josehumaneshumanes.onboarding.ui.screen.home.HomeScreen
import com.josehumaneshumanes.onboarding.ui.screen.onboarding.OnBoardingScreen
import com.josehumaneshumanes.onboarding.ui.theme.OnboardingTheme

class MainActivity : ComponentActivity() {
    @ExperimentalPagerApi
    @ExperimentalAnimationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            OnboardingTheme {
                BoxWithConstraints {
                    val navController = rememberAnimatedNavController()
                    AnimatedNavHost(
                        navController = navController,
                        startDestination = Screen.OnBoarding.route,
                        builder = {
                            addOnBoarding(
                                navController = navController,
                                width = constraints.maxWidth / 2
                            )
                            addHome(width = constraints.maxWidth / 2)
                        }
                    )
                }
            }
        }
    }
}

@ExperimentalPagerApi
@ExperimentalAnimationApi
fun NavGraphBuilder.addOnBoarding(navController: NavController, width: Int) {
    composable(
        route = Screen.OnBoarding.route,
        exitTransition = { _, _ ->
            slideOutHorizontally(
                targetOffsetX = { -width },
                animationSpec = tween(
                    durationMillis = 300,
                    easing = FastOutSlowInEasing
                )
            ) + fadeOut(animationSpec = tween(300))
        },
        popEnterTransition = { _, _ ->
            slideInHorizontally(
                initialOffsetX = { -width },
                animationSpec = tween(
                    durationMillis = 300,
                    easing = FastOutSlowInEasing
                )
            ) + fadeIn(animationSpec = tween(300))
        },
    ) {
        OnBoardingScreen({
            navController.navigate(Screen.Home.route)
        }, {
            navController.navigate(Screen.Home.route)
        })
    }
}

@ExperimentalAnimationApi
fun NavGraphBuilder.addHome(width: Int) {
    composable(
        route = Screen.Home.route,
        enterTransition = { _, _ ->
            slideInHorizontally(
                initialOffsetX = { width },
                animationSpec = tween(
                    durationMillis = 300,
                    easing = FastOutSlowInEasing
                )
            ) + fadeIn(animationSpec = tween(300))
        },
        popExitTransition = { _, _ ->
            slideOutHorizontally(
                targetOffsetX = { width },
                animationSpec = tween(
                    durationMillis = 300,
                    easing = FastOutSlowInEasing
                )
            ) + fadeOut(animationSpec = tween(300))
        }
    ) {
        HomeScreen()
    }
}

@ExperimentalPagerApi
@ExperimentalAnimationApi
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    OnboardingTheme {
        OnBoardingScreen(onGettingStartedClicked = {}, onSkipClicked = {})
    }
}