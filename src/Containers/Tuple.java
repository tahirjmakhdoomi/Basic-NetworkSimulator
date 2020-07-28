package Containers;

public class Tuple<T, U, W> {


    public Tuple(T first, U second, W third) {
        this.second = second;
        this.first = first;
        this.third = third;
    }

    public final T first;
    public final U second;
    public final W third;
    // Because 'pair()' is shorter than 'new Pair<>()'.
    // Sometimes this difference might be very significant (especially in a
    // 80-ish characters boundary). Sorry diamond operator.
    public static <T, U, W> Tuple<T, U,W> pair(T first, U second, W third) {
        return new Tuple<>(first, second,third);
    }

    public String toString() {
        return "(" + first + ", " + second +"," + third + ")";
    }
}