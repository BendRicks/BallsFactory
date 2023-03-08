import entity.*;
import org.junit.Assert;
import sort.HeapSort;
import sort.QuickSort;
import comparator.BallComparatorProvider;
import sort.MultiThreadSorter;

import java.util.HashMap;

public class Test {

    @org.junit.Test
    public void testMultiThreadSortHeapClasses(){
        MultiThreadSorter<Ball> sorter = new MultiThreadSorter<>(Ball.class,
                BallComparatorProvider.getClassComparator(new HashMap<>(){{
                    put(VolleyballBall.class, 1);
                    put(BasketballBall.class, 3);
                    put(FootballBall.class, 2);
                }}));
        Ball[] balls = new Ball[]{
                new FootballBall("football1", 8, 23, 23, Color.BLACK),
                new VolleyballBall("volleyball1", 13, 23, 23, Color.BLACK),
                new BasketballBall("basketball1", 11, 23, 23, Color.BLACK),
                new FootballBall("football2", 9, 23, 23, Color.BLACK),
                new FootballBall("football3", 10, 23, 23, Color.BLACK),
                new VolleyballBall("volleyball2", 19, 23, 23, Color.BLACK),
                new FootballBall("football4", 17, 23, 23, Color.BLACK),
                new BasketballBall("basketball2", 13, 23, 23, Color.BLACK),
                new VolleyballBall("volleyball3", 15, 23, 23, Color.BLACK),
                new BasketballBall("basketball3", 14, 23, 23, Color.BLACK),
                new FootballBall("football5", 16, 23, 23, Color.BLACK),
                new VolleyballBall("volleyball4", 18, 23, 23, Color.BLACK),
                new BasketballBall("basketball4", 22, 23, 23, Color.BLACK),
                new VolleyballBall("volleyball5", 21, 23, 23, Color.BLACK),
                new FootballBall("football6", 20, 23, 23, Color.BLACK),
        };
        Ball[] sorted = sorter.sortArrMultiThread(balls, new HeapSort<>(), 4);
        Assert.assertArrayEquals(sorted, new Ball[]{
                new VolleyballBall("volleyball3", 15, 23, 23, Color.BLACK),
                new VolleyballBall("volleyball4", 18, 23, 23, Color.BLACK),
                new VolleyballBall("volleyball5", 21, 23, 23, Color.BLACK),
                new VolleyballBall("volleyball1", 13, 23, 23, Color.BLACK),
                new VolleyballBall("volleyball2", 19, 23, 23, Color.BLACK),
                new FootballBall("football5", 16, 23, 23, Color.BLACK),
                new FootballBall("football6", 20, 23, 23, Color.BLACK),
                new FootballBall("football1", 8, 23, 23, Color.BLACK),
                new FootballBall("football2", 9, 23, 23, Color.BLACK),
                new FootballBall("football4", 17, 23, 23, Color.BLACK),
                new FootballBall("football3", 10, 23, 23, Color.BLACK),
                new BasketballBall("basketball3", 14, 23, 23, Color.BLACK),
                new BasketballBall("basketball4", 22, 23, 23, Color.BLACK),
                new BasketballBall("basketball1", 11, 23, 23, Color.BLACK),
                new BasketballBall("basketball2", 13, 23, 23, Color.BLACK),
        });

    }

