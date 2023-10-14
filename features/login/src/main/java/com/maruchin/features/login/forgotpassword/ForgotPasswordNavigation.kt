package com.maruchin.features.login.forgotpassword

import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.maruchin.core.intent.openEmailApp

internal const val FORGOT_PASSWORD_ROUTE = "forgot_password"

internal fun NavGraphBuilder.forgotPasswordScreen(onBack: () -> Unit) {
    composable(FORGOT_PASSWORD_ROUTE) {
        val viewModel: ForgotPasswordViewModel = hiltViewModel()
        val context = LocalContext.current
        ForgotPasswordScreen(
            forgotPasswordFormState = viewModel.forgotPasswordFormState,
            emailState = viewModel.emailState,
            onBack = onBack,
            onSendLink = viewModel::sendLink,
            onEmailSentInformationShow = viewModel::emailSentInformationShown,
            onOpenEmailBox = { context.openEmailApp() },
        )
    }
}

internal fun NavController.navigateToForgotPassword() {
    navigate(FORGOT_PASSWORD_ROUTE)
}
