package pl.sdacademy.java.advance.exercises.day1.task1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Task1 {
    /*
    compareTo zwraca:
    0, gdy o1 równe o2
    <0, gdy o2 większe od o1, tzn A jest przed B
    >0, gdy 01 większe od o2, tzn B jest przed A
     */
    public static List<String> sortUsingAnonymousClass(final List<String> unsorted) {
        List<String> sorted = new ArrayList<>(unsorted);
        Collections.sort(sorted, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
                //return -o1.compareTo(o2);
            }
        });
        return sorted;
    }

    public static List<String> sortUsingOwnComparator(final List<String> unsorted) {
        List<String> sorted = new ArrayList<>(unsorted);
        Collections.sort(sorted, new MyOwnComparator());
        return sorted;
    }

    public static List<String> sortUsingLambda(final List<String> unsorted) {
        List<String> sorted = new ArrayList<>(unsorted);
        Collections.sort(sorted, (o1, o2) -> o2.compareTo(o1));
        return sorted;
    }

    public static List<String> sortUsingStream(final List<String> unsorted) {
        List<String> sorted = new ArrayList<>(unsorted);
        return sorted.stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
    }

    public static List<String> sortOnList(final List<String> unsorted) {
        List<String> sorted = new ArrayList<>(unsorted);
        //Collections.sort(sorted, Collections.reverseOrder());
        sorted.sort(Comparator.reverseOrder());
        return sorted;
    }
}