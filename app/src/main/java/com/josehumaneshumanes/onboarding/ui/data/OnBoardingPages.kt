package com.josehumaneshumanes.onboarding.ui.data

import com.josehumaneshumanes.onboarding.R

val onBoardingPages = listOf<OnBoardingPage>(
    OnBoardingPage(
        titleRedId = R.string.planning_title,
        descriptionResId = R.string.planning_description,
        imageResId = R.drawable.planning
    ),
    OnBoardingPage(
        titleRedId = R.string.communication_title,
        descriptionResId = R.string.communication_description,
        imageResId = R.drawable.communication
    ),
    OnBoardingPage(
        titleRedId = R.string.team_title,
        descriptionResId = R.string.team_description,
        imageResId = R.drawable.team
    ),
)
