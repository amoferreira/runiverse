package com.amoferreira.core.presentation.designsystem.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.amoferreira.core.presentation.designsystem.LogoIcon
import com.amoferreira.core.presentation.designsystem.R

@Composable
fun LogoIconTextVertical(
    modifier: Modifier = Modifier,
) {
    val color = MaterialTheme.colorScheme.onBackground
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Icon(
            imageVector = LogoIcon,
            contentDescription = "Logo",
            tint = color,
        )
        Spacer(Modifier.height(dimensionResource(id = R.dimen.medium_vertical_spacing)))
        Text(
           text = stringResource(id = R.string.app_name),
            fontSize = 24.sp,
            fontWeight = FontWeight.Medium,
            color = color,
        )
    }
}