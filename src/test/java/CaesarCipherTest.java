import org.junit.Test;

import static org.junit.Assert.*;

public class CaesarCipherTest {
    @Test
    public void newCaesarCipher_instantiatesCorrectly() throws Exception{
        CaesarCipher testCaesarCipher = new CaesarCipher("Boy", 2);
        assertEquals(true, testCaesarCipher instanceof CaesarCipher);
    }

    @Test(expected = Exception.class)
    public void newCaesarCipher_ifUserInputString_exception() throws Exception{
        CaesarCipher testCaesarCipher = new CaesarCipher("1", 2);
        assertNull(testCaesarCipher.getUserInput());
    }

    @Test(expected = Exception.class)
    public void newCaesarCipher_ifUserInputsNull_exception() throws Exception{
        CaesarCipher testCaesarCipher = new CaesarCipher("", 2);
        assertNull(testCaesarCipher.getUserInput());
    }

    @Test
    public void newCaesarCipher_ifShiftKeyInteger_true() throws Exception{
        CaesarCipher testCaesarCipher = new CaesarCipher("Boy", 2);
        assertTrue( testCaesarCipher.getShiftKey()%1==0 );
    }

    @Test
    public void newCaesarCipher_getUserInput_boy() throws Exception {
        CaesarCipher testCaesarCipher = new CaesarCipher("Boy", 2);
        assertEquals("Boy", testCaesarCipher.getUserInput());
    }

    @Test
    public void newCaesarCipher_getShiftKey_2() throws Exception {
        CaesarCipher testCaesarCipher = new CaesarCipher("Boy", 2);
        assertEquals(2, testCaesarCipher.getShiftKey());
    }


}