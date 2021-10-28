package com.student.L00170333.CA1.Shapes;

/**
 * This Pair record was created for tracking X and Y points.
 * It is constructed using generics to allow for all kinds of future reuse.
 */
public record Pair<U, V>(U first, V second) {
    /**
     * Constructs a new <code>Pair</code> with the given values.
     *
     * @param first  the first element
     * @param second the second element
     */
    public Pair { }

    /**
     * @return the first element of the <code>Pair</code>
     */
    public U getFirst() {
        return first;
    }

    /**
     * @return the second element of the <code>Pair</code>
     */
    public V getSecond() {
        return second;
    }
}