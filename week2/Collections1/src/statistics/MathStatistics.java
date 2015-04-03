package statistics;

import java.util.ArrayList;
import java.util.List;

public class MathStatistics implements Statistics{
    private List<Integer> list;
    public MathStatistics(){
        list=new ArrayList<Integer>();
    }
    @Override
    public int getMean() {
        int sum=0;
        for(int i=0; i<list.size(); i++)
            sum+=list.get(i);
        sum/=list.size();
        return sum;
    }

    @Override
    public int getMedian() {
        List<Integer>tmpList=list;
        tmpList.sort(null);
        int tmpSize=tmpList.size();
        if(tmpSize%2==1)return tmpList.get(tmpSize/2+1);
        else return tmpList.get(tmpSize/2);
    }
    private int countOccurrances(List<Integer> tmpList,Integer number){
        int counter=0;
        for(int i=0; i<tmpList.size(); i++){
            if(number.equals(tmpList))counter++;
        }
        return counter;
    }
    @Override
    public int getMode() {
        List<Integer>tmpList=list;
        tmpList.sort(null);
        int maxOccurredElement=tmpList.get(0),maxOccurrances=1;
        for(int i=0; i<tmpList.size(); i++){
            int occurrances=countOccurrances(tmpList, tmpList.get(i));
            if(occurrances>=maxOccurrances){
                maxOccurrances=occurrances;
                maxOccurredElement=tmpList.get(i);
            }
        }
        return maxOccurredElement;
    }

    @Override
    public int getRange() {
        List<Integer>tmpList=list;
        tmpList.sort(null);
        return tmpList.get(tmpList.size()-1)-tmpList.get(0);
    }

    @Override
    public void add(int number) {
        list.add(number);
    }
    public static void main(String[] args) {
        MathStatistics l=new MathStatistics();
        l.add(13);
        l.add(18);
        l.add(13);
        l.add(14);
        l.add(13);
        l.add(16);
        l.add(14);
        l.add(21);
        l.add(13);
        System.out.println("Mean:");
        System.out.println(l.getMean());
        System.out.println("Median:");
        System.out.println(l.getMedian());
        System.out.println("Mode:");
        System.out.println(l.getMode());
        System.out.println("Range:");
        System.out.println(l.getRange());
        //13, 18, 13, 14, 13, 16, 14, 21, 13
    }
}
