package com.easy.marsmsg;

public class MarsMsgDiff {


    public static int calculateDiff( String s ) {
        int total = 0;
        for ( int i = 0; i <= s.length() - 3; i= i + 3 ) {
            int  sLoc = i;
            int oLoc = i+1;
            int ssLoc = i+2;
            if(s.charAt( sLoc  ) != 'S')
                total++;
            if( s.charAt( oLoc ) != 'O')
                total++;
            if (s.charAt( ssLoc ) != 'S')
                total++;

        }

        return total;
    }


}
