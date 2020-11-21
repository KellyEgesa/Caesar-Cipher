import org.junit.Test;

import static org.junit.Assert.*;

public class DecryptTest {
    @Test
    public void newEncrypt_instantiatesCorrectly() throws Exception{
        Decrypt testDecrypt = new Decrypt("Boy", 2);
        assertEquals(true, testDecrypt instanceof Decrypt);
    }

    @Test(expected = Exception.class)
    public void newDecrypt_ifUserInputString_exception() throws Exception{
        Decrypt testDecrypt = new Decrypt("1", 2);
        assertEquals(null, testDecrypt.getUserInput());
    }

    @Test(expected = Exception.class)
    public void newDecrypt_ifUserInputsNull_exception() throws Exception{
        Decrypt testDecrypt = new Decrypt("", 2);
        assertNull(testDecrypt.getUserInput());
    }

    @Test
    public void newDecrypt_ifShiftKeyInteger_true() throws Exception{
        Decrypt testDecrypt = new Decrypt("Boy", 2);
        assertTrue( testDecrypt.getShiftKey()%1==0 );
    }

    @Test
    public void newDecrypt_getUserInput_boy() throws Exception {
        Decrypt testDecrypt = new Decrypt("Boy", 2);
        assertEquals("Boy", testDecrypt.getUserInput());
    }

    @Test
    public void newDecrypt_getShiftKey_2() throws Exception {
        Decrypt testDecrypt = new Decrypt("Boy", 2);
        assertEquals(2, testDecrypt.getShiftKey());
    }

    @Test
    public void newDecrypt_decryptsStringByPositiveIndex_a() throws Exception{
        Decrypt testDecrypt = new Decrypt("b", 1);
        assertEquals("a", testDecrypt.decrypt());
    }

    @Test
    public void newDecrypt_decryptsStringByNegativeIndex_z() throws Exception {
        Decrypt testDecrypt = new Decrypt("b", 2);
        assertEquals("z", testDecrypt.decrypt());
    }

    @Test
    public void newCaesarCipher_decryptsStringsWithSpace_aBoy() throws  Exception{
        Decrypt testDecrypt = new Decrypt("b cpz", 1);
        assertEquals("a boy", testDecrypt.decrypt());
    }

    @Test
    public void newCaesarCipher_decryptsUpperCaseStrings_ABOY() throws Exception{
        Decrypt testDecrypt = new Decrypt("B CPZ", 1);
        assertEquals("A BOY", testDecrypt.decrypt());
    }
}