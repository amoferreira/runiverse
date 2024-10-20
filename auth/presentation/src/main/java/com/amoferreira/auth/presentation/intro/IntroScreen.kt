package com.amoferreira.auth.presentation.intro

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.sp
import com.amoferreira.core.presentation.designsystem.R
import com.amoferreira.core.presentation.designsystem.components.GradientBackground
import com.amoferreira.core.presentation.designsystem.components.LogoIconTextVertical
import com.amoferreira.core.presentation.designsystem.components.OutlinedTextButton
import com.amoferreira.core.presentation.designsystem.components.TextButton

@Composable
fun IntroScreen(
    onAction: (IntroAction) -> Unit,
) {
    GradientBackground {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            contentAlignment = Alignment.Center,
        ) {
            LogoIconTextVertical()
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(dimensionResource(id = R.dimen.general_padding))
                .padding(bottom = dimensionResource(id = R.dimen.extra_bottom_padding))
        ) {
            Text(
               text = stringResource(id = R.string.welcome_to_runiverse),
                color = MaterialTheme.colorScheme.onBackground,
                fontSize = 20.sp,
            )
            Spacer(
                modifier = Modifier.height(dimensionResource(id = R.dimen.small_vertical_spacing))
            )
            Text(
                text = stringResource(id = R.string.runiverse_description),
                style = MaterialTheme.typography.bodySmall,
            )
            Spacer(
                modifier = Modifier
                    .height(dimensionResource(id = R.dimen.extra_large_vertical_spacing))
            )
            OutlinedTextButton(
                text = stringResource(id = R.string.sign_in_button),
                isLoading = false,
                onClick = { onAction(IntroAction.OnSignInClick) },
            )
            Spacer(
                modifier = Modifier.height(dimensionResource(id = R.dimen.medium_vertical_spacing))
            )
            TextButton(
                text = stringResource(id = R.string.sign_up_button),
                isLoading = false,
                onClick = { onAction(IntroAction.OnSignUpClick) }
            )
        }
    }
}