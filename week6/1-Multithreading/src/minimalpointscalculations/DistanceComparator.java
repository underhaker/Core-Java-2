package minimalpointscalculations;

import java.util.Comparator;

public class DistanceComparator implements Comparator<Result> {

    @Override
    public int compare(Result arg0, Result arg1) {
        if(arg0.getDistance()<=arg1.getDistance())return -1;
        else return 1;
    }
    
}