    @org.junit.Test
    public void testMultiThreadSortHeap(){
        MultiThreadSorter<Ball> sorter = new MultiThreadSorter<>(Ball.class,
                BallComparatorProvider.getDiameterIncComparator());
        Ball[] balls = new Ball[]{
                new FootballBall("football1", 8, 23, 23, Color.BLACK),
                new VolleyballBall("volleyball1", 13, 23, 23, Color.BLACK),
                new BasketballBall("basketball1", 11, 23, 23, Color.BLACK),
                new FootballBall("football2", 9, 23, 23, Color.BLACK),
                new FootballBall("football3", 10, 23, 23, Color.BLACK),
                new VolleyballBall("volleyball2", 19, 23, 23, Color.BLACK),
                new FootballBall("football4", 17, 23, 23, Color.BLACK),
                new BasketballBall("basketball2", 13, 23, 23, Color.BLACK),
                new VolleyballBall("volleyball3", 15, 23, 23, Color.BLACK),
                new BasketballBall("basketball3", 14, 23, 23, Color.BLACK),
                new FootballBall("football5", 16, 23, 23, Color.BLACK),
                new VolleyballBall("volleyball4", 18, 23, 23, Color.BLACK),
                new BasketballBall("basketball4", 22, 23, 23, Color.BLACK),
                new VolleyballBall("volleyball5", 21, 23, 23, Color.BLACK),
                new FootballBall("football6", 20, 23, 23, Color.BLACK),
        };
        Ball[] sorted = sorter.sortArrMultiThread(balls, new HeapSort<>(), 4);
        Assert.assertArrayEquals(sorted, new Ball[]{
                new FootballBall("football1", 8, 23, 23, Color.BLACK),
                new FootballBall("football2", 9, 23, 23, Color.BLACK),
                new FootballBall("football3", 10, 23, 23, Color.BLACK),
                new BasketballBall("basketball1", 11, 23, 23, Color.BLACK),
                new VolleyballBall("volleyball1", 13, 23, 23, Color.BLACK),
                new BasketballBall("basketball2", 13, 23, 23, Color.BLACK),
                new BasketballBall("basketball3", 14, 23, 23, Color.BLACK),
                new VolleyballBall("volleyball3", 15, 23, 23, Color.BLACK),
                new FootballBall("football5", 16, 23, 23, Color.BLACK),
                new FootballBall("football4", 17, 23, 23, Color.BLACK),
                new VolleyballBall("volleyball4", 18, 23, 23, Color.BLACK),
                new VolleyballBall("volleyball2", 19, 23, 23, Color.BLACK),
                new FootballBall("football6", 20, 23, 23, Color.BLACK),
                new VolleyballBall("volleyball5", 21, 23, 23, Color.BLACK),
                new BasketballBall("basketball4", 22, 23, 23, Color.BLACK),
        });
    }

    @org.junit.Test
    public void testMultiThreadSortQuick(){
        MultiThreadSorter<Ball> sorter = new MultiThreadSorter<>(Ball.class,
                BallComparatorProvider.getDiameterIncComparator());
        Ball[] balls = new Ball[]{
                new FootballBall("football1", 8, 23, 23, Color.BLACK),
                new VolleyballBall("volleyball1", 13, 23, 23, Color.BLACK),
                new BasketballBall("basketball1", 11, 23, 23, Color.BLACK),
                new FootballBall("football2", 9, 23, 23, Color.BLACK),
                new FootballBall("football3", 10, 23, 23, Color.BLACK),
                new VolleyballBall("volleyball2", 19, 23, 23, Color.BLACK),
                new FootballBall("football4", 17, 23, 23, Color.BLACK),
                new BasketballBall("basketball2", 13, 23, 23, Color.BLACK),
                new VolleyballBall("volleyball3", 15, 23, 23, Color.BLACK),
                new BasketballBall("basketball3", 14, 23, 23, Color.BLACK),
                new FootballBall("football5", 16, 23, 23, Color.BLACK),
                new VolleyballBall("volleyball4", 18, 23, 23, Color.BLACK),
                new BasketballBall("basketball4", 22, 23, 23, Color.BLACK),
                new VolleyballBall("volleyball5", 21, 23, 23, Color.BLACK),
                new FootballBall("football6", 20, 23, 23, Color.BLACK),
        };
        Ball[] sorted = sorter.sortArrMultiThread(balls, new QuickSort<>(), 4);
        Assert.assertArrayEquals(sorted, new Ball[]{
                new FootballBall("football1", 8, 23, 23, Color.BLACK),
                new FootballBall("football2", 9, 23, 23, Color.BLACK),
                new FootballBall("football3", 10, 23, 23, Color.BLACK),
                new BasketballBall("basketball1", 11, 23, 23, Color.BLACK),
                new VolleyballBall("volleyball1", 13, 23, 23, Color.BLACK),
                new BasketballBall("basketball2", 13, 23, 23, Color.BLACK),
                new BasketballBall("basketball3", 14, 23, 23, Color.BLACK),
                new VolleyballBall("volleyball3", 15, 23, 23, Color.BLACK),
                new FootballBall("football5", 16, 23, 23, Color.BLACK),
                new FootballBall("football4", 17, 23, 23, Color.BLACK),
                new VolleyballBall("volleyball4", 18, 23, 23, Color.BLACK),
                new VolleyballBall("volleyball2", 19, 23, 23, Color.BLACK),
                new FootballBall("football6", 20, 23, 23, Color.BLACK),
                new VolleyballBall("volleyball5", 21, 23, 23, Color.BLACK),
                new BasketballBall("basketball4", 22, 23, 23, Color.BLACK),
        });
    }

}
