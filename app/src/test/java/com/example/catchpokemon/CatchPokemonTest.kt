package com.example.catchpokemon

import org.junit.Assert.assertEquals
import org.junit.Test

internal class CatchPokemonTest {
    private val main = CatchPokemon()

    @Test
    fun testCatchPokemon(){
        val input = "E"
        val result = main.catchPokemon(input)
        assertEquals(2, result)
    }

    @Test
    fun testCatchPokemon2(){
        val input = "NSNSNSNSNS"
        val result = main.catchPokemon(input)
        assertEquals(2, result)
    }

    @Test
    fun testCatchPokemonInvalidInput(){
        val input = "BANANA&"
        val result = main.catchPokemon(input)
        assertEquals(3, result)
    }

    @Test
    fun testCatchPokemonBacktrack(){
        val input = "NNNEEEOO"
        val result = main.catchPokemon(input)
        assertEquals(7, result)
    }

    @Test
    fun testCatchPokemonEmptyInput(){
        val input = ""
        val result = main.catchPokemon(input)
        assertEquals(1, result)
    }

    @Test
    fun testCatchPokemonNullInput(){
        val input = null
        val result = main.catchPokemon(input)
        assertEquals(1, result)
    }

}