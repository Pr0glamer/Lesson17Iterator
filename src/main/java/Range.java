import java.util.Iterator;
import java.util.NoSuchElementException;

public class Range implements Iterable<Integer> {

    private int start;
    private int end;

    public Range(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new RangeIterator();
    }

    class RangeIterator implements Iterator<Integer> {

        int current;

        public RangeIterator() {
            this.current = start;
        }

        @Override
        public boolean hasNext() {
            return current <= end;
        }

        @Override
        public Integer next() {
            if(hasNext()) {
                return current++;
            }
            throw new NoSuchElementException();
        }
    }

    public static void main(String[] args) {
        Range range = new Range(1, 20);
        for(Integer integer: range) {
            System.out.println(integer);
        }
    }


}
