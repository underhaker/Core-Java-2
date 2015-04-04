package pairs;

public  final class Pair {

    private final Object first;
    private final Object second;
    private Pair(Object ob1,Object ob2){
        this.first=ob1;
        this.second=ob2;
        //if(ob1.e)
    }
    public Object GetFirstMember(){
        return this.first;
    }
    public Object GetSecondMember(){
        return this.second;
    }
    
    //@Override
    public String toString(){
        return this.first.toString()+ this.second.toString();
    }
    @Override
    public boolean equals(Object obj){
        if(this==obj)return true;
        if(obj instanceof Pair){
            Pair p1=(Pair) obj;
            if(this.first==p1.first && this.second==p1.second)return true;
        }
        return false;
    }
    public static void main(String [] args){
        Object obj1=(Integer)100;
        Object obj2=(Integer)120;
        Pair p1=new Pair("100",obj2);
        Pair p2=new Pair("100",obj2);
        System.out.println(p1.toString());
        
    }
}
