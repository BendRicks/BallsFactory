package util;

import entity.Ball;

import java.util.HashMap;

public class BallComparatorProvider {

    public static Comparator<Ball> getDiameterIncComparator(){
        return (o1, o2) -> Integer.compare(o2.getDiameter(), o1.getDiameter());
    }

    public static Comparator<Ball> getDiameterDescComparator(){
        return (o1, o2) -> Integer.compare(o1.getDiameter(), o2.getDiameter());
    }

    public static Comparator<Ball> getWeightIncComparator(){
        return (o1, o2) -> Integer.compare(o2.getWeight(), o1.getWeight());
    }

    public static Comparator<Ball> getWeightDescComparator(){
        return (o1, o2) -> Integer.compare(o1.getWeight(), o2.getWeight());
    }

    public static Comparator<Ball> getPressureIncComparator(){
        return (o1, o2) -> Integer.compare(o2.getPressure(), o1.getPressure());
    }

    public static Comparator<Ball> getPressureDescComparator(){
        return (o1, o2) -> Integer.compare(o1.getPressure(), o2.getPressure());
    }

    public static Comparator<Ball> getColorIncComparator(){
        return (o1, o2) -> Byte.compare(o2.getColor().getRgb()[1], o1.getColor().getRgb()[1]);
    }

    public static Comparator<Ball> getColorDescComparator(){
        return (o1, o2) -> Byte.compare(o1.getColor().getRgb()[1], o2.getColor().getRgb()[1]);
    }

    public static Comparator<Ball> getNameIncComparator(){
        return (o1, o2) -> o2.getModelName().compareTo(o1.getModelName());
    }

    public static Comparator<Ball> getNameDescComparator(){
        return (o1, o2) -> o1.getModelName().compareTo(o2.getModelName());
    }

    /**
     * @param classesOrder Hashmap that tells order of classes sort Class - Order number
     */
    public static Comparator<Ball> getClassComparator(HashMap<Class, Integer> classesOrder){
        return new Comparator<>() {

            private HashMap<Class, Integer> order = classesOrder;

            @Override
            public int compare(Ball o1, Ball o2) {
                return order.get(o2.getClass()).compareTo(order.get(o1.getClass()));
            }
        };
    }

}