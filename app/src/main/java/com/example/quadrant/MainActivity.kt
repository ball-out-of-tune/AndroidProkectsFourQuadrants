package com.example.quadrant

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.quadrant.ui.theme.QuadrantTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            QuadrantTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    fourQuadrants()
                }
            }
        }
    }
}


@Composable
fun fourQuadrants() {
    Column(Modifier.fillMaxWidth()) {
        Row(Modifier.weight(1f)) {
            quadrant(
                title = stringResource(R.string.text_composable),
                text = stringResource(R.string.text1),
                bgcolor = Color(0xFFEADDFF),
                modifier = Modifier.weight(1f)
            )
            quadrant(
                title = stringResource(R.string.image_composable),
                text = stringResource(R.string.text2),
                bgcolor = Color(0xFFD0BCFF),
                modifier = Modifier.weight(1f)
            )
        }
        Row(Modifier.weight(1f)) {
            quadrant(title = "Row composable", text = "A layout composable that places its children in a horizontal sequence.", bgcolor = Color(0xFFB69DF8), modifier = Modifier.weight(1f))
            quadrant(title = "Column composable", text = "A layout composable that places its children in a vertical sequence.", bgcolor = Color(0xFFF6EDFF), modifier = Modifier.weight(1f))
        }
    }
}

@Composable
fun quadrant(title: String, text: String, bgcolor: Color, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(bgcolor)
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = title,
            fontWeight = FontWeight.Bold,
//            modifier = modifier.padding(bottom = 4.dp)
        )
        Text(
            text = text,
            textAlign = TextAlign.Justify
        )
    }
}

@Preview(showBackground = true)
@Composable
fun fourQuadrantsPreview() {
    MaterialTheme {
        fourQuadrants()
    }
}