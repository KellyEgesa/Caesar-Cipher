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
        assertEquals(null,testCaesarCipher.getUserInput());
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

    @Test
    public void newCaesarCipher_encryptsStringByIndexLessThan26_b() throws Exception {
        CaesarCipher testCaesarCipher = new CaesarCipher("a", 1);
        assertEquals("b", testCaesarCipher.encrypt());
    }

    @Test
    public void newCaesarCipher_encryptsStringByIndexGreaterThan26_b() throws Exception{
        CaesarCipher testCaesarCipher = new CaesarCipher("z", 2);
        assertEquals("b", testCaesarCipher.encrypt());
    }

    @Test
    public void newCaesarCipher_encryptsUpperCaseStrings_BCpz() throws Exception{
        CaesarCipher testCaesarCipher = new CaesarCipher("A boy", 1);
        assertEquals("B cpz", testCaesarCipher.encrypt());
    }

    @Test
    public void newCaesarCipher_encryptsStringsWithSpace_bCpz() throws Exception{
        CaesarCipher testCaesarCipher = new CaesarCipher("a boy", 1);
        assertEquals("b cpz", testCaesarCipher.encrypt());
    }

    @Test
    public void newCaesarCipher_decryptsStringByPositiveIndex_a() throws Exception{
        CaesarCipher testCaesarCipher = new CaesarCipher("b", 1);
        assertEquals("a", testCaesarCipher.decrypt());
    }

    @Test
    public void newCaesarCipher_decryptsStringByNegativeIndex_z() throws Exception {
       CaesarCipher testCaesarCipher = new CaesarCipher("b", 2);
       assertEquals("z", testCaesarCipher.decrypt());
    }

    @Test
    public void newCaesarCipher_decryptsStringsWithSpace_aBoy() throws  Exception{
        CaesarCipher testCaesarCipher = new CaesarCipher("b cpz", 1);
        assertEquals("a boy", testCaesarCipher.decrypt());
    }

    @Test
    public void newCaesarCipher_decryptsUpperCaseStrings_ABOY() throws Exception{
        CaesarCipher testCaesarCipher = new CaesarCipher("B CPZ", 1);
        assertEquals("A BOY", testCaesarCipher.decrypt());
    }
}