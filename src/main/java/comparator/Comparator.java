package comparator;

public interface Comparator<T> {

    /**
     * Compares two provided objects
     * @param o1 First param to compare
     * @param o2 Second param to compare
     * @return Negative value if first provided object is "bigger", Positive value if second param is "bigger", 0 if objects are equal
     */
    int compare(T o1, T o2);

}
