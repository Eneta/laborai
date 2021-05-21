package com.example.a2laboratorinis;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {

    @Test(expected = NullPointerException.class)
    public void nullIsGivenTo_getSymbolsCount(){
        SymbolsWordsCounter.getSymbolsCount(null);
    }

    @Test(expected = NullPointerException.class)
    public void nullIsGivenTo_getWordsCount(){
        SymbolsWordsCounter.getWordsCount(null);
    }

    @Test
    public void emptyIsGivenTo_getSymbolsCount(){
        final int result = 0;
        final int functionResult = SymbolsWordsCounter.getSymbolsCount("");

        assertEquals(result, functionResult);
    }

    @Test
    public void emptyIsGivenTo_getWordsCount(){
        final int result = 0;
        final int functionResult = SymbolsWordsCounter.getWordsCount("");

        assertEquals(result, functionResult);
    }

    @Test
    public void spacesIsGivenTo_getSymbolsCount(){
        final int result = 4;
        final int functionResult = SymbolsWordsCounter.getSymbolsCount("    ");

        assertEquals(result, functionResult);
    }

    @Test
    public void spacesIsGivenTo_getWordsCount(){
        final int result = 0;
        final int functionResult = SymbolsWordsCounter.getWordsCount("    ");

        assertEquals(result, functionResult);
    }

    @Test
    public void normalIsGivenTo_getSymbolsCount(){
        final int result = 11;
        final int functionResult = SymbolsWordsCounter.getSymbolsCount("Hello World");

        assertEquals(result, functionResult);
    }

    @Test
    public void normalIsGivenTo_getWordsCount(){
        final int result = 2;
        final int functionResult = SymbolsWordsCounter.getWordsCount("Hello World");

        assertEquals(result, functionResult);
    }

    @Test
    public void symbolsIsGivenTo_getSymbolsCount(){
        final int result = 23;
        final int functionResult = SymbolsWordsCounter.getSymbolsCount("*/-+,.][()&^%$#@!`':;{}");

        assertEquals(result, functionResult);
    }

    @Test
    public void symbolsIsGivenTo_getWordsCount(){
        final int result = 1;
        final int functionResult = SymbolsWordsCounter.getWordsCount("*/-+,.][()&^%$#@!`':;{}");

        assertEquals(result, functionResult);
    }

    @Test
    public void numberIsGivenTo_getSymbolsCount(){
        final int result = 10;
        final int functionResult = SymbolsWordsCounter.getSymbolsCount("1887465214");

        assertEquals(result, functionResult);
    }

    @Test
    public void numberIsGivenTo_getWordsCount(){
        final int result = 1;
        final int functionResult = SymbolsWordsCounter.getWordsCount("1887465214");

        assertEquals(result, functionResult);
    }
}