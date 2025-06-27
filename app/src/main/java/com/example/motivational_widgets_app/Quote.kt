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
    Quote("Albert Einstein", "Life is like riding a bicycle. To keep your balance, you must keep moving."),
    Quote("Eleanor Roosevelt", "The future belongs to those who believe in the beauty of their dreams."),
    Quote("Walt Disney", "The way to get started is to quit talking and begin doing."),
    Quote("Henry Ford", "Whether you think you can or you think you can’t, you’re right."),
    Quote("Confucius", "It does not matter how slowly you go as long as you do not stop."),
    Quote("Vince Lombardi", "Winners never quit and quitters never win."),
    Quote("Oprah Winfrey", "The biggest adventure you can take is to live the life of your dreams."),
    Quote("Martin Luther King Jr.", "Faith is taking the first step even when you don’t see the whole staircase."),
    Quote("Benjamin Franklin", "Well done is better than well said."),
    Quote("Dalai Lama", "Happiness is not something ready made. It comes from your own actions."),
    Quote("John Wooden", "Do not let what you cannot do interfere with what you can do."),
    Quote("Aristotle", "We are what we repeatedly do. Excellence, then, is not an act, but a habit."),
    Quote("Helen Keller", "Alone we can do so little; together we can do so much."),
    Quote("Mark Twain", "The secret of getting ahead is getting started."),
    Quote("Thomas Edison", "Genius is one percent inspiration and ninety-nine percent perspiration."),
    Quote("Brian Tracy", "Make your life a masterpiece; imagine no limitations on what you can be, have or do."),
    Quote("Bruce Lee", "Knowing is not enough; we must apply. Willing is not enough; we must do."),
    Quote("Abraham Lincoln", "The best way to predict your future is to create it."),
    Quote("Ralph Waldo Emerson", "What lies behind us and what lies before us are tiny matters compared to what lies within us."),
    Quote("Jim Rohn", "Either you run the day or the day runs you."),
    Quote("Les Brown", "Shoot for the moon. Even if you miss, you'll land among the stars."),
    Quote("George Eliot", "It is never too late to be what you might have been."),
    Quote("Norman Vincent Peale", "Change your thoughts and you change your world."),
    Quote("Harvey Mackay", "Find something you love to do and you’ll never have to work a day in your life."),
    Quote("Robert Frost", "The best way out is always through."),
    Quote("Peter Drucker", "The best way to predict the future is to create it."),
    Quote("Rumi", "Let yourself be silently drawn by the strange pull of what you really love."),
    Quote("Sun Tzu", "In the midst of chaos, there is also opportunity."),
    Quote("Wayne Dyer", "Go for it now. The future is promised to no one."),
    Quote("Stephen Covey", "I am not a product of my circumstances. I am a product of my decisions.")
)

