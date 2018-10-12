package com.easy.caesarcipher;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Character.isUpperCase;

public class CaesarCipher {

    public String encrypt( String plainTxt, int rotCount ) {

        StringBuffer result = new StringBuffer();

        for ( char c : plainTxt.toCharArray() ) {

            if ( isNotSpecialCharacter( c ) ) {
                char ch = rotateCharacter( c, rotCount );
                result.append( isUpperCase( c ) ? Character.toUpperCase( ch ) : ch );
            } else {
                result.append( c );
            }
        }

        return result.toString();
    }

    private char rotateCharacter( char c, int rotCount ) {
        return (char) ( characters.get( getIndex( c, rotCount ) ) );
    }

    public int getIndex( char c, int rotCount ) {
        return ( characters.indexOf( Character.toLowerCase( c ) ) + rotCount ) % characters.size();
    }

    public List<Character> getCharacters() {
        return this.characters;
    }

    private boolean isNotSpecialCharacter( char c ) {
        return characters.contains( Character.toLowerCase( c ) );
    }

    private List<Character> characters = new ArrayList<Character>() {{
        add( 'a' );
        add( 'b' );
        add( 'c' );
        add( 'd' );
        add( 'e' );
        add( 'f' );
        add( 'g' );
        add( 'h' );
        add( 'i' );
        add( 'j' );
        add( 'k' );
        add( 'l' );
        add( 'm' );
        add( 'n' );
        add( 'o' );
        add( 'p' );
        add( 'q' );
        add( 'r' );
        add( 's' );
        add( 't' );
        add( 'u' );
        add( 'v' );
        add( 'w' );
        add( 'x' );
        add( 'y' );
        add( 'z' );
    }};

}
