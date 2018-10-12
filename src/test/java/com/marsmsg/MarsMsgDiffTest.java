package com.marsmsg;

import com.easy.marsmsg.MarsMsgDiff;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class MarsMsgDiffTest {

    @Test
    public void calculateDiffWithMinMsgLen() {

        String msg = "SOS";

        assertEquals( 0, MarsMsgDiff.calculateDiff( msg ) );
    }

    @Test
    public void calculateDiffWithMinMsgLenWithDifferentNumberOfDeviations() {

        Map<String, Integer> testMap = new HashMap<String, Integer>() {{
            put( "SOS", 0 );
            put( "TOS", 1 );
            put( "STS", 1 );
            put( "SOT", 1 );
            put( "SSO", 2 );
            put( "TOO", 2 );
            put( "TTT", 3 );
            put( "SOSSTS", 1 );
            put( "SOSSSS", 1 );
            put( "SOSOOO", 2 );
            put( "SSSSSSSSS", 3 );
            put( "SOSSPSSQSSOR", 3 );
        }};

        for ( Map.Entry<String, Integer> entry : testMap.entrySet() ) {

            assertEquals( entry.getValue(), Integer.valueOf( MarsMsgDiff.calculateDiff( entry.getKey() ) ) );
        }
    }

}