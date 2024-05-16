package de.uniks.comtec.weatherapp.ui.home

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun Home(viewModel: HomeViewModel = hiltViewModel()) {

    val state by viewModel.uiState.collectAsState()

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color.hsv(0f, 0.59f, 0.7f), Color.hsv(189f, 0.9107f, 0.6588f)
                    )
                )
            )
    ) {
        Card(
            modifier = Modifier
                .padding(16.dp)
                .alpha(alpha = 0.8f),
            colors = CardDefaults.cardColors().copy(
                Color.Black
            )
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.padding(16.dp)
            ) {
                Text("Temperature", fontSize = 16.sp, color = Color.White, modifier = Modifier.alpha(0.6f))
                Spacer(modifier = Modifier.size(16.dp))
                Text(
                    modifier = Modifier.padding(32.dp), text = "${
                        if (state.temperature == null) {
                            "-"
                        } else {
                            state.temperature
                        }
                    }°C", fontSize = 64.sp, color = Color.White
                )
                AnimatedVisibility(visible = state.loading) {
                    Spacer(modifier = Modifier.size(16.dp))
                    CircularProgressIndicator(
                        trackColor = Color.White, color = Color.hsv(189f, 0.9107f, 0.6588f)
                    )
                }
            }
        }
    }
}

