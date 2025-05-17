import React, { useState } from 'react';
import { StyleSheet, Button } from 'react-native';
import { Image } from 'expo-image';

import ParallaxScrollView from '@/components/ParallaxScrollView';
import { ThemedText } from '@/components/ThemedText';
import { ThemedView } from '@/components/ThemedView';

const quotes = [
    { author: 'Nelson Mandela', text: 'It always seems impossible until it’s done.' },
    { author: 'Tony Robbins', text: 'The only limit to your impact is your imagination and commitment.' },
    { author: 'Steve Jobs', text: 'Stay hungry, stay foolish.' },
    { author: 'Zig Ziglar', text: 'You don’t have to be great to start, but you have to start to be great.' },
    { author: 'Maya Angelou', text: 'You will face many defeats in life, but never let yourself be defeated.' },
];

const getRandomQuote = () => {
    const index = Math.floor(Math.random() * quotes.length);
    return quotes[index];
};

export default function HomeScreen() {
    const [quote, setQuote] = useState(getRandomQuote());

    const refreshQuote = () => {
        let newQuote;
        do {
            newQuote = getRandomQuote();
        } while (newQuote.text === quote.text);
        setQuote(newQuote);
    };

    return (
        <ParallaxScrollView
            headerBackgroundColor={{ light: '#A1CEDC', dark: '#1D3D47' }}
            headerImage={
                <Image
                    source={require('@/assets/images/partial-react-logo.png')}
                    style={styles.reactLogo}
                />
            }
        >
            <ThemedView style={styles.titleContainer}>
                <ThemedText type="title">Daily Motivation</ThemedText>
            </ThemedView>

            <ThemedView style={styles.quoteContainer}>
                <ThemedText type="subtitle" style={styles.quoteText}>
                    “{quote.text}”
                </ThemedText>
                <ThemedText style={styles.authorText}>— {quote.author}</ThemedText>
            </ThemedView>

            {/* 🔽 Visible refresh button */}
            <ThemedView style={styles.buttonWrapper}>
                <Button title="New Quote" onPress={refreshQuote} color="#007AFF" />
            </ThemedView>
        </ParallaxScrollView>
    );
}

const styles = StyleSheet.create({
    titleContainer: {
        flexDirection: 'row',
        alignItems: 'center',
        gap: 8,
        marginBottom: 20,
    },
    quoteContainer: {
        gap: 12,
        paddingHorizontal: 16,
        paddingVertical: 24,
        backgroundColor: '#ffffff10',
        borderRadius: 12,
        marginHorizontal: 20,
    },
    quoteText: {
        fontSize: 20,
        fontStyle: 'italic',
        textAlign: 'center',
    },
    authorText: {
        fontSize: 16,
        textAlign: 'right',
        opacity: 0.7,
    },
    buttonWrapper: {
        marginTop: 30,
        marginHorizontal: 20,
        padding: 12,
        borderRadius: 10,
        backgroundColor: '#ffffff20', // visible light background
        alignItems: 'center',
    },
    reactLogo: {
        height: 178,
        width: 290,
        bottom: 0,
        left: 0,
        position: 'absolute',
    },
});
