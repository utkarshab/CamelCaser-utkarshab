import org.junit.Test;

import static org.junit.Assert.*;

public class CamelCaserTest {
    @Test
    public void handoutTestCamelCase() {
        assertEquals("thisIsMyString", CamelCaser.camelCase("this is my string"));
    }


    @Test
    public void testInvalidCharacter() {
    try {
        CamelCaser.camelCase("how @re you?");
        fail("Expected an IllegalArgumentException to be Thrown");
    } catch (IllegalArgumentException e) {
        assertEquals("Invalid Character", e.getMessage());
    }
}
    @Test
    public void testInvalidFormat() {
        try {
            CamelCaser.camelCase("2 nice 4 u");
            fail("Expected an IllegalArgumentException to be Thrown");
        }
        catch (IllegalArgumentException e){
            assertEquals("Invalid Format", e.getMessage());
        }
    }

    @Test
    public void testNullInput() {
        try {
            CamelCaser.camelCase(null);
            fail("Expected an IllegalArgumentException to be Thrown");
        }
        catch (IllegalArgumentException e){
            assertEquals("Invalid Format", e.getMessage());
        }
    }


}