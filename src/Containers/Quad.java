package Containers;

public class Quad<T, U, W,X> {


    public Quad(T first, U second, W third,X forth) {
        this.second = second;
        this.first = first;
        this.third = third;
        this.forth = forth;
    }

    public final T first;
    public final U second;
    public final W third;
    public final X forth;
    // Because 'pair()' is shorter than 'new Pair<>()'.
    // Sometimes this difference might be very significant (especially in a
    // 80-ish characters boundary). Sorry diamond operator.
    public static <T, U, W,X> Quad<T, U,W,X> pair(T first, U second, W third,X forth) {
        return new Quad<>(first, second,third,forth);
    }

    public String toString() {
        return "(" + first + ", " + second +"," + third +"," + forth + ")";
    }
}