package com.josehumaneshumanes.onboarding.ui.screen.onboarding

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.HorizontalPagerIndicator
import com.google.accompanist.pager.rememberPagerState
import com.josehumaneshumanes.onboarding.R
import com.josehumaneshumanes.onboarding.ui.data.onBoardingPages
import com.josehumaneshumanes.onboarding.ui.theme.*

@ExperimentalAnimationApi
@ExperimentalPagerApi
@Composable
fun OnBoardingScreen(
    onGettingStartedClicked: () -> Unit,
    onSkipClicked: () -> Unit
) {
    val pagerState = rememberPagerState(pageCount = onBoardingPages.size)

    Column(
        Modifier.padding(friendsSpacing)
    ) {
        Text(
            text = stringResource(id = R.string.skip),
            textAlign = TextAlign.End,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bestFiendsSpacing)
                .clickable { onSkipClicked() }
        )

        HorizontalPager(
            state = pagerState,
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        ) { pageIndex ->
            Page(page = onBoardingPages[pageIndex])
        }

        HorizontalPagerIndicator(
            pagerState = pagerState,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(closeFriendsSpacing),
            activeColor = AccentColor
        )

        AnimatedVisibility(visible = pagerState.currentPage == (onBoardingPages.size - 1)) {
            OutlinedButton(
                shape = Shapes.medium,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bestFiendsSpacing),
                onClick = onGettingStartedClicked,
                colors = ButtonDefaults.outlinedButtonColors(
                    backgroundColor = SecondaryColor,
                    contentColor = Color.White
                )
            ) {
                Text(text = stringResource(R.string.get_started))
            }
        }
    }
}

@ExperimentalPagerApi
@ExperimentalAnimationApi
@Composable
@Preview
fun OnBoardingScreenPreview() {
    OnBoardingScreen(onGettingStartedClicked = {}, onSkipClicked = {})
}
