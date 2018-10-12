package com.hackerrankstring;

import java.util.ArrayList;
import java.util.List;

public class HackerRankInString {

    static List<Character> characterList = new ArrayList<Character>() {{
        add( new Character( 'h' ) );
        add( new Character( 'a' ) );
        add( new Character( 'c' ) );
        add( new Character( 'k' ) );
        add( new Character( 'e' ) );
        add( new Character( 'r' ) );
        add( new Character( 'r' ) );
        add( new Character( 'a' ) );
        add( new Character( 'n' ) );
        add( new Character( 'k' ) );
    }};

    public static String hackerrankInString( String s ) {
        int indexOfChar = -1;
        for ( Character ch : characterList ) {
            indexOfChar = findIndexOfChar( s, ch, indexOfChar + 1 );
            if ( indexOfChar == -1 ) {
                return "NO";
            }
        }
        return "YES";
    }

    private static int findIndexOfChar( String s, Character ch, int index ) {
        for ( int i = index; i < s.length(); i++ ) {
            if ( Character.toLowerCase( s.charAt( i ) ) == ch ) {
                return i;
            }
        }
        return -1;
    }

}
