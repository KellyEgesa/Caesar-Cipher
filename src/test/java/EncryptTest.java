import org.junit.Test;

import static org.junit.Assert.*;

public class EncryptTest {
    @Test
    public void newEncrypt_instantiatesCorrectly() throws Exception{
        Encrypt testEncrypt = new Encrypt("Boy", 2);
        assertEquals(true, testEncrypt instanceof Encrypt);
    }

    @Test(expected = Exception.class)
    public void newEncrypt_ifUserInputString_exception() throws Exception{
        Encrypt testEncrypt = new Encrypt("1", 2);
        assertEquals(null, testEncrypt.getUserInput());
    }

    @Test(expected = Exception.class)
    public void newEncrypt_ifUserInputsNull_exception() throws Exception{
        Encrypt testEncrypt = new Encrypt("", 2);
        assertNull(testEncrypt.getUserInput());
    }

    @Test
    public void newEncrypt_ifShiftKeyInteger_true() throws Exception{
        Encrypt testEncrypt = new Encrypt("Boy", 2);
        assertTrue( testEncrypt.getShiftKey()%1==0 );
    }

    @Test
    public void newEncrypt_getUserInput_boy() throws Exception {
        Encrypt testEncrypt = new Encrypt("Boy", 2);
        assertEquals("Boy", testEncrypt.getUserInput());
    }

    @Test
    public void newEncrypt_getShiftKey_2() throws Exception {
        Encrypt testEncrypt = new Encrypt("Boy", 2);
        assertEquals(2, testEncrypt.getShiftKey());
    }

    @Test
    public void newEncrypt_encryptsStringByIndexLessThan26_b() throws Exception {
        Encrypt testEncrypt = new Encrypt("a", 1);
        assertEquals("b", testEncrypt.encrypt());
    }

    @Test
    public void newEncrypt_encryptsStringByIndexGreaterThan26_b() throws Exception{
        Encrypt testEncrypt = new Encrypt("z", 2);
        assertEquals("b", testEncrypt.encrypt());
    }

    @Test
    public void newEncrypt_encryptsUpperCaseStrings_BCpz() throws Exception{
        Encrypt testEncrypt = new Encrypt("A boy", 1);
        assertEquals("B cpz", testEncrypt.encrypt());
    }

    @Test
    public void newEncrypt_encryptsStringsWithSpace_bCpz() throws Exception{
        Encrypt testEncrypt = new Encrypt("a boy", 1);
        assertEquals("b cpz", testEncrypt.encrypt());
    }

}