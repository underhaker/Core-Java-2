package time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import pairs.Pair;
public class Time implements TimeProperties{
    private int hours;
    private int minutes;
    private int seconds;
    private int day;
    private int month;
    private int year;
    Time(int hours,int minutes,int seconds,int day,int month,int year){
        this.hours=hours;
        this.minutes=minutes;
        this.seconds=seconds;
        this.day=day;
        this.month=month;
        this.year=year;
    }
    @Override
    public String toString(){
        DateFormat dateFormat = new SimpleDateFormat("hh:mm:ss dd.MM.YY");
        Date date = new Date();
        return dateFormat.format(date);
    }
    @Override
    public void GetTimeAndDate(){
       /*Date d=new Date();
       this.hours=d.getHours();
       this.minutes=d.getMinutes();
       this.seconds=d.getSeconds();
       this.day=d.getDay();
       this.month=d.getMonth();
       this.year=d.getYear();
       */
        //hh:mm:ss dd.MM.YY
        DateFormat dateFormat = new SimpleDateFormat("hh:mm:ss dd.MM.YY");
        Date date = new Date();
        System.out.println(dateFormat.format(date)); 
    }
    public static void main(String [] args){
        Time t=new Time(1,1,1,1,1,1);
        System.out.println(t.toString());
    }
}
