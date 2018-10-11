package com.caesarcipher;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CaesarCipherTest {

    CaesarCipher caesarCipher = new CaesarCipher();

    @Test
    public void singleCharacterCipher() {

        String s = "a";

        assertEquals( "c", caesarCipher.encrypt( s, 2 ) );
    }

    @Test
    public void twoCharactersCipher() {

        String s = "ab";

        assertEquals( "cd", caesarCipher.encrypt( s, 2 ) );
    }

    @Test
    public void threeCharactersCipherWithExceptionalCharacter() {

        String s = "ab-";

        assertEquals( "cd-", caesarCipher.encrypt( s, 2 ) );
    }

    @Test
    public void threeCharactersCipherWithExceptionalCharacterBorder() {

        String s = "[@ab-%";

        assertEquals( "[@cd-%", caesarCipher.encrypt( s, 2 ) );
    }

    @Test
    public void rotateWithCharactersThatNeedWrapAround() {

        String s = "XYZxyz";

        assertEquals( "ABCabc", caesarCipher.encrypt( s, 3 ) );

    }

    @Test
    public void capital_Y_withRotationCountOf_1_WillNotWrap() {

        assertEquals( "Z", caesarCipher.encrypt( "Y", 1 ) );
    }


    @Test
    public void allAlphabet() {

        String actual = "abcdefghijklmnopqrstuvwxyz";
        String expected = "defghijklmnopqrstuvwxyzabc";

        assertEquals( expected, caesarCipher.encrypt( actual, 3 ) );

    }

    @Test
    public void testcaseFailingOnHackerRank() {

        String actual = "www.abc.xy";
        String expected = "fff.jkl.gh";

        assertEquals( expected, caesarCipher.encrypt( actual, 87 ) );
    }

    @Test
    public void givenCharAndRotationCorrectIndexIsReturned() {
        assertEquals( 1, caesarCipher.getIndex('a', 1) );
        assertEquals( 0, caesarCipher.getIndex('z', 1) );
        assertEquals( 25, caesarCipher.getIndex('x', 2) );

        int index = caesarCipher.getIndex( 'w', 2 );
        assertEquals( 'y', (char) caesarCipher.getCharacters().get( index ) );
    }

}