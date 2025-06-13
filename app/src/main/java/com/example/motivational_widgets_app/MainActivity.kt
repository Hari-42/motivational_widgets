package com.example.motivational_widgets_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.motivational_widgets_app.ui.theme.Motivational_widgets_appTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Motivational_widgets_appTheme {
                MotivationalApp()
            }
        }
    }
}

@Composable
fun MotivationalApp() {
    val quotes = listOf(
        Quote("Nelson Mandela", "It always seems impossible until it’s done."),
        Quote("Tony Robbins", "The only limit to your impact is your imagination and commitment."),
        Quote("Steve Jobs", "Stay hungry, stay foolish."),
        Quote("Zig Ziglar", "You don’t have to be great to start, but you have to start to be great."),
        Quote("Maya Angelou", "You will face many defeats in life, but never let yourself be defeated.")
    )

    var currentQuote by remember { mutableStateOf<Quote?>(null) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Custom Header
            Text(
                text = "Motivational Widgets",
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(top = 24.dp, bottom = 32.dp)
            )

            Spacer(modifier = Modifier.weight(1f))

            // Center Button + Quote
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Button(onClick = {
                    currentQuote = quotes.random()
                }) {
                    Text("Inspire Me")
                }

                Spacer(modifier = Modifier.height(24.dp))

                currentQuote?.let {
                    Text(
                        text = "\"${it.text}\"\n\n- ${it.author}",
                        fontSize = 18.sp,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(horizontal = 24.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.weight(1f))
        }
    }
}

data class Quote(val author: String, val text: String)
