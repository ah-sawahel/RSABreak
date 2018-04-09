package tests;
import static org.junit.Assert.assertEquals;

import java.math.BigInteger;

import org.junit.Test;

import t2.OldRSABreaker;

public class TestOldRSABreaker {

    public TestOldRSABreaker() {
        // TODO Auto-generated constructor stub
    }
    /**
     * Test Case Number 1
     */
    @Test
    public void testCase1() {
        OldRSABreaker rsa = new OldRSABreaker();
        rsa.setE(BigInteger.valueOf(3851));
        rsa.setN(1456471);
        rsa.setEncryptedMessage(798624420);
        assertEquals(755, rsa.getD().intValue());
        assertEquals(BigInteger.valueOf(778371), rsa.decryptMessage());
    }


    /**
     * Test Case Number 2
     */
    @Test
    public void testCase2() {
        OldRSABreaker rsa = new OldRSABreaker();
        rsa.setE(BigInteger.valueOf(16547));
        rsa.setN(3072973);
        rsa.setEncryptedMessage(19630);
        assertEquals(371, rsa.getD().intValue());
        assertEquals(BigInteger.valueOf(778371), rsa.decryptMessage());

    }

    /**
     * Test Case Number 3
     */
    @Test
    public void testCase3() {
        OldRSABreaker rsa = new OldRSABreaker();
        rsa.setE(BigInteger.valueOf(1787707));
        rsa.setN(2684839);
        rsa.setEncryptedMessage(1431820);
        assertEquals(3, rsa.getD().intValue());
        assertEquals(BigInteger.valueOf(778371), rsa.decryptMessage());

    }


}
