package hbo.petiteannonce;

import hbo.petiteannonce.utils.StringUtils;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StringUtilsTest {

    @Test
    public void shouldReturnNull() {
        String returnedValue = StringUtils.repeat(null, 2);
        Assertions.assertNull(returnedValue);
    }

    @Test
    public void shouldReturnEmpty() {
        String expectedValue = "";
        String returnedValue = StringUtils.repeat("", 10);
        Assertions.assertEquals(returnedValue, expectedValue);
    }

    @Test
    public void shouldReturnZeroTimesConcatenatedWord() {
        String expectedValue = "";
        String returnedValue = StringUtils.repeat("bonjour", 0);
        Assertions.assertEquals(returnedValue, expectedValue);
    }

    @Test
    public void shouldReturnRepeatedWord() {
        String expectedValue = "bonjourbonjourbonjour";
        String returnedValue = StringUtils.repeat("bonjour", 3);
        Assertions.assertEquals(returnedValue, expectedValue);
    }

    @Test
    public void shouldThrowIllegalStateException() {
        Assert.assertThrows(IllegalArgumentException.class, () -> StringUtils.repeat("bonjour", -1));
    }
}
