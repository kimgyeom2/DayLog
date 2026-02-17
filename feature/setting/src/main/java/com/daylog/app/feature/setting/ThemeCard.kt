package com.daylog.app.feature.setting

//@Composable
//internal fun LightDarkThemeCard(
//    onChangeDarkTheme: (Boolean) -> Unit,
//    modifier: Modifier = Modifier,
//    darkTheme: Boolean = LocalDarkTheme.current,
//) {
//    DayLogCard(
//        modifier = modifier
//    ) {
//        Column {
//            Text(
//                text = stringResource(id = R.string.),
//                style = KnightsTheme.typography.headlineSmallBL,
//                modifier = Modifier
//                    .padding(top = 24.dp, start = 24.dp)
//            )
//
//            Spacer(
//                modifier = Modifier
//                    .height(40.dp)
//            )
//
//            Row(
//                horizontalArrangement = Arrangement.spacedBy(8.dp),
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(horizontal = 8.dp)
//                    .padding(bottom = 24.dp)
//            ) {
//                ThemeCard(
//                    selected = darkTheme.not(),
//                    titleRes = R.string.light_mode,
//                    themeCardColor = DaylogColor.White,
//                    onClick = { onChangeDarkTheme(false) },
//                    modifier = Modifier
//                        .weight(1f)
//                )
//                ThemeCard(
//                    selected = darkTheme,
//                    titleRes = R.string.dark_mode,
//                    themeCardColor = KnightsColor.Graphite,
//                    onClick = { onChangeDarkTheme(true) },
//                    modifier = Modifier
//                        .weight(1f)
//                )
//            }
//        }
//    }
//}
//
//@Composable
//private fun ThemeCard(
//    selected: Boolean,
//    @StringRes titleRes: Int,
//    onClick: () -> Unit,
//    themeCardColor: Color,
//    modifier: Modifier = Modifier,
//    color: Color = MaterialTheme.colorScheme.surface,
//    contentColor: Color = MaterialTheme.colorScheme.onSurface,
//) {
//    Surface(
//        onClick = onClick,
//        color = color,
//        contentColor = contentColor,
//        shape = DayLogTheme.shape.rounded12,
//        modifier = modifier
//    ) {
//        Column(
//            horizontalAlignment = Alignment.CenterHorizontally,
//        ) {
//            Surface(
//                shape = KnightsTheme.shape.rounded12,
//                color = themeCardColor,
//                border = BorderStroke(1.dp, MaterialTheme.colorScheme.onSurface).takeIf { selected },
//                modifier = Modifier
//                    .aspectRatio(1f)
//            ) {
//                Box(
//                    contentAlignment = Alignment.BottomCenter,
//                ) {
//                    Image(
//                        painter = painterResource(id = R.drawable.img_android),
//                        contentDescription = stringResource(titleRes),
//                        contentScale = ContentScale.FillWidth,
//                        modifier = Modifier
//                            .fillMaxWidth()
//                    )
//                }
//            }
//
//            Text(
//                text = stringResource(id = titleRes),
//                style = KnightsTheme.typography.titleSmallM140,
//                modifier = Modifier
//                    .padding(top = 16.dp, bottom = 8.dp)
//            )
//
//            RadioButton(
//                selected = selected,
//                onClick = onClick,
//                colors = RadioButtonDefaults.colors(
//                    selectedColor = MaterialTheme.colorScheme.onSurface,
//                    unselectedColor = MaterialTheme.colorScheme.surfaceVariant,
//                )
//            )
//        }
//    }
//}
//
//@Preview
//@Composable
//private fun LightModeThemeCardPreview() {
//    KnightsTheme {
//        ThemeCard(
//            selected = true,
//            titleRes = R.string.light_mode,
//            themeCardColor = KnightsColor.White,
//            onClick = { },
//        )
//    }
//}
//
//@Preview
//@Composable
//private fun DarkModeThemeCardPreview() {
//    KnightsTheme {
//        ThemeCard(
//            selected = true,
//            titleRes = R.string.dark_mode,
//            themeCardColor = KnightsColor.Graphite,
//            onClick = { },
//        )
//    }
//}
