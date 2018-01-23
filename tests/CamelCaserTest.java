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
            CamelCaser.camelCase("2 nice");
            fail("Expected an IllegalArgumentException to be Thrown");
        }
        catch (IllegalArgumentException e){
            assertEquals("Invalid Format", e.getMessage());
        }
    }


    @Test
    public void testInvalidFormatSecondWord() {
        try {
            CamelCaser.camelCase("good 4 u");
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

    @Test
    public void testOnlyWhiteSpaces() {
        assertEquals("", CamelCaser.camelCase("     "));
    }

    @Test
    public void testWithoutWhiteSpaces() {
        assertEquals("amazingRace", CamelCaser.camelCase("amazingrace"));
    }

    @Test
    public void testFirstLetterUpperCase() {
        assertEquals("utkarshaB", CamelCaser.camelCase("Utkarsha b"));
    }

    @Test
    public void testAllUpperCase() {
        assertEquals("amazingGreatRace", CamelCaser.camelCase("AMAZING GREAT RACE"));
    }

    @Test
    public void testOneWord() {
        assertEquals("single", CamelCaser.camelCase("single"));
    }

    @Test
    public void testDigitInTheMiddle() {
        assertEquals("goodM8", CamelCaser.camelCase("good m8"));
    }

    @Test
    public void testEndingWithWhiteSpace() {
        assertEquals("thisDog", CamelCaser.camelCase("this dog "));
    }

}