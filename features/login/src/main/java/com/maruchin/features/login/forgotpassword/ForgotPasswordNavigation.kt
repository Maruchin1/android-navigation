package com.maruchin.features.login.forgotpassword

import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navDeepLink
import com.maruchin.ui.openEmailApp

internal const val FORGOT_PASSWORD_ROUTE = "forgot_password"
private const val FORGOT_PASSWORD_DEEPLINK = "${com.maruchin.ui.ROOT_DEEPLINK}/forgot-password"

internal fun NavController.navigateToForgotPassword() {
    navigate(FORGOT_PASSWORD_ROUTE)
}

internal fun NavGraphBuilder.forgotPasswordScreen(onBackClick: () -> Unit) {
    composable(
        route = FORGOT_PASSWORD_ROUTE,
        deepLinks = listOf(
            navDeepLink { uriPattern = FORGOT_PASSWORD_DEEPLINK }
        )
    ) {
        val viewModel: ForgotPasswordViewModel = hiltViewModel()
        val context = LocalContext.current

        ForgotPasswordScreen(
            emailSent = viewModel.emailSent,
            onBackClick = onBackClick,
            onSendLinkClick = viewModel::sendLink,
            onEmailSentInformationShow = viewModel::emailSentInformationShown,
            onOpenEmailBoxClick = { context.openEmailApp() },
        )
    }
}
