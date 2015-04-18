package time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Time {
    private int hours;
    private int minutes;
    private int seconds;
    private int day;
    private int month;
    private int year;
    public Time(int hours,int minutes,int seconds,int day,int month,int year){
        try{
            if(hours<1 || hours>23 || minutes<0 || minutes>59 || seconds<0 || seconds>59)
                throw new Exception();
            if(day<1 || day>31 || month<1 || month>12 || year<0)
                throw new Exception();
        this.hours=hours;
        this.minutes=minutes;
        this.seconds=seconds;
        this.day=day;
        this.month=month;
        this.year=year;}
        catch(Exception e){
            e.printStackTrace();
        }
    }
    @Override
    public String toString(){
        DateFormat dateFormat = new SimpleDateFormat("hh:mm:ss dd.MM.YY");
        Date date = new Date();
        return dateFormat.format(date);
    }
    public void GetTimeAndDate(){
        //hh:mm:ss dd.MM.YY
        DateFormat dateFormat = new SimpleDateFormat("hh:mm:ss dd.MM.YY");
        Date date = new Date();
        System.out.println(dateFormat.format(date)); 
    }
    public static void main(String [] args){
        Time t=new Time(0,12,56,3,7,1995);
        System.out.println(t.toString());
    }
}
