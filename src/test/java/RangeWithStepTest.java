import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class RangeWithStepTest {
    @Test
    public void shouldReturnFiveExactIntegersWithForeach() {
        RangeWithStep range = new RangeWithStep(1, 10, 2);
        int[] expectedNumbers = {1, 3, 5, 7, 9};
        int[] actualNumbers = new int[5];
        int counter = 0;
        for(Integer integer: range) {
            actualNumbers[counter++] = integer;
        }
        assertTrue(Arrays.equals(expectedNumbers, actualNumbers));

    }

    @Test
    public void shouldReturnFiveExactIntegersWithIterator() {
        RangeWithStep range = new RangeWithStep(1, 10, 2);
        int[] expectedNumbers = {1, 3, 5, 7, 9};
        int[] actualNumbers = new int[5];
        int counter = 0;
        Iterator<Integer> iterator = range.iterator();
        while (iterator.hasNext()) {
            actualNumbers[counter++] = iterator.next();
        }
        assertTrue(Arrays.equals(expectedNumbers, actualNumbers));

    }

    @Test
    public void shouldThrowUnsupportedOperationException() {
        RangeWithStep range = new RangeWithStep(1, 10, 2);
        Iterator<Integer> iterator = range.iterator();

        Exception exception = assertThrows(UnsupportedOperationException.class, () -> {
            iterator.remove();
        });

        String expectedMessage = "remove";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));

    }
}
