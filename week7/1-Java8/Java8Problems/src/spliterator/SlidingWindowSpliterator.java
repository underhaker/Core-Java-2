package spliterator;

import java.util.Collection;
import java.util.Spliterator;
import java.util.function.Consumer;

public class SlidingWindowSpliterator<T> implements Spliterator<T> {
    private Collection<String> array;
    private final int splitter;
    private int origin; 
    private final int fence; 

    public SlidingWindowSpliterator(Collection<String> testCollection, int splitter) {
//        if(splitter<=0 || spliter>testCollection.s
        this.array = testCollection;
        this.splitter = splitter;
        this.origin = 0;
        this.fence = this.array.size();
    }

    @Override
    public int characteristics() {
        return ORDERED | SIZED | IMMUTABLE | SUBSIZED;
    }

    @Override
    public long estimateSize() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public boolean tryAdvance(Consumer action) {
        if (origin + splitter <= fence) {
            String str = "";
            for (int i = origin; i < origin + splitter-1; i++) {
                str += new StringBuilder(array.toArray()[i].toString() + " ").toString();
            }
            str+=new StringBuilder(array.toArray()[origin+splitter-1].toString()).toString();
            action.accept(str);
            origin++;
            return true;
        } else
            return false;
    }

    @Override
    public Spliterator<T> trySplit() {
        // int lo = origin;
        // if (lo + splitter > fence)
        // return null;
        // origin = lo + splitter;
        // return new SlidingWindowSpliterator<T>(array, splitter);
        return null;
    }

}
