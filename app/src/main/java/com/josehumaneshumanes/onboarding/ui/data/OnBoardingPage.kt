package com.josehumaneshumanes.onboarding.ui.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class OnBoardingPage(
    @StringRes val titleRedId: Int,
    @StringRes val descriptionResId: Int,
    @DrawableRes val imageResId: Int
)
