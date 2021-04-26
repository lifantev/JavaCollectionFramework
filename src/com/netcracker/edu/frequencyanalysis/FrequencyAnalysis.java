package com.netcracker.edu.frequencyanalysis;

import java.util.Collections;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

/**
 * <br>Class performs a frequency analysis of characters from two strings.<br/>
 *
 * It provides three variants for working with given strings:
 * <li> {@link #charsIntersection(String, String, Order)} returns set of characters,
 * included in both the first and second lines.
 * <li> {@link #charsDifference(String, String, Order)} returns set of characters,
 * included in the first and not included in the second.
 * <li> {@link #charsUnion(String, String, Order)} set of characters,
 * which are contained in at least one line.
 * <br>
 * <br>Also all methods allow adjusting order of characters in resulted sets.
 * There are two possible options: natural order {@link Order#NATURAL}
 * and reversed order {@link Order#REVERSED}.<br/>
 */
public class FrequencyAnalysis{
    /**
     * Two possible sort orders.
     */
    public enum Order {NATURAL, REVERSED};

    /**
     * Calculates intersection of two strings, i.e.
     * characters, included in both the first and second lines.
     * @param str1
     * @param str2
     * @param order sorting order of characters in resulting set.
     * @return result characters as a Set.
     * @throws IllegalArgumentException if str1 or str2 is null.
     */
    static public Set<Character> charsIntersection(String str1, String str2, Order order)
            throws IllegalArgumentException{

        if (str1 == null || str2 == null)
            throw new IllegalArgumentException("Analyzed strings can't be null.");

        Set<Character> chars1 = stringToCharSet(str1, order);
        Set<Character> chars2 = stringToCharSet(str2, order);
        chars1.retainAll(chars2);
        return chars1;
    }

    /**
     * Calculates difference of two strings, i.e.
     * characters, included in the first and not included in the second.
     * @param str1
     * @param str2
     * @param order sorting order of characters in resulting set.
     * @return result characters as a Set.
     * @throws IllegalArgumentException if str1 or str2 is null.
     */
    static public Set<Character> charsDifference(String str1, String str2, Order order)
            throws IllegalArgumentException{

        if (str1 == null || str2 == null)
            throw new IllegalArgumentException("Analyzed strings can't be null.");

        Set<Character> chars1 = stringToCharSet(str1, order);
        Set<Character> chars2 = stringToCharSet(str2, order);
        chars1.removeAll(chars2);
        return chars1;
    }

    /**
     * Calculates union of two strings, i.e.
     * characters, which are contained in at least one line.
     * @param str1
     * @param str2
     * @param order sorting order of characters in resulting set.
     * @return result characters as a Set.
     * @throws IllegalArgumentException if str1 or str2 is null.
     */
    static public Set<Character> charsUnion(String str1, String str2, Order order)
            throws IllegalArgumentException{

        if (str1 == null || str2 == null)
            throw new IllegalArgumentException("Analyzed strings can't be null.");

        Set<Character> chars1 = stringToCharSet(str1, order);
        Set<Character> chars2 = stringToCharSet(str2, order);
        chars1.addAll(chars2);
        return chars1;
    }

    /**
     * Adds characters from String to Set.
     * @param str
     * @param order sorting order of characters in resulting set.
     * @return resulting Set of characters.
     * @throws IllegalArgumentException if order doesn't match to any defined ones.
     */
    static private Set<Character> stringToCharSet (String str, Order order)
            throws IllegalArgumentException{

        Set<Character> set;
        switch (order) {
            case NATURAL:
                set = new TreeSet<>();
                break;
            case REVERSED:
                set = new TreeSet<>(Comparator.reverseOrder());
                break;
            default:
                throw new IllegalArgumentException("Unsupported order.");
        }
        for (Character c : str.toCharArray()) {
            set.add(c);
        }
        return set;
    }

    public static void main(String[] args) {
        String s1 = "ab cdef12 345%^ .,-";
        String s2 = "qwert cdef12 ][/..,,--";

        System.out.println("\nIntersection:");
        charsIntersection(s1, s2, Order.NATURAL).stream().forEach(c -> System.out.print(c));
        System.out.println();
        charsIntersection(s1, s2, Order.REVERSED).stream().forEach(c -> System.out.print(c));
        System.out.println();

        System.out.println("\nDifference:");
        charsDifference(s1, s2, Order.NATURAL).stream().forEach(c -> System.out.print(c));
        System.out.println();
        charsDifference(s1, s2, Order.REVERSED).stream().forEach(c -> System.out.print(c));
        System.out.println();

        System.out.println("\nUnion:");
        charsUnion(s1, s2, Order.NATURAL).stream().forEach(c -> System.out.print(c));
        System.out.println();
        charsUnion(s1, s2, Order.REVERSED).stream().forEach(c -> System.out.print(c));
        System.out.println();
    }
}
