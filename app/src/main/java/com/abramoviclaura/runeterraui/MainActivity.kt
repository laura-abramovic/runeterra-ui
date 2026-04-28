package com.abramoviclaura.runeterraui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.abramoviclaura.runeterraui.ui.theme.RuneterraUITheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RuneterraUITheme(dynamicColor = false) {
                Scaffold(
                    containerColor = RuneterraUITheme.colors.background,
                    modifier = Modifier.fillMaxSize(),
                ) { innerPadding ->
                    ThemeShowcaseScreen(
                        modifier = Modifier.padding(innerPadding),
                    )
                }
            }
        }
    }
}

@Composable
private fun ThemeShowcaseScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(RuneterraUITheme.colors.background)
            .verticalScroll(rememberScrollState())
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp),
    ) {
        HeroCard()
        ShowcaseSection(title = "Palette", subtitle = "Core colors pulled directly from RuneterraUITheme.colors.") {
            PaletteGrid()
        }
        ShowcaseSection(title = "Typography", subtitle = "Display and body styles from your Google font setup.") {
            TypographyCard()
        }
        ShowcaseSection(title = "Components", subtitle = "A few common building blocks styled with the theme.") {
            ComponentsCard()
        }
    }
}

@Composable
private fun HeroCard() {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = RuneterraUITheme.colors.surfaceContainer,
        ),
        shape = RoundedCornerShape(28.dp),
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(24.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            Surface(
                color = RuneterraUITheme.colors.primaryContainer,
                contentColor = RuneterraUITheme.colors.onPrimaryContainer,
                shape = RoundedCornerShape(999.dp),
            ) {
                Text(
                    text = "Runeterra UI",
                    style = RuneterraUITheme.typography.labelLarge,
                    modifier = Modifier.padding(horizontal = 14.dp, vertical = 8.dp),
                )
            }

            Text(
                text = "Theme showcase",
                style = RuneterraUITheme.typography.displaySmall,
                color = RuneterraUITheme.colors.onBackground,
            )

            Text(
                text = "This screen demonstrates your palette, typography, and component surfaces using the new theme object API.",
                style = RuneterraUITheme.typography.bodyLarge,
                color = RuneterraUITheme.colors.onSurfaceVariant,
            )
        }
    }
}

@Composable
private fun ShowcaseSection(
    title: String,
    subtitle: String,
    content: @Composable () -> Unit,
) {
    Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
        Text(
            text = title,
            style = RuneterraUITheme.typography.headlineSmall,
            color = RuneterraUITheme.colors.onBackground,
        )
        Text(
            text = subtitle,
            style = RuneterraUITheme.typography.bodyMedium,
            color = RuneterraUITheme.colors.onSurfaceVariant,
        )
        content()
    }
}

@Composable
private fun PaletteGrid() {
    Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
        ) {
            PaletteSwatch(
                name = "Primary",
                color = RuneterraUITheme.colors.primary,
                onColor = RuneterraUITheme.colors.onPrimary,
                modifier = Modifier.weight(1f),
            )
            PaletteSwatch(
                name = "Secondary",
                color = RuneterraUITheme.colors.secondary,
                onColor = RuneterraUITheme.colors.onSecondary,
                modifier = Modifier.weight(1f),
            )
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
        ) {
            PaletteSwatch(
                name = "Tertiary",
                color = RuneterraUITheme.colors.tertiary,
                onColor = RuneterraUITheme.colors.onTertiary,
                modifier = Modifier.weight(1f),
            )
            PaletteSwatch(
                name = "Surface",
                color = RuneterraUITheme.colors.surfaceContainerHigh,
                onColor = RuneterraUITheme.colors.onSurface,
                modifier = Modifier.weight(1f),
            )
        }
    }
}

@Composable
private fun PaletteSwatch(
    name: String,
    color: Color,
    onColor: Color,
    modifier: Modifier = Modifier,
) {
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(20.dp),
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(color)
                .padding(18.dp),
            verticalArrangement = Arrangement.spacedBy(24.dp),
        ) {
            Text(
                text = name,
                style = RuneterraUITheme.typography.titleMedium,
                color = onColor,
            )
            Box(
                modifier = Modifier
                    .size(width = 56.dp, height = 8.dp)
                    .clip(RoundedCornerShape(999.dp))
                    .background(onColor.copy(alpha = 0.6f)),
            )
        }
    }
}

@Composable
private fun TypographyCard() {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = RuneterraUITheme.colors.surfaceContainerLow,
        ),
        shape = RoundedCornerShape(24.dp),
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(24.dp),
            verticalArrangement = Arrangement.spacedBy(18.dp),
        ) {
            Text(
                text = "Noxus rises",
                style = RuneterraUITheme.typography.displayMedium,
                color = RuneterraUITheme.colors.onSurface,
            )
            Text(
                text = "Headline styles establish the mood while body styles stay readable for dense card text and navigation.",
                style = RuneterraUITheme.typography.bodyLarge,
                color = RuneterraUITheme.colors.onSurfaceVariant,
            )
            Text(
                text = "LABEL LARGE",
                style = RuneterraUITheme.typography.labelLarge.copy(fontWeight = FontWeight.SemiBold),
                color = RuneterraUITheme.colors.primary,
            )
        }
    }
}

@Composable
private fun ComponentsCard() {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = RuneterraUITheme.colors.surfaceContainer,
        ),
        shape = RoundedCornerShape(24.dp),
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(24.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp),
        ) {
            Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                Button(onClick = {}) {
                    Text("Primary")
                }
                OutlinedButton(onClick = {}) {
                    Text("Outlined")
                }
            }

            Surface(
                color = RuneterraUITheme.colors.secondaryContainer,
                contentColor = RuneterraUITheme.colors.onSecondaryContainer,
                shape = RoundedCornerShape(20.dp),
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp),
                ) {
                    Text(
                        text = "Featured panel",
                        style = RuneterraUITheme.typography.titleLarge,
                    )
                    Text(
                        text = "Secondary containers work well for highlighted content, filters, or card states.",
                        style = RuneterraUITheme.typography.bodyMedium,
                    )
                }
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(12.dp),
            ) {
                StatBar(
                    label = "Attack",
                    progress = 0.82f,
                    color = RuneterraUITheme.colors.primary,
                    modifier = Modifier.weight(1f),
                )
                StatBar(
                    label = "Defense",
                    progress = 0.64f,
                    color = RuneterraUITheme.colors.tertiary,
                    modifier = Modifier.weight(1f),
                )
            }
        }
    }
}

@Composable
private fun StatBar(
    label: String,
    progress: Float,
    color: Color,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        Text(
            text = label,
            style = RuneterraUITheme.typography.labelMedium,
            color = RuneterraUITheme.colors.onSurface,
        )
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(10.dp)
                .clip(RoundedCornerShape(999.dp))
                .background(RuneterraUITheme.colors.surfaceVariant),
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth(progress.coerceIn(0f, 1f))
                    .height(10.dp)
                    .clip(RoundedCornerShape(999.dp))
                    .background(color),
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ThemeShowcasePreview() {
    RuneterraUITheme(dynamicColor = false) {
        ThemeShowcaseScreen()
    }
}
