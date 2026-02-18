package com.daylog.app.feature.setting.component

import androidx.annotation.StringRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.daylog.app.core.designsystem.theme.DayLogTheme
import com.daylog.app.core.designsystem.theme.DaylogColor
import com.daylog.app.core.designsystem.theme.component.DayLogCard
import com.daylog.app.feature.profile.R

@Composable
internal fun LightDarkThemeCard(
    onChangeDarkTheme: (Boolean) -> Unit,
    modifier: Modifier = Modifier,
    darkTheme: Boolean,
) {
    DayLogCard(
        modifier = modifier
            .padding(top = 20.dp)
    ) {
        Column {
            Text(
                text = stringResource(id = R.string.setting),
                style = DayLogTheme.typography.headlineSmallBL,
                modifier = Modifier
                    .padding(top = 12.dp, start = 24.dp)
            )

            Spacer(
                modifier = Modifier
                    .height(10.dp)
            )

            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp)
                    .padding(bottom = 12.dp)
            ) {
                ThemeCard(
                    selected = !darkTheme,
                    titleRes = R.string.light_mode,
                    themeCardColor = DaylogColor.White,
                    onClick = { onChangeDarkTheme(false) },
                    modifier = Modifier
                        .weight(1f)
                )
                ThemeCard(
                    selected = darkTheme,
                    titleRes = R.string.dark_mode,
                    themeCardColor = DaylogColor.Graphite,
                    onClick = { onChangeDarkTheme(true) },
                    modifier = Modifier
                        .weight(1f)
                )
            }
        }
    }
}



@Composable
private fun ThemeCard(
    selected: Boolean,
    @StringRes titleRes: Int,
    onClick: () -> Unit,
    themeCardColor: Color,
    modifier: Modifier = Modifier,
) {
    Surface(
        onClick = onClick,
        color = MaterialTheme.colorScheme.surface,
        contentColor = MaterialTheme.colorScheme.onSurface,
        shape = DayLogTheme.shape.rounded12,
        modifier = modifier
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Surface(
                shape = DayLogTheme.shape.rounded12,
                color = themeCardColor,
                border = if (selected) BorderStroke(2.dp, MaterialTheme.colorScheme.primary) else null,
                modifier = Modifier.aspectRatio(1f)
            ) {
                Box(contentAlignment = Alignment.BottomCenter) {
                    Image(
                        painter = painterResource(id = R.drawable.img_android),
                        contentDescription = stringResource(titleRes),
                        contentScale = ContentScale.FillWidth,
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            }

            Text(
                text = stringResource(id = titleRes),
                style = DayLogTheme.typography.titleSmallM140,
                modifier = Modifier.padding(top = 16.dp, bottom = 8.dp)
            )

            RadioButton(
                selected = selected,
                onClick = onClick,
                colors = RadioButtonDefaults.colors(
                    selectedColor = MaterialTheme.colorScheme.secondary,
                    unselectedColor = MaterialTheme.colorScheme.outline,
                )
            )
        }
    }
}

@Preview
@Composable
private fun LightModeThemeCardPreview() {
    DayLogTheme(false) {
        ThemeCard(
            selected = true,
            titleRes = R.string.light_mode,
            themeCardColor = DaylogColor.White,
            onClick = { },
        )
    }
}

@Preview
@Composable
private fun DarkModeThemeCardPreview() {
    DayLogTheme(true) {
        ThemeCard(
            selected = true,
            titleRes = R.string.dark_mode,
            themeCardColor = DaylogColor.Graphite,
            onClick = { },
        )
    }
}
