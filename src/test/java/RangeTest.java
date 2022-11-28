import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class RangeTest {

    @Test
    public void shouldReturnTenIntegersWithForeach() {
        Range range = new Range(1, 10);
        List<Integer> listOfInts = new ArrayList<>();
        for(Integer integer: range) {
            listOfInts.add(integer);
        }
        assertEquals(listOfInts.size(), 10);

    }

    @Test
    public void shouldReturnTenIntegersWithIterator() {
        Range range = new Range(1, 10);
        List<Integer> listOfInts = new ArrayList<>();
        Iterator<Integer> iterator = range.iterator();
        while (iterator.hasNext()) {
            listOfInts.add(iterator.next());
        }
        assertEquals(listOfInts.size(), 10);

    }

    @Test
    public void shouldThrowUnsupportedOperationException() {
        Range range = new Range(1, 10);
        Iterator<Integer> iterator = range.iterator();

        Exception exception = assertThrows(UnsupportedOperationException.class, () -> {
            iterator.remove();
        });

        String expectedMessage = "remove";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));

    }


}
