import org.junit.Test;

import static org.junit.Assert.*;

public class CaesarCipherTest {
    @Test
    public void newCaesarCipher_instantiatesCorrectly(){
        CaesarCipher testCaesarCipher = new CaesarCipher("Boy", 2);
        assertTrue(testCaesarCipher instanceof CaesarCipher);
    }

    @Test
    public void newCaesarCipher_getsUserInput_boy() {
        CaesarCipher testCaesarCipher = new CaesarCipher("Boy", 2);
        assertEquals("Boy", testCaesarCipher.getUserInput());
    }
}