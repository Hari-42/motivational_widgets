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
    Quote("Mahatma Gandhi", "Be the change that you wish to see in the world."),
    Quote("Winston Churchill", "Success is not final, failure is not fatal: It is the courage to continue that counts."),
    Quote("Steve Jobs", "Your time is limited, so don’t waste it living someone else’s life."),
    Quote("Nelson Mandela", "It always seems impossible until it’s done."),
    Quote("Mother Teresa", "Spread love everywhere you go. Let no one ever come to you without leaving happier."),
    Quote("Franklin D. Roosevelt", "The only thing we have to fear is fear itself."),
    Quote("Muhammad Ali", "Don’t count the days, make the days count."),
    Quote("J.K. Rowling", "It is our choices that show what we truly are, far more than our abilities."),
    Quote("John F. Kennedy", "Ask not what your country can do for you – ask what you can do for your country."),
    Quote("Leonardo da Vinci", "Learning never exhausts the mind."),
    Quote("Theodore Roosevelt", "Do what you can, with what you have, where you are."),
    Quote("Pablo Picasso", "Everything you can imagine is real."),
    Quote("Charles Darwin", "It is not the strongest of the species that survive, nor the most intelligent, but the one most responsive to change."),
    Quote("Marie Curie", "Nothing in life is to be feared, it is only to be understood."),
    Quote("Albert Schweitzer", "Success is not the key to happiness. Happiness is the key to success."),
    Quote("Socrates", "The unexamined life is not worth living."),
    Quote("Lao Tzu", "A journey of a thousand miles begins with a single step."),
    Quote("Isaac Newton", "If I have seen further it is by standing on the shoulders of Giants."),
    Quote("Plato", "Wise men speak because they have something to say; fools because they have to say something."),
    Quote("Mark Zuckerberg", "The biggest risk is not taking any risk.")
)


