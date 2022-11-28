import java.util.Iterator;
import java.util.NoSuchElementException;

public class RangeWithStep implements Iterable<Integer> {

    private int start;
    private int end;
    private int step;

    public RangeWithStep(int start, int end, int step) {
        this.start = start;
        this.end = end;
        this.step = step;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new RangeWithStepIterator();
    }

    class RangeWithStepIterator implements Iterator<Integer> {

        int current;

        public RangeWithStepIterator() {
            this.current = start;
        }

        @Override
        public boolean hasNext() {
            return current <= end;
        }

        @Override
        public Integer next() {
            if(hasNext()) {
                int cursor = current;
                current+=step;
                return cursor;
            }
            throw new NoSuchElementException();
        }
    }

    public static void main(String[] args) {
        RangeWithStep range = new RangeWithStep(1, 5, 2);
        for(Integer integer: range) {
            System.out.println(integer);
        }
    }


}
