package com.josehumaneshumanes.onboarding.ui.screen.onboarding

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.josehumaneshumanes.onboarding.ui.data.OnBoardingPage
import com.josehumaneshumanes.onboarding.ui.data.onBoardingPages
import com.josehumaneshumanes.onboarding.ui.theme.Typography
import com.josehumaneshumanes.onboarding.ui.theme.bestFiendsSpacing
import com.josehumaneshumanes.onboarding.ui.theme.closeFriendsSpacing
import com.josehumaneshumanes.onboarding.ui.theme.imageSize

@Composable
fun Page(page: OnBoardingPage) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Image(
            painter = painterResource(id = page.imageResId),
            contentDescription = null,
            modifier = Modifier.size(imageSize)
        )
        Spacer(modifier = Modifier.height(closeFriendsSpacing))

        Text(
            text = stringResource(id = page.titleRedId),
            fontWeight = FontWeight.Bold,
            style = Typography.h1
        )
        Spacer(modifier = Modifier.height(bestFiendsSpacing))

        Text(
            text = stringResource(id = page.descriptionResId),
            textAlign = TextAlign.Center,
            style = Typography.body1
        )
//        Spacer(modifier = Modifier.height(friendsSpacing))
    }
}

@Composable
@Preview
fun PagePreview() {
    Page(onBoardingPages[0])
}
