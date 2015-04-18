package immutableList;

import java.util.ArrayList;
import java.util.Collection;
import java.util.function.Predicate;

public final class Immutable<E> extends ArrayList<E> {
    /**
     * 
     */
    private static final long serialVersionUID = 7087419831007793678L;
    /**
     * 
     */
    private ArrayList<E> al=new ArrayList<E>();
    public Immutable(Collection<? extends E> collection){
        al.addAll(collection);
    }
    @Override
    public boolean add(E e) {
        throw new ImmutableException("Immutable class:cannot modify elements.");
        //return super.add(e);
    }
    @Override
    public boolean addAll(Collection<? extends E> c) {
        throw new ImmutableException("Immutable class:cannot modify elements.");
        //Collection<? extends E> collection
        // TODO Auto-generated method stub
        //return super.addAll(c);
    }
    @Override
    public void add(int index, E element) {
        throw new ImmutableException("Immutable class:cannot modify elements.");
        // TODO Auto-generated method stub
        //super.add(index, element);
    }
    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        // TODO Auto-generated method stub
        //return super.addAll(index, c);
        throw new ImmutableException("Immutable class:cannot modify elements.");
    }
    @Override
    public E remove(int index) {
        // TODO Auto-generated method stub
        //return super.remove(index);
        throw new ImmutableException("Immutable class:cannot modify elements.");
    }
    @Override
    public E get(int index) {
        return null;
        // TODO Auto-generated method stub
        //throw new ImmutableException();
    }
    
    @Override
    public boolean remove(Object o) {
        throw new ImmutableException("Immutable class:cannot modify elements.");
    }
    @Override
    public boolean removeIf(Predicate<? super E> filter) {
        throw new ImmutableException("Immutable class:cannot modify elements.");
    }
    @Override
    public boolean removeAll(Collection<?> c) {
        throw new ImmutableException("Immutable class:cannot modify elements.");
    }

}
