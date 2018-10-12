package com.hackerrankstring;

import com.easy.hackerrankstring.HackerRankInString;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class HackerRankInStringTest {

    @Test
    public void givenStringOfLengthZeroThenNoReturned() {

        assertEquals( "NO", HackerRankInString.hackerrankInString( "" ) );

    }

    @Test
    public void givenStringOfLengthOneThenNoReturned() {

        assertEquals( "NO", HackerRankInString.hackerrankInString( "h" ) );

    }


    @Test
    public void givenStringWithMissingSingleCharThenNoReturned() {

        assertEquals( "NO", HackerRankInString.hackerrankInString( "hackerran" ) );
    }

    @Test
    public void givenCorrectStringThenYESReturned() {

        Map<String, String> textMatrix = new HashMap<String, String>() {{
            put( "hackerrank", "YES" );
            put( "hhhackerrank", "YES" );
            put( "hhhaaaackerrank", "YES" );
            put( "haaaackkkkkerrank", "YES" );
            put( "haaaackkkkkerrank", "YES" );
            put( "haaaacKKKKerrankkkkk", "YES" );
            put( "hackerrrrrrank", "YES" );
            put( "hackerrrrrraaaank", "YES" );
            put( "hackerrannnnkkkk", "YES" );
            put( "hackerrankkkk", "YES" );
            put( "hereisacreamkillearlyrowanewnazikilled", "YES" );
            put( "hereiamstackerrank", "YES" );
            put( "hereiamstackerank", "NO" );
            put( "hackerworld", "NO" );
        }};

        for ( Map.Entry<String, String> testValue : textMatrix.entrySet() ) {
            assertEquals( "expected " + testValue.getValue() + " for test value " + testValue.getKey(),
                    testValue.getValue(), HackerRankInString.hackerrankInString( testValue.getKey() ) );
        }
    }


}