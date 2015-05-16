package minimalpointscalculations;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

import static java.lang.Math.sqrt;

public class PointCalculations {

    public static List<Point> generatePoints() {
        List<Point> l = new ArrayList<Point>();
        Random rand = new Random();
        for (int i = 0; i < 100_000; i++) {
            int x = rand.nextInt(10_001);
            int y = rand.nextInt(10_001);
            Point p = new Point(x, y);
            l.add(p);
        }
        return l;
    }

    public static Map<Point, Point> getNearestPoints(final List<Point> generatedPoints) throws Exception {
        final Map<Point, Point> hm = new ConcurrentHashMap<Point, Point>();
        Thread t1 = new Thread(new Runnable() {

            @Override
            public void run() {
                System.out.println("from:" + 0 + ",to:" + generatedPoints.size() / 4);
                doCalculations(generatedPoints, 0, generatedPoints.size() / 4, hm);
            }

        });
        Thread t2 = new Thread(new Runnable() {

            @Override
            public void run() {
                System.out.println("from:" + generatedPoints.size() / 4 + ",to:" + generatedPoints.size() / 2);
                doCalculations(generatedPoints, generatedPoints.size() / 4, generatedPoints.size() / 2, hm);

            }

        });
        Thread t3 = new Thread(new Runnable() {

            @Override
            public void run() {
                System.out.println("from:" + generatedPoints.size() / 2 + ",to:"
                        + (generatedPoints.size() / 2 + generatedPoints.size() / 4));
                doCalculations(generatedPoints, generatedPoints.size() / 2, generatedPoints.size() / 2
                        + generatedPoints.size() / 4, hm);
            }

        });
        Thread t4 = new Thread(new Runnable() {

            @Override
            public void run() {
                System.out.println("from:" + (generatedPoints.size() / 2 + generatedPoints.size() / 4) + ",to:"
                        + generatedPoints.size());
                doCalculations(generatedPoints, generatedPoints.size() / 2 + generatedPoints.size() / 4,
                        generatedPoints.size(), hm);

            }

        });
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t1.join();
        t2.join();
        t3.join();
        t4.join();
        return hm;
    }

    public static void doCalculations(List<Point> inPoints, int indexFrom, int indexTo,
            Map<Point, Point> outMap) {
        Double distance = 0.0, minDistance = 10_000_000.0;
        Point p = null, p1, minPoint = null;
        for (int i = indexFrom; i < indexTo; i++) {
            p = inPoints.get(i);
            minDistance = 10_000_000.0;
            for (int j = indexFrom; j < indexTo; j++) {
                p1 = inPoints.get(j);
                if (p.equals(p1))
                    continue;
                distance = sqrt((p.getX() - p1.getX()) * (p.getX() - p1.getX()) + (p.getY() - p1.getY())
                        * (p.getY() - p1.getY()));
                if (distance <= minDistance) {
                    minDistance = distance;
                    minPoint = p1;
                }
            }
            outMap.put(p, minPoint);
        }
    }

    public static void main(String[] args) throws Exception {
        long startTime = System.currentTimeMillis();
        Map<Point, Point> hm = getNearestPoints(generatePoints());
        System.out.println(hm.size());
        System.out.println("time:" + (System.currentTimeMillis() - startTime));
    }
}
