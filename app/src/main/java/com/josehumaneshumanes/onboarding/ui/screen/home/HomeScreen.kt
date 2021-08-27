package com.josehumaneshumanes.onboarding.ui.screen.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.josehumaneshumanes.onboarding.R
import com.josehumaneshumanes.onboarding.ui.theme.Typography
import com.josehumaneshumanes.onboarding.ui.theme.friendsSpacing

@Composable
fun HomeScreen() {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(all = friendsSpacing)
    ) {
        Text(text = stringResource(id = R.string.home_message), style = Typography.h1)
    }
}

@Composable
@Preview
fun HomeScreenPreview() {
    HomeScreen()
}
