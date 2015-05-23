package spliterator;

import java.util.Arrays;
import java.util.Collection;
import java.util.Spliterator;
import java.util.stream.StreamSupport;

public class MySpliterator {
    private static final int SLIDING_LENGTH = 2;

    public static void main(String[] args) {
        Collection<String> testCollection = Arrays.asList("This", "is", "a", "lame", "example", "of", "using", "a","spliterator");
        Spliterator<String> yourSpliterator = new SlidingWindowSpliterator<String>(testCollection, SLIDING_LENGTH); 
        StreamSupport.stream(yourSpliterator, false).forEach(System.out::println);
    }
}
