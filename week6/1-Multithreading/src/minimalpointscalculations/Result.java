package minimalpointscalculations;

public class Result {
    private Point point;
    private double distance;
    public Result(Point point,double distance){
        this.point=point;
        this.distance=distance;
    }
    public Point getPoint(){
        return this.point;
    }
    public double getDistance(){
        return this.distance;
    }
}
