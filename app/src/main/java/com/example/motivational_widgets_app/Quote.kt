package com.example.motivational_widgets_app

/**
 * Represents a motivational quote with an author and the quote text.
 */
data class Quote(
    val author: String,
    val text: String
)

/**
 * Static list of sample quotes.
 */
val sampleQuotes = listOf(
    Quote("Nelson Mandela", "It always seems impossible until it’s done."),
    Quote("Tony Robbins", "The only limit to your impact is your imagination and commitment."),
    Quote("Steve Jobs", "Stay hungry, stay foolish."),
    Quote("Zig Ziglar", "You don’t have to be great to start, but you have to start to be great."),
    Quote("Maya Angelou", "You will face many defeats in life, but never let yourself be defeated.")
)
